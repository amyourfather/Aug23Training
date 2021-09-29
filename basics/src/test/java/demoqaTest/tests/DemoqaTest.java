package demoqaTest.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import demoqaTest.foundation.DriverDocPage;
import demoqaTest.pageObjects.DriverHomePage;
import demoqaTest.pageObjects.DriverLinkPage;
import demoqaTest.pageObjects.DriverRadioButtonPage;
import demoqaTest.pageObjects.DriverTextBoxPage;
import demoqaTest.pageObjects.DriverTrainingPage;
import framework.Testbase;

public class DemoqaTest extends Testbase{
	private DriverDocPage DriverDocPage;
	@Test
	public void CanFillInText() {
		DriverDocPage = new DriverDocPage(driver);
		String TextBoxUrl = "https://demoqa.com/text-box";
		String fullName = "benjamin";
		String email = "123@abc.com";
		String currentAddress = "123 main st";
		String permanentAddress = "none";
		String fullNamexpath = "//input[@id = 'userName']";
		String emailxpath = "//input[@id = 'userEmail']";
		String currentAddressxpath = "//textarea[@id = 'currentAddress']";
		String permanentAddressxpath = "//textarea[@id = 'permanentAddress']";
		String submitxpath = "//button[@id = 'submit']";
		String outputboarderxpath = "//div[@id = 'output']//div";
		String[] expectedResult = new String[4];
		expectedResult[0] = "Name:benjamin";
		expectedResult[1] = "Email:123@abc.com";
		expectedResult[2] = "Current Address :123 main st";
		expectedResult[3] = "Permananet Address :none";
		
		DriverTextBoxPage textBoxPage = (DriverTextBoxPage) DriverDocPage.NavigateToPage(TextBoxUrl);
		
		textBoxPage.FillInText(fullNamexpath, fullName);
		textBoxPage.FillInText(emailxpath, email);
		textBoxPage.FillInText(currentAddressxpath, currentAddress);
		textBoxPage.FillInText(permanentAddressxpath, permanentAddress);
		textBoxPage.Click(submitxpath);
		
		String[] result = textBoxPage.GetText(outputboarderxpath).split("\n");
		
		for(int i = 0; i < 4; i++) {
			assertEquals(result[i], expectedResult[i]);
		}
	}
	
	@Test
	public void CanClickRaidoText() {
		DriverDocPage = new DriverDocPage(driver);
		String radioPageUrl = "https://demoqa.com/radio-button";
		String yesbuttonxpath = "//label[@for = 'yesRadio']";
		String impressivebuttonxpath = "//label[@for = 'impressiveRadio']";
		String outputTextPath = "//p[@class='mt-3']";
		String basicOutputText = "You have selected ";
		
		
		DriverRadioButtonPage radioPage = (DriverRadioButtonPage) DriverDocPage.NavigateToPage(radioPageUrl);
		
		radioPage.Click(yesbuttonxpath);
		String yesOutput = radioPage.GetText(outputTextPath);
		radioPage.Click(impressivebuttonxpath);
		String impressiveOutput = radioPage.GetText(outputTextPath);
		
		assertEquals(basicOutputText + "Yes", yesOutput);
		assertEquals(basicOutputText + "Impressive", impressiveOutput);
	}
	
	@Test
	public void CanClickHyperLinkOnLinkPage() {
		DriverDocPage = new DriverDocPage(driver);
		String homePageUrl = "https://demoqa.com/";
		String linkPageUrl = "https://demoqa.com/links";
		String joinNowUrl = "https://www.toolsqa.com/selenium-training/";
		String createdXpath = "//a[@id='created']";
		//String responseXpath = "//p[@id='linkResponse']//text()";
		String responseXpath = "//div[@id='linkWrapper']//p[@id='linkResponse']";
		
		DriverLinkPage linkPage = (DriverLinkPage) DriverDocPage.NavigateToPage(linkPageUrl);
		String linkPageWindowHandle = driver.getWindowHandle();
		
		DriverHomePage homePage = linkPage.ClickToHome();
		assertEquals(driver.getCurrentUrl() ,homePageUrl);
		DriverTrainingPage trainingPage = homePage.ClickJoinNow();
		assertEquals(driver.getCurrentUrl() ,joinNowUrl);
		//switch back to links window
		linkPage = (DriverLinkPage) trainingPage.SwitchBackTo(linkPageUrl, linkPageWindowHandle);
		//click created
		linkPage.Click(createdXpath);
		//assert equals expect text
		String result = linkPage.GetText(responseXpath);
		//String[] response = linkPage.GetTexts(responseXpath);
		//String result = "";
		//for(int i = 0; i < response.length; i++) {
		//	result += response[i];
		//}
		
		assertEquals("Link has responded with staus 201 and status text Created", result);
		
	}
}
