package listener;

import java.util.List;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyResultRecorder extends Formatter {
    public static String script_name;     //���Խű��ļ�����
//    static List<MethodInfo> list = (List<MethodInfo>) new MethodInfo();  //���ÿһ������������ִ�н��
    public static String result;         //����ִ�н��
    public static int count_case = 0;     //������������
    public static int count_case_pass=0;  //��������ִ��ͨ������
    public static int count_case_fail=0;  //��������ִ�в�ͨ������
    public static int count_case_Ignore=0;//��������ִ�к�������
    public static long Runtime = 0;       //���������ű�ִ��ʱ��


    public long getRuntime() {
        return Runtime;
    }

    public void setRuntime(long runtime) {
        Runtime = runtime;
    }

    public int getCount_case_Ignore() {
        return count_case_Ignore;
    }

    public void setCount_case_Ignore(int count_case_Ignore) {
        this.count_case_Ignore = count_case_Ignore;
    }

    public int getCount_case() {
        return count_case;
    }

    public void setCount_case(int count_case) {
        this.count_case = count_case;
    }

    public int getCount_case_pass() {
        return count_case_pass;
    }

    public void setCount_case_pass(int count_case_pass) {
        this.count_case_pass = count_case_pass;
    }

    public int getCount_case_fail() {
        return count_case_fail;
    }

    public void setCount_case_fail(int count_case_fail) {
        this.count_case_fail = count_case_fail;
    }

    public String getScript_name() {
        return script_name;
    }

    public void setScript_name(String script_name) {
        this.script_name = script_name;
    }

//    public List<MethodInfo> getList() {
//        return list;
//    }

//    public void setList(List<MethodInfo> list) {
//        this.list = list;
//    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String format(LogRecord record) {
        return null;
    }

//    @Override
//    public String toString() {
//        return "MyResultRecorder [script_name=" + script_name + ", list=" + list + ", result=" + result + "]";
//    }
}