package listener;

public class MethodInfo {
    public  String method_name;   //�����Եķ�������
    public  String result= "";       //��������ִ�н��
    public  String error_msg=null;    // ����ִ��ʧ��ԭ��
    public  Object expected="";  // �ڴ�ֵ
    public  Object actual="";    // ʵ��ֵ


    String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public Object getExpected() {
        return expected;
    }

    public void setExpected(Object expected) {
        this.expected = expected;
    }

    public Object getActual() {
        return actual;
    }

    public void setActual(Object actual) {
        this.actual = actual;
    }
    @Override
    public String toString() {
        return "MethodInfo [method_name=" + method_name + ", result=" + result + ", error_msg=" + error_msg + "]";
    }

}