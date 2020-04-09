package BootCampDen;

	import java.io.IOException;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Reporter;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import Com.expedia.auto.ExpediaHomeP;
import Com.expedia.auto.expediaBankInformation;
import Com.expedia.auto.expediaBooking;
import Com.expedia.auto.expediaNext;
import Com.expedia.auto.expediaSearchP;
	



	public class expediaBookingTest {
		
		public static WebDriver driver=null;
		
		@BeforeClass
		public void beforeClass() {
					
		}
		@BeforeMethod
		public void beforeMethod() {
			
			int browserChoise=1;
			//1 - Firefox
			//2 - Chrome
			
			
			switch (browserChoise) {
				case 1: 
				Reporter.log("Work Starts in Mozilla Firefox");
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kuria\\Desktop\\selenium\\BootCampDen\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break; 
				case 2: 
				Reporter.log("Work Starts in Google Chrome");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kuria\\Desktop\\selenium\\BootCampDen\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
						}
				
		}
		@Test
		@Parameters ({"url", "flyFrom", "flyTo","fNameMale","lNameMale","pNumberMale",
			"fNameFemale","lNameFemale","fNameChild","lNameChild","chName","cNumber"})
		public void test(String url, String flyFrom, String flyTo, String fNameMale,
				String lNameMale, String pNumberMale,  String fNameFemale,
				String lNameFemale, String fNameChild, String lNameChild,
				String chName, String cNumber)  throws InterruptedException, IOException  {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			ExpediaHomeP home=new ExpediaHomeP(driver);
			expediaSearchP search=new expediaSearchP(driver);
			expediaNext review=new expediaNext(driver);
			expediaBooking securePage=new expediaBooking(driver);
			expediaBankInformation provide=new expediaBankInformation(driver);
			
			//Expedia_home_page
			home.flightsTabClick();
			home.flyingFromNote(flyFrom);
			home.flyingToNote(flyTo);
			home.departingTabClick();
			home.departingDateClick();
			home.returningTabClick();
			home.returningDateClick();
			home.travelersAmntBtnClick();
			home.travelersAdultAddClick();
			home.travelersChildAddClick();
			home.travelersChildSelectAge();
			home.travelersCloseClick();
			home.searchButtonClick();
//			//Expedia_search_page
			String currentHandle=driver.getWindowHandle();
			Reporter.log("Before switchTab"+currentHandle);
			Thread.sleep(3000);
			search.selectButtonClick();
			
			search.selectButtonClick();
			Thread.sleep(2000);
			search.noThanksClick();
			//SwitchingTab
			Set<String>browserTabs=driver.getWindowHandles();
			
			for (String newTab:browserTabs) {
				if (newTab != currentHandle) {
					driver.switchTo().window(newTab);
				}
		}
			Reporter.log("After switchTab"+driver.getWindowHandle());
//			//Expedia_review_page
			
			review.continueBookingBtnClick();
//			//Expedia_SecureBooking_page
//				//1 Adult info
			securePage.firstNameFill0Send(fNameMale);
			securePage.lastNameFill0Send(lNameMale);
			securePage.phoneNumberFill0Send(pNumberMale);
			securePage.genderMale0Click();
			securePage.birthMonth0Select();
			securePage.birthDay0Select();
			securePage.birthYear0Select();
//				//2 Adult info
			securePage.firstNameFill1Send(fNameFemale);
			securePage.lastNameFill1Send(lNameFemale);
			securePage.genderFemale1Click();
			securePage.birthMonth1Select();
			securePage.birthDay1Select();
			securePage.birthYear1Select();
//				//Child info
			securePage.firstNameFill2Send(fNameChild);
			securePage.lastNameFill2Send(lNameChild);
			securePage.genderMale2Click();
			securePage.birthMonth2Select();
			securePage.birthDay2Select();
			securePage.birthYear2Select();
			
			securePage.yesEnsuranseClick();
//				//carHolder info
			provide.cardHolderNameSend(chName);
			provide.cardNumberSend(cNumber);
			provide.cardExpMonthSelect();
			provide.cardExpYearSelect();
			provide.cardSecureNumberSend();
			provide.billingStreetSend();
			provide.billingCitySend();
			provide.billingStateSelect();
			provide.billingZipSend();
//				//password
			securePage.passwordFillSend();
			securePage.passwordRepeatSend();
			
			}
					
		@AfterMethod
		public void afterMethod() throws InterruptedException {
			Thread.sleep(5000);
			driver.quit();
		}
		
	}

