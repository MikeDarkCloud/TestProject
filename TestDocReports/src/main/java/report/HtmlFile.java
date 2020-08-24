package report;
import listener.MethodInfo;
import runcase.Execute;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

//import java.util.logging.SimpleFormatter;

/**
 * HtmlFile类：用于将测试用例结果写入到HTML报告中
 */
public class HtmlFile implements IFile {
	private MethodInfo methodInfo;
    private Logger logger = Logger.getLogger(HtmlFile.class.getName());
    private FileHandler fileHTML;

    public  HtmlFile(MethodInfo methodInfo){
    	this.methodInfo = methodInfo;
	}

     public void createLog(String p_logName ,boolean p_apped) throws IOException {
     	fileHTML = new FileHandler(p_logName,p_apped);
 		fileHTML.setFormatter(Execute.ht);
 		logger.addHandler(fileHTML);
     }

     @Override
     public void createLog(String p_logName) throws IOException {
     	fileHTML = new FileHandler(p_logName);
 		fileHTML.setFormatter(Execute.ht);
 		logger.addHandler(fileHTML);
     }

    @Override
	public void closeLog() {
		fileHTML.close();
//		MethodInfo.p_pass=0;
//		MethodInfo.p_fail=0;
		methodInfo.result="";
		methodInfo.expected="";
		methodInfo.actual="";
		fileHTML.close();
		
		
	}

	@Override
	public void write(String p_info, String p_expected,String p_actual)  {
		methodInfo.actual = p_actual;
		methodInfo.expected = p_expected;

		if(p_expected.equals(p_actual))
			methodInfo.result = "Pass";
		else
			methodInfo.result = "Fail";
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		

	}

	@Override
	public void write(String p_info) {
		// TODO Auto-generated method stub
		logger.info(p_info);
		
	}

	@Override
	public void write(String p_info, String p_result) {
		// TODO Auto-generated method stub

		methodInfo.result = p_result;
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		
	}

	

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String p_key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String p_section, String p_key) {
		// TODO Auto-generated method stub
		return null;
	}




	

	
	

}
