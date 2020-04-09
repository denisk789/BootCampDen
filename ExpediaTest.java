package BootCampDen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
public class ExpediaTest {
	WebDriver driver;
  @Test
  public void f()throws InterruptedException {
driver.navigate().to("https://www.expedia.com/");
driver.findElement(By.xpath("//*[@id='primary-header-flight']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='flight-origin-flp']")).clear();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='flight-origin-flp']")).sendKeys("Philadelphia");
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@data-value='Philadelphia, PA (PHL-Philadelphia Intl.)']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='flight-destination-flp']")).sendKeys("Miami");
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='aria-option-0']/div[2]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id='flight-departing-wrapper-flp']/label/span[2]/span")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//*[@data-day='7'])[2]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@name='endDate']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@data-day='21']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//*[@data-gcw-component='gcw-traveler-amount-select'])[1]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("(//*[@class='btn-primary btn-action gcw-submit'])[1]")).click();
Thread.sleep(6000);
driver.findElement(By.xpath("(//*[@data-trip-id='2020-05-07t06:45:00-04:00-coach-phl-mia-aa-415;2020-05-21t08:00:00-04:00-coach-mia-phl-f9-2290;'])[1]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='basic-economy-tray-content-1']/div/div/div[1]/button")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("(//*[@data-trip-id='2020-05-07t06:45:00-04:00-coach-phl-mia-aa-415;2020-05-21t08:00:00-04:00-coach-mia-phl-f9-2290;'])[1]")).click();
Thread.sleep(6000);
driver.findElement(By.xpath("//*[@id='basic-economy-tray-content-1']/div/div/div[1]/button")).click();
Thread.sleep(6000);
driver.findElement(By.xpath("//*[@id='forcedChoiceNoThanks']")).click();
Thread.sleep(6000);
ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));
driver.findElement(By.xpath("//*[@id='bookButton']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='firstname[0]']")).sendKeys("Mett");
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='lastname[0]']")).sendKeys("Lee");
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='phone-number[0]']")).sendKeys("9834272649656");
Thread.sleep(5000);
driver.close();}
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Kuria\\Desktop\\selenium\\BootCampDen\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();}
  @AfterClass
  public void afterClass() {
  }
}
