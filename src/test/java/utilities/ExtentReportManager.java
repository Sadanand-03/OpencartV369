package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportName;
	
	public void onStart(ITestContext testContext) {
	   
		/*
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss");
		Date dt = new Date();
		String currentDateTimeStamp = df.format(dt);
		*/
		
		// above code in single line.
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		
		reportName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);		// specified the location for report generation.
		
		sparkReporter.config().setDocumentTitle("Opencart Automation Report");	//Title of the report.
		sparkReporter.config().setReportName("Opencart Functional Testing");	//Name of the report.
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
	
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	  }

	
	
	public void onTestSuccess(ITestResult result) {


		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());		// to display group in report
		test.log(Status.PASS,result.getName()+" got successfully executed");
		
		
	}
	
	public void onTestFailure(ITestResult result) {
	   
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
		String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	  }
	
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
				
	}
	
	public void onFinish(ITestContext context) {

		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		try {
			
			URL url = new URL("file:///"+System.getenv("user.dir")+"\\reports\\"+reportName);
			
			//Create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");		//This is only for Gmail only. It varies as per company credentials
			email.setSmtpPort(465);							//This is only for Gmail only. It varies as per company credentials
			email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password"));
			email.setSSLOnConnect(true);
			email.setFrom("pavanoltraining@gmail.com");		//Sender
			email.setSubject("Test Results");
			email.setMsg("Please find Attached Report...");	
			email.addTo("sadanand.sagar03@gmail.com");		//Receiver
			email.attach(url,"extent report","please check report...");
			email.send();		// send the email.
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

}
