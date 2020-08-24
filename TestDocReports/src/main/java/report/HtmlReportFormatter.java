package report;

import runcase.Execute;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
//import java.util.logging.SimpleFormatter;

public class HtmlReportFormatter extends Formatter {

	private int i = 0;
	private long setStartTime; // log开始时间
	private long setEndTime; // log结束时间

	private final String HTML_HEADER = "<meta http-equiv=\"Content-Type\" content=\"textml; charset=utf-8\" /><!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"demo_report_style.css\"/>"
			+ "<html><head><title>测试报告</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			+ "<h1>测试报告</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>序号</b></th>"
			+ "<th><b>用例描述</b></th>"
			+ "<th><b>期待结果</b></th>"
			+ "<th><b>实际结果</b></th>"
			+ "<th><b>执行时间</b></th>" + "<th><b>状态</b></th>" + "</tr>";

	private int recordStep() {
		i = i + 1;
		return i;
	}

	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
//		buf.append("<div class=\"statistics\">");
		buf.append("<tr>");
		buf.append("<td>");
		buf.append(recordStep());
		buf.append("</td>");
		buf.append("<td>");
		// buf.append(calcDate(rec.getMillis()));
		// buf.append(' ');
		buf.append(formatMessage(rec));
		buf.append('\n');
		buf.append("</td>");
		buf.append("<td>");
		buf.append("methodInfo.expected");
		buf.append("</td>");
		buf.append("<td>");
		buf.append("methodInfo.actual");
		buf.append("</td>");
		buf.append("<td>");
		buf.append(HtmlUtil.getCalcDate(rec.getMillis()));
		buf.append("</td>");
		buf.append("<td>");
		if (Execute.re.result.matches("Pass") || Execute.re.result.matches("PASS")) {
			//RecordStore.result.equalsIgnoreCase(anotherString) //忽略大小写
//			MethodInfo.p_pass = MethodInfo.p_pass + 1;
			buf.append("<b>");
			buf.append("<font color=Green>");
			buf.append("methodInfo.result");
			buf.append("</font>");
			buf.append("</b>");
		} else if (Execute.re.result.matches("Fail") || Execute.re.result.matches("FAIL")) {
//			MethodInfo.p_fail = MethodInfo.p_fail + 1;
			buf.append("<b>");
			buf.append("<font color=Red>");
			buf.append("methodInfo.result");
			buf.append("</font>");
			buf.append("</b>");

			/*
			//在report中加截图后，定义的html文件格式
			buf.append("<tr>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("<a href=getScreenShotPath()><img src=getScreenShotPath() height=\"150\" /></a>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("</tr>");

		*/
		} else {
			buf.append("<b>");
			// buf.append("<font color=Black>");
			buf.append("");
			buf.append("</b>");

		}
		buf.append("</td>");
		buf.append("</tr>");
		buf.append("</div>\n");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return buf.toString();
	}


	public String getHead(Handler h) {
		this.setStartTime = System.currentTimeMillis();
		System.out.println("starttime: " + this.setStartTime);
		return HTML_HEADER;
	}


	public String getTail(Handler h) {
		this.setEndTime = System.currentTimeMillis();
		System.out.println("endtime: " + this.setEndTime);
		String HTML_Tail;
		//System.out.println(p_total);
		if (Execute.re.count_case > 0) {
			if (Execute.re.count_case_fail > 0) {
				// return HTML_Tail;
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;开始时间   ：" + HtmlUtil.getCalcDate(this.setStartTime)
						+ "<br>&nbsp;结束时间      ：" + HtmlUtil.getCalcDate(this.setEndTime)
						+ "<br>&nbsp;运行时间      ：" + HtmlUtil.getDeltaTime(this.setEndTime, this.setStartTime)
						+ "<br>&nbsp;执行用例      ：" + Execute.re.count_case
						+ "<br>&nbsp;用例成功      ：" + Execute.re.count_case_pass
				        + "<br>&nbsp;<font color=Red>用例失败      ：" + Execute.re.count_case_fail + "</font>"
						+ "<br>&nbsp;成功率(%) ：" + HtmlUtil.getPercnet(Execute.re.count_case_pass, Execute.re.count_case)
						+ "<br>&nbsp;<font color=Red>失败率(%) ：" + HtmlUtil.getPercnet(Execute.re.count_case_fail, Execute.re.count_case) + "</font>"
						+ "<br><br>"
						+ "</BODY></HTML>";
			} else {
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;开始时间   ："
						+ HtmlUtil.getCalcDate(this.setStartTime) + "<br>&nbsp;结束时间   ："
						+ HtmlUtil.getCalcDate(this.setEndTime) + "<br>&nbsp;运行时间   ："
						+ HtmlUtil.getDeltaTime(this.setEndTime, this.setStartTime)
						+ "<br>&nbsp;执行用例      ：" + Execute.re.count_case
						+ "<br>&nbsp;用例成功      ：" + Execute.re.count_case_pass
						+ "<br>&nbsp;用例失败      ：" + Execute.re.count_case_fail
						+ "<br>&nbsp;成功率(%) ：" + HtmlUtil.getPercnet(Execute.re.count_case_pass, Execute.re.count_case)
						+ "<br>&nbsp;失败率(%) ：" + HtmlUtil.getPercnet(Execute.re.count_case_fail, Execute.re.count_case)
						+ "<br><br>"
						+ "</BODY></HTML>";
			}
		}
		else{
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;用例执行异常！" + "<br><br>"
						+ "</BODY></HTML>";
			}
			return HTML_Tail;
		}
	}