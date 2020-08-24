package runcase;
import org.junit.runner.JUnitCore;
import testcase.DocleverLoginTestCase;
import testcase.DocleverSettingTestCase;

import java.io.IOException;

public class Execute {

    public static void main(String[] args) throws IOException {
        run(DocleverLoginTestCase.class, DocleverSettingTestCase.class);
    }

    private static void run(Class<?>... classes) throws IOException {

        for (Class<?> clazz : classes) {
            JUnitCore runner = new JUnitCore();
            ExecutionListener listener = new ExecutionListener();
            runner.addListener(listener);
            runner.run(clazz);
//            MyResultRecorder recorder = listener.recorder;
//            System.out.println(recorder);
        }
    }
}