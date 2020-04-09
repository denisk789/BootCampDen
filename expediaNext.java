package Com.expedia.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class expediaNext {
	public static WebDriver driver=null;
	
	@FindBy (xpath="//button[@class='btn-primary btn-action bookButton']")
	WebElement continueBookingBtn;
	
	public expediaNext(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void continueBookingBtnClick() {
		continueBookingBtn.click();
	}


}
