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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Introducir un valor en el campo "cid"
        WebElement campoCid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cid']")));
        campoCid.clear();
        campoCid.sendKeys("0914897038");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Introducir un valor en el campo "fingerPrint"
        WebElement fingerPrint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fingerPrint']")));
        fingerPrint.sendKeys("B3456F9211");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
                ie.printStackTrace();
            }
            js.executeScript("arguments[0].click();", button);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Introducir un valor en el campo "campoTelefono"
        WebElement campoTelefono = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='phone']")));
        campoTelefono.sendKeys("0994674872");

        // Introducir un valor en el campo "campoEmail"
        WebElement campoEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
        campoEmail.sendKeys("xavierpruebasautomatizadas@gmail.com");

        // Hacer clic en el botón "botonContinuar"
        WebElement botonContinuar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        botonContinuar.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hacer clic en el botón "Ir a tomar la foto"
        WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnNext']")));
        botonSiguiente.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Acceder a la cámara frontal
        WebElement camaraFrontal = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fPhiWidgetContainer']//facephi-selphid")));
        camaraFrontal.click();
        

try {
    Thread.sleep(5000); // Esperar a que la foto se tome
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Usar esta foto trasera
WebElement usarEstaFotoTrasera = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fPhiWidgetContainer']//facephi-selphid")));
usarEstaFotoTrasera.click();

try {
    Thread.sleep(5000); // Esperar a que la foto se tome
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Ir a tomar foto
WebElement irATomarFoto = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext")));
irATomarFoto.click();

try {
    Thread.sleep(5000); // Esperar a que la página cargue
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Validar foto
WebElement validarFoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()[normalize-space() = 'Validar foto']]")));
validarFoto.click();

try {
    Thread.sleep(5000); // Esperar a que la validación se complete
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Continuar
WebElement continuar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()[normalize-space() = 'Continuar']]")));
continuar.click();

try {
    Thread.sleep(5000); // Esperar a que la siguiente página cargue
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Aquí puedes continuar con los siguientes pasos de tu flujo
        // FALTA PONER LOS SIGUIENTES PASOS DEL FLUJO

        
        // driver.quit();
    }
}
