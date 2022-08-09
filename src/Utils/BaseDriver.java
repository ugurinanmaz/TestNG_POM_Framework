package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setup(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // bütün webElement için geçerli
        driver.get("http://opencart.abstracta.us/");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
