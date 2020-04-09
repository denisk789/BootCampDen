package Com.expedia.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class expediaSearchP {
public static WebDriver driver=null;
	
	@FindBy (xpath="(//button[@class='btn-secondary btn-action t-select-btn'])[1]")
	WebElement selectTripButton;
	
	@FindBy (id="forcedChoiceNoThanks")
	WebElement noThanks;
	
	public expediaSearchP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void selectButtonClick() {
		selectTripButton.click();
	}
	public void noThanksClick() throws InterruptedException {
		noThanks.click();
	}

}
