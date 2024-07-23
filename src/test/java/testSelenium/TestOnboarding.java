package testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOnboarding {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            // Asumiendo que ya has navegado a la página web donde necesitas realizar estas acciones
            driver.get("https://tarjetacredito.dev.cuentafuturo.com/");

            // Encuentra el campo de texto por su ID y escribe "0914897038"
            WebElement cidInput = driver.findElement(By.xpath("//*[@id='cid']"));
            cidInput.sendKeys("0914897038");

            // Encuentra el otro campo de texto por su ID y escribe "G8797E2830"
            WebElement fingerPrintInput = driver.findElement(By.xpath("//*[@id='fingerPrint']"));
            fingerPrintInput.sendKeys("G8797E2830");

            // Encuentra el checkbox por su XPath y lo marca si aún no está marcado
            WebElement termsCheckbox = driver.findElement(By.xpath("//*[@id='terms-data']/input"));
            if (!termsCheckbox.isSelected()) {
                termsCheckbox.click();
            }

            // Encuentra el botón por su XPath y hace clic en él
            WebElement submitButton = driver.findElement(By.xpath("//*[@id='__next']/main/div/div[2]/form/div[2]/button/div"));
            submitButton.click();
            
            // Espera para que puedas ver el resultado
            try {
                Thread.sleep(5000); // Espera 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace(); // Maneja la excepción aquí
            }
            
        } finally {
            // Cierra el navegador
            driver.quit();
        }
    }
}