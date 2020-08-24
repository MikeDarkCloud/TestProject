package listener;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import report.HtmlFile;
import runcase.Execute;

import java.io.IOException;
import java.util.List;

public class ExecutionListener extends RunListener {
    MyResultRecorder recorder;
    List<MethodInfo> list ;
    MethodInfo  methodInfo= new MethodInfo();
    HtmlFile hf = new HtmlFile(methodInfo);
    public ExecutionListener() throws IOException {
        this.hf.createLog("F:\\JavaProjectFile\\TestProject\\TestDocReports\\src\\main\\java\\repoers\\test11.html");
        recorder = new MyResultRecorder();

    }

    public void testRunStarted(Description description) throws Exception {
        /**
         * "---------开始执行用例前----------"
         */
        System.out.println("1111");
//        recorder = new MyResultRecorder();
    }

    public void testRunFinished(Result result) throws Exception {
        recorder.setResult(String.valueOf( result.wasSuccessful() ));
//        recorder.setList(list);
        recorder.setCount_case(recorder.getCount_case()+result.getRunCount());
        recorder.setCount_case_fail(recorder.getCount_case_fail()+result.getFailureCount());
        recorder.setCount_case_pass(recorder.getCount_case_pass()+(result.getRunCount()-result.getFailureCount()));
        recorder.setCount_case_Ignore(result.getIgnoreCount());
        recorder.setRuntime(result.getRunTime());
        TestRecorder.countCase = TestRecorder.countCase+recorder.getCount_case();
        TestRecorder.countFailCase = TestRecorder.countFailCase+recorder.getCount_case_fail();
        TestRecorder.countPassCase = TestRecorder.countPassCase+result.getFailureCount();
        hf.closeLog();  //关闭测试报告
    }

    public void testStarted(Description description) throws Exception {
        TestRecorder.i +=1;
        recorder.setScript_name(description.getClassName());
//        System.out.println(description.getMethodName() + " begin");
        methodInfo.setMethod_name(description.getMethodName());
    }

    public void testFinished(Description description) throws Exception {
//        System.out.println(description.getMethodName() + " end");
        hf.write(description.getMethodName(), "Pass", "Pass");
        list.add(methodInfo);
    }

    public void testFailure(Failure failure) throws Exception {
        methodInfo.setResult("false");
        methodInfo.setError_msg(failure.getMessage());
        hf.write(failure.getTestHeader(), "Fail",failure.getMessage());
    }

    public void testIgnored(Description description) throws Exception {

    }
}