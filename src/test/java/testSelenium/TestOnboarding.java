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
        // Configuración del WebDriver y opciones del navegador
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        var devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        
        // Navegar a la página web
        driver.get("https://tarjetacredito.dev.cuentafuturo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Entrar a la bienvenida del onboarding
        WebElement botonBienvenida = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__next']/main/div/div[2]/div/div[2]/div/button")));
        botonBienvenida.click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Introducir un valor en el campo "cid"
        WebElement campoCid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cid']")));
        campoCid.clear();
        campoCid.sendKeys("0914897038");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Introducir un valor en el campo "fingerPrint"
        WebElement fingerPrint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fingerPrint']")));
        fingerPrint.sendKeys("B3456F9211");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Hacer clic en el checkbox y en el botón de envío
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

        try {
            checkbox.click();
            Thread.sleep(1000);
            button.click();
        } catch (Exception e) {
            // Si hay un error al hacer clic, usar JavaScriptExecutor para hacer clic en el checkbox y en el botón
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            js.executeScript("arguments[0].click();", button);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Introducir un valor en el campo "campoTelefono"
        WebElement campoTelefono = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='phone']")));
        campoTelefono.sendKeys("0994674872");

        // Introducir un valor en el campo "campoEmail"
        WebElement campoEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
        campoEmail.sendKeys("xavierpruebasautomatizadas@gmail.com");

        // Hacer clic en el botón "botonContinuar"
        WebElement botonContinuar1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        botonContinuar1.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Hacer clic en el botón "Ir a tomar la foto"
        WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnNext']")));
        botonSiguiente.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//



// Hacer clic en el elemento para seleccionar la parte delantera de la foto
WebElement fotoDelantera = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fPhiWidgetContainer']//facephi-selphid")));
fotoDelantera.click();

try {
    Thread.sleep(2000); // Breve espera antes de seleccionar la parte trasera
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Hacer clic nuevamente en el mismo elemento para seleccionar la parte trasera de la foto
WebElement fotoTrasera = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fPhiWidgetContainer']//facephi-selphid")));
fotoTrasera.click();

try {
    Thread.sleep(5000); // Espera para simular la acción de tomar la foto
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Hacer clic en el botón "Ir a tomar foto"
WebElement botonIrATomarFoto = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext")));
botonIrATomarFoto.click();

try {
    Thread.sleep(5000); // Espera para simular la acción de tomar la foto
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Validar la foto
WebElement botonValidarFoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()[normalize-space() = 'Validar foto']]")));
botonValidarFoto.click();

try {
    Thread.sleep(5000); // Espera para simular la validación de la foto
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Continuar después de validar la foto
WebElement botonContinuar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()[normalize-space() = 'Continuar']]")));
botonContinuar.click();

try {
    Thread.sleep(5000); // Espera antes de continuar con el siguiente paso
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Aquí puedes continuar con los siguientes pasos de tu flujo


// Continúa con los siguientes pasos de tu flujo
        // Aquí puedes continuar con los siguientes pasos de tu flujo

        // Finalmente, cierra el navegador
        // driver.quit();
    }
}