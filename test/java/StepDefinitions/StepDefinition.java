package StepDefinitions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.PageBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddIssue;
import pages.FillIssue;
import pages.HomePage;
import pages.IssuesPage;
import utils.Dateutil;
import utils.ExcelRead;
import utils.Screenshot;

public class StepDefinition extends PageBaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentTest logger;
	public static int testcase=1;
	
	HomePage hp = new HomePage(driver,logger);
	IssuesPage ip = new IssuesPage(driver,logger);
	AddIssue ai = new AddIssue(driver,logger);
	FillIssue fi = new FillIssue(driver,logger);
	Screenshot ss = new Screenshot();
	
	@Given("^Browser is Invoked$")
	public void browserInvoke() throws Exception {
		logger=returnLogger();
		logger = report.createTest("Scenario 1 : Login");
		driver = getWebDriver();
	}
	
	@Then("^User goes to https://pratesting.cognizant.com$")
	public void goToUrl() throws IOException, InterruptedException {
		openUrl();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Then("^User Enter credentials to Sign in$")
	public void signIn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,50);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		  "//*[@id=\"navbar\"]/div[3]/a")));
	}
	
	@Given("^Application Page Title is mainspring$")
	public void checkPageTitle1() throws Exception {
		hp=new HomePage(driver,logger);
		logger = report.createTest("Scenario 2: Mandatory Fields Check");
		implicitTimewait(30);
		getTitle("mainspring");
	}
	
	@Then("^User Navigate to menu icon$")
	public void user_Navigate_to_menu_icon() {
		hp.navToHamburger();
	}
	
	@Then("^User Navigate to CFO_Onsite section and click$")
	public void user_Navigate_to_CFO_Onsite_section_and_click() throws Exception {
	    hp.clickCFO();
	}
	
	@When("^Application Page Title is Project Details :CFO_Onsite$")
	public void checkPageTitle2() throws InterruptedException {
		String ExpectedTitle1 = "Project Details :CFO_Onsite";
		waitForElementTitle(ExpectedTitle1);
		getTitle(ExpectedTitle1);
	}
	
	@Then("^User Navigate to MONITOR section$")
	public void user_Navigate_to_MONITOR_section() {
		ip=new IssuesPage(driver,logger);
	    ip.navToMonitor();
	}
	
	@Then("^User Navigate to Issues Module and click$")
	public void user_Navigate_to_Issues_Module_and_click() throws Exception {
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ip.issues));
	    ip.clickIssues();
	}
	
	@Given("^Application Page Title is Issues List$")
	public void checkPageTitle3() throws InterruptedException {
		String ExpectedTitle = "Issues List";
		waitForElementTitle(ExpectedTitle);
		getTitle(ExpectedTitle);

	}
	
	@Then("^User Navigate to Add Issue icon and click$")
	public void navToAddIssue() throws Exception {
		ai=new AddIssue(driver,logger);
		waitforElement(ai.addIssue1);
		ai.addIssue1();
		Thread.sleep(2000);
	}
	
	@When("^Application Page Title is Issue Details :$")
	public void checkPageTitle4() throws InterruptedException {
		
		if(testcase<5) {
		logger=report.createTest("Scenario 4: Leaving a Mandatory Field Empty.");
		}
		else {
			logger=report.createTest("Scenario 5: Close the Browser");
		}
		testcase=testcase+1;
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String ExpectedTitle = "Issue Details :";
		wait.until(ExpectedConditions.titleIs(ExpectedTitle));
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
	}
	
	
	@Then("^User fills all the fields in the Issue Form$")
	public void user_fills_all_the_fields_in_the_Issue_Form() throws Exception {
	    logger=report.createTest("Scenario 3: Filling Issues Form with all Valid Details");
		utils.ExcelRead.fillForm("IssuesFormData.xlsx");
		fi=new FillIssue(driver,logger);
	    fi.setName(ExcelRead.Name);
	    fi.setDescription(ExcelRead.Description);
	    fi.setIssueCategory(ExcelRead.IssueCategory);
	    fi.setResponsibility(ExcelRead.Responsibility);
	    fi.setSeverity(ExcelRead.Severity);
	    fi.setPriority(ExcelRead.Priority);
	    fi.setDueDate(ExcelRead.DueDate);
	}
	
	@And("^User clicks Save button$")
	public void saveIssue() throws Exception {
	    
		fi.clickSave();
		fi.moveToId();
		Thread.sleep(2000);
	}
	
	@Then("^User Navigate to Add Issue icon and click for second time$")
	public void user_Navigate_to_Add_Issue_icon_and_click_for_second_time() {
		waitforElement(ai.addIssue2);
		ai.addIssue2();
		logger=report.createTest("Scenario 4: Leaving a Mandatory Field Empty.");
	}

	@Then("^User Enter Name \"([^\"]*)\"$")
	public void user_Enter_Name(String Name) {
		fi.setName(Name);
	}

	@Then("^User Enter Select Issue Category \"([^\"]*)\"$")
	public void user_Enter_Select_Issue_Category(String Issue_Category) {
		fi.setIssueCategory(Issue_Category);
	}

	@Then("^User Enter Select Responsibility \"([^\"]*)\"$")
	public void user_Enter_Select_Responsibility(String Responsibility) {
		fi.setResponsibility(Responsibility);
	}

	@Then("^User Enter Select Severity \"([^\"]*)\"$")
	public void user_Enter_Select_Severity(String Severity) {
		fi.setSeverity(Severity);
	}

	@Then("^User Enter Select Priority \"([^\"]*)\"$")
	public void user_Enter_Select_Priority(String Priority) {
		fi.setPriority(Priority);
	}

	@Then("^User Enter Select Due Date \"([^\"]*)\"$")
	public void user_Enter_Select_Due_Date(String Due_Date) {
		fi.setDueDate(Due_Date);
	}
	
	@Then("^User Enter Select Issue Type \"([^\"]*)\"$")
	public void user_Enter_Select_Issue_Type(String Issue_Type){
		fi.setIssueType(Issue_Type);
	}

	@Then("^User Enter Reported By \"([^\"]*)\"$")
	public void user_Enter_Reported_By(String Reported_By) {
		fi.setReportedBy(Reported_By);
	}
	
	@Then("^User clicks Save button and check for alerts$")
	public void user_clicks_Save_button_and_check_for_alerts() {
	    fi.clickSave();
	}
	
	
	@Then("^Handle Alerts$")
	public void handle_Alerts() throws AWTException{
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    try {
	    	ImageIO.write(image, "jpg", new File(System.getProperty("user.dir")+"\\screenshots\\"+Dateutil.getTimeStamp() + ".jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        alert.accept();
	}
	
		
	@Then("^Switch To Frame$")
	public void switchFrame()
	{
		driver.switchTo().frame(driver.findElement(By.id("contentframe")));
		reportPass("Frame switched");
	}
	

	@Then("^User Checks Save Button is Enabled$")
	public void user_Checks_Save_Button_is_Enabled() {
		if(driver.findElement(By.xpath("//*[@id=\"SaveBtn\"]")).isEnabled())
		{
			reportFail("Save button Not enabled");
		}
		else
		{
			reportPass("Save button enabled");
		}
	}
	
	@Then("^User Checks Save and Add Button is Enabled$")
	public void user_Checks_Save_And_Add_Button_is_Enabled() {
		if(driver.findElement(By.xpath("//*[@id=\"SaveAddNewBtn\"]")).isEnabled())
		{
			reportFail("After entering any field Save button Not enabled");
		}
		else
		{
			reportPass("After entering any field Save button enabled");
		}
	}
	
	@Then("^User Checks Save Button is Enabled after filling$")
	public void user_Checks_Save_Button_is_Enabled_after_filling() {
		if(driver.findElement(By.xpath("//*[@id=\"SaveBtn\"]")).isEnabled())
		{
			reportPass("Save button enabled");
		}
		else
		{
			reportFail("Save button Not enabled");
		}
	}
	
	
	@Then("^User Checks Description limit$")
	public void user_Checks_descriptionLimit() throws IOException {
		utils.ExcelRead.fillForm("IssuesFormData.xlsx");
	    fi.checkDescriptionLimit(ExcelRead.DescriptionLimit);
	}
	
	@Then("^User Checks IssueCatagory$")
	public void checkIssue() throws IOException{
		fi.checkIssueCategory("Internal");
		fi.checkIssueCategory("External");
	}

	@Then("^User Checks DueDate Limit$")
	public void checkDueDateLimit() throws IOException{
		    fi.dueDateLimit();
	}
	
	@Then("^User Checks Return Button$")
	public void user_Checks_Return_button() throws Exception {
		fi.clickReturn();
	}
	
	@Then("^Close the Browser$")
	public void closeBrowser() {
		
		closeDriver();
		report.flush();
		
	}
}






