package testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestOnboarding {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        var devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        driver.get("https://tarjetacredito.dev.cuentafuturo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement campoCid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cid']")));
        campoCid.clear();
        campoCid.sendKeys("0914897038");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement fingerPrint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fingerPrint']")));
        fingerPrint.sendKeys("B3456F9211");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

        try {
            checkbox.click();
            Thread.sleep(1000);
            button.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            js.executeScript("arguments[0].click();", button);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement campoTelefono = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='phone']")));
        campoTelefono.sendKeys("0994674872");

        WebElement campoEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
        campoEmail.sendKeys("xavierpruebasautomatizadas@gmail.com");

        WebElement botonContinuar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        botonContinuar.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnNext']")));
        botonSiguiente.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Comentar o eliminar esta línea para evitar que el navegador se cierre automáticamente
        // driver.quit();
    }
}