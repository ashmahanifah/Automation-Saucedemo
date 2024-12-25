package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stepDef.ApiStep;

import java.io.File;
import java.io.InputStream;
import java.time.Duration;


public class Utility {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            startDriver();
        }
        return driver;
    }


    //    public static File getJSONSchemaFile(String JSONFile) {
//        return new File("src/test/Java/helper/JSONSchemaData/" + JSONFile);
//    }
    public static InputStream getJSONSchemaInputStream(String JSONFile) {
        return ApiStep.class.getClassLoader().getResourceAsStream("helper/JSONSchemaData/" + JSONFile);
    }


    public static String generateRandomEmail() {

        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";

        String email = RandomStringUtils.random(10, allowedChars);
        String domain = "@test.com";

        return email + domain;
    }

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

//    public static void quitDriver() {
//        driver.quit();
//    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // driver dihapus setelah ditutup
        }
    }


}
