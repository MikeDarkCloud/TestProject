package runcase;
import listener.ExecutionListener;
import listener.MyResultRecorder;
import org.junit.runner.JUnitCore;
import report.HtmlFile;
import report.HtmlReportFormatter;
import testcase.DocleverLoginTestCase;
import testcase.DocleverSettingTestCase;

import java.io.IOException;

public class Execute {
    //����һ��ȫ�ֵı���ģ��
    public static HtmlReportFormatter ht= new HtmlReportFormatter();
    public static MyResultRecorder re = new MyResultRecorder();

    public static void main(String[] args) throws IOException {
        run(DocleverLoginTestCase.class, DocleverSettingTestCase.class);
    }

    private static void run(Class<?>... classes) throws IOException {
        /**
         * ѭ��ִ�в����׼�
         */

        for (Class<?> clazz : classes) {
            JUnitCore runner = new JUnitCore();
            ExecutionListener listener = new ExecutionListener();
            runner.addListener(listener);
            runner.run(clazz);
        }
    }
}