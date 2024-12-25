import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class testSelenium {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(" -- headless");
        options.addArguments(" -- no-sandbox");
        options.addArguments(" -- disable-dev-shm-usage");
        options.addArguments(" -- remote-allow-origins =* ");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        driver.quit();


    }
}
