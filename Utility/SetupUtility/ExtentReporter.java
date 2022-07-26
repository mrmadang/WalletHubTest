package SetupUtility;


import java.io.File;
import org.openqa.selenium.io.FileHandler;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.Date;
//import java.util.logging.FileHandler;

public class ExtentReporter extends DriverSetup
{
 public ExtentHtmlReporter HtmlReporter;
 public ExtentReports Extent;
 public ExtentTest Test;
 
 public void SetExtent()
 {
	 HtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/AutomationReport.html");
	 HtmlReporter.config().setDocumentTitle("Automation Report");
	 HtmlReporter.config().setReportName("Commons Automation");
	 HtmlReporter.config().setTheme(Theme.DARK);
	 Extent=new ExtentReports();
	 Extent.attachReporter(HtmlReporter);
	 Extent.setSystemInfo("Hostname", "LocalHost");
 }
 
 public void EndReport()
 {
	 Extent.flush();
	 
 }
 public void TearDownTest(ITestResult result)
 {
	 if(result.getStatus()==ITestResult.FAILURE)
	 {
		 Test.log(Status.FAIL, "Test Case failed is : "+result.getName());
		 Test.log(Status.FAIL, "Test Case failed is : "+result.getThrowable());
		 
		 String MethodName=result.getMethod().getMethodName();
		 String logText="<b>"+"TEST CASE"+MethodName.toUpperCase()+" FAILED"+"</b>";
		 Markup markUpHelper=MarkupHelper.createLabel(logText, ExtentColor.RED);
		 Test.fail(markUpHelper);
		 try {
			GetScreenshot(MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// String ScreenshotPath=
	 }
	 else if(result.getStatus()==ITestResult.SKIP)
	 {
		 Test.log(Status.SKIP , "Test case skip is "+result.getName());
		 String MethodName=result.getMethod().getMethodName();
		 String logText="<b>"+"TEST CASE: "+MethodName.toUpperCase()+" SKIPPED"+"</b>";
		 Markup markUpHelper=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
	 }
	 else if(result.getStatus()==ITestResult.SUCCESS)
	 {
		 String MethodName=result.getMethod().getMethodName();
		 String logText="<b>"+"TEST CASE : "+MethodName.toUpperCase()+" PASSED"+"</b>";
		 Markup markUpHelper=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		 Test.pass(markUpHelper);
	 }
	 
 }

 public static String GetScreenshot(String ScreenshotName) throws IOException
 {	 
	 String dateName = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date()); 	
	 TakesScreenshot ts=(TakesScreenshot)DriverSetup.getDriver();
	 File Source=ts.getScreenshotAs(OutputType.FILE);
	 String destination=System.getProperty("user.dir")+"/FailureScreenshot/"+ScreenshotName+dateName+".png";
	 File finalDestination=new File(destination);
	 FileHandler.copy(Source, finalDestination);//..copyFile(Source, finalDestination); 
	 return destination; 
	 
 }
 
 
 
}
