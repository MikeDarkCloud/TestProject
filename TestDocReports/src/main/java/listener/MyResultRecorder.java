package listener;

import java.util.List;

public class MyResultRecorder {
    String script_name;     //���Խű��ļ�����
    List<MethodInfo> list;  //���ÿһ������������ִ�н��
    Boolean result;         //����ִ�н��
    int count_case = 0;     //������������
    int count_case_pass=0;  //��������ִ��ͨ������
    int count_case_fail=0;  //��������ִ�в�ͨ������
    int count_case_Ignore=0;//��������ִ�к�������
    long Runtime = 0;       //���������ű�ִ��ʱ��


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

    public List<MethodInfo> getList() {
        return list;
    }

    public void setList(List<MethodInfo> list) {
        this.list = list;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

//    @Override
//    public String toString() {
//        return "MyResultRecorder [script_name=" + script_name + ", list=" + list + ", result=" + result + "]";
//    }
}