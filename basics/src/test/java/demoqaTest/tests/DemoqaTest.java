package demoqaTest.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import demoqaTest.foundation.DriverDocPage;
import demoqaTest.pageObjects.DriverTextBoxPage;
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
}
