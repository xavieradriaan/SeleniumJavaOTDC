package testSelenium;

import org.openqa.selenium.By;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestOnboarding {


    // TENER PRESENTE QUE SI UN PASO DE UN WEB ELEMENT NO FUNCIONA, PUEDE DEBERSE A QUE UN SELECTOR ANTERIOR DEJÓ DE FUNCIONAR    //
    //        ESTO NO VA PERMITIR QUE FUNCIONEN LOS SELECTORES DE LOS WEB ELEMENTS SIGUIENTES   //                                                  //

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

        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Entrar a la bienvenida del onboarding
        WebElement botonBienvenida = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        botonBienvenida.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Introducir un valor en el campo "cid"
        WebElement campoCid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cid']")));
        campoCid.clear();
        campoCid.sendKeys("0914897038");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Introducir un valor en el campo "fingerPrint"
        WebElement fingerPrint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='fingerPrint']")));
        fingerPrint.sendKeys("B3456F9211");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Hacer clic en el checkbox y en el botón de envío
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

        try {
            checkbox.click();
            Thread.sleep(5000);
            button.click();
        } catch (Exception e) {
            // Si hay un error al hacer clic, usar JavaScriptExecutor para hacer clic en el checkbox y en el botón
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
            try {
                Thread.sleep(5000);
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
        campoEmail.sendKeys("xandrado@bolivariano.com");

        // Hacer clic en el botón "botonContinuar"
        WebElement botonContinuar1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        botonContinuar1.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
/* 
        // Hacer clic en el elemento con el selector CSS "button:nth-child(2)"
        WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button:nth-child(2)")));
        button2.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        */
        // Esperar a que el elemento con el selector CSS ".bb-input-wrapper.bb-input__wrapper--primary" sea clickeable y hacer clic en él
        WebElement bbInputWrapperPrimary = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bb-input-wrapper.bb-input__wrapper--primary")));
        bbInputWrapperPrimary.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        
        
        // Esperar a que el elemento con el selector CSS ".pac-target-input" sea clickeable y hacer clic en él
        WebElement pacTargetInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pac-target-input")));
        pacTargetInput.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Escribir "Ciudad Celeste" en el campo
        pacTargetInput.sendKeys("Ciudad Celeste");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Realizar un keydown y luego un keyenter
        pacTargetInput.sendKeys(Keys.DOWN);
        pacTargetInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Hacer clic en el botón con el nuevo selector XPath "//button[contains(.,'Confirmar dirección')]"
        WebElement mapButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Confirmar dirección')]")));
        mapButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Hacer clic en el elemento con id "referency"
        WebElement referencyField = wait.until(ExpectedConditions.elementToBeClickable(By.id("referency")));
        referencyField.click();
        
        // Escribir la descripción en el campo "referency"
        referencyField.sendKeys("Casa de dos pisos color crema con Césped delantero y arreglos florales.");
        

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Hacer clic en el botón con el nuevo selector XPath "//button[contains(.,'Guardar domicilio')]"
        WebElement addressButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Guardar domicilio')]")));
        addressButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Hacer clic en el elemento con el selector XPath "//span[contains(.,'Escoge una opción')]"
        WebElement dropdownLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Escoge una opción')]")));
        dropdownLabel.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
  
        // Enviar las teclas al elemento activo
        WebElement activeElement = driver.switchTo().activeElement();
        activeElement.sendKeys(Keys.ARROW_DOWN);
        activeElement.sendKeys(Keys.ENTER);
        

        try {
            Thread.sleep(5000); // Esperar un momento para que la selección se complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }  

        // Esperar a que el elemento con el selector CSS label[for='privateJob'] sea clickeable y hacer clic en él
WebElement privateJobLabel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='privateJob']")));
privateJobLabel.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

        // Hacer clic en el elemento con id="companyName" y escribir "Construcciones Mercury S.A"
WebElement companyName = wait.until(ExpectedConditions.elementToBeClickable(By.id("companyName")));
companyName.click();
companyName.sendKeys("Construcciones Mercury S.A");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Hacer clic en el elemento con id="seniority" y escribir "8"
WebElement seniority = wait.until(ExpectedConditions.elementToBeClickable(By.id("seniority")));
seniority.click();
seniority.sendKeys("8");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Hacer clic en el elemento con id="conventionalPhone" y escribir "42255254"
WebElement conventionalPhone = wait.until(ExpectedConditions.elementToBeClickable(By.id("conventionalPhone")));
conventionalPhone.click();
conventionalPhone.sendKeys("42255254");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Hacer clic en el elemento con name="monthyIncome" y escribir "1400"
WebElement monthlyIncome = wait.until(ExpectedConditions.elementToBeClickable(By.name("monthyIncome")));
monthlyIncome.click();
monthlyIncome.sendKeys("1400");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();

}

// Esperar a que el elemento con el selector CSS "#jobAddress" sea clickeable y hacer clic en él
WebElement jobAddress = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jobAddress")));
jobAddress.click();

try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el elemento con el selector CSS ".pac-target-input" sea clickeable y hacer clic en él
WebElement pacTargetInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pac-target-input")));
pacTargetInputField.click();

try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Escribir "Ciudad colon" en el campo de dirección
pacTargetInputField.sendKeys("Ciudad colon");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Realizar un keydown y luego un keyenter
pacTargetInputField.sendKeys(Keys.DOWN);
pacTargetInputField.sendKeys(Keys.ENTER);

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón de confirmación sea clickeable y hacer clic en él
WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bb-button:nth-child(2) > .button__label")));
confirmButton.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector XPath //*[@id="jobAddressReference"] sea clickeable y hacer clic en él
WebElement jobAddressReference = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='jobAddressReference']")));
jobAddressReference.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Escribir "OFICINA SIEMPRE VIVA PUERTA 6 PISO 14" en el campo de referencia
jobAddressReference.sendKeys("OFICINA SIEMPRE VIVA PUERTA 6 PISO 14");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón con el selector CSS .bb-button:nth-child(2) sea clickeable y hacer clic en él
WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bb-button:nth-child(2)")));
nextButton.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón con el selector CSS button[type='submit'] sea clickeable y hacer clic en él
WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
submitButton.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}


// Esperar a que el campo con el selector CSS input[placeholder='Ej: $ 700.00'] sea clickeable y escribir 980
WebElement firstInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Ej: $ 700.00']")));
firstInput.click();
firstInput.sendKeys("980");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector CSS input[placeholder='Ej: $ 250.00'] sea clickeable y escribir 275
WebElement secondInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Ej: $ 250.00']")));
secondInput.click();
secondInput.sendKeys("275");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón con el selector CSS button[type='submit'] sea clickeable y hacer clic en él
WebElement finalSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
finalSubmitButton.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el elemento con el selector CSS .lucide.lucide-chevron-down sea clickeable y hacer clic en él
WebElement chevronDown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".lucide.lucide-chevron-down")));
chevronDown.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Hacer keydown y keyenter
Actions actions = new Actions(driver);
actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector CSS #names sea clickeable y escribir Xavier Adrian
WebElement namesInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#names")));
namesInput.click();
namesInput.sendKeys("Xavier Adrian");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector CSS #fatherLastName sea clickeable y escribir Andrade
WebElement fatherLastNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#fatherLastName")));
fatherLastNameInput.click();
fatherLastNameInput.sendKeys("Andrade");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector CSS #motherLastName sea clickeable y escribir Ochoa
WebElement motherLastNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#motherLastName")));
motherLastNameInput.click();
motherLastNameInput.sendKeys("Ochoa");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector CSS #phoneNumber sea clickeable y escribir 0994874986
WebElement phoneNumberInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#phoneNumber")));
phoneNumberInput.click();
phoneNumberInput.sendKeys("0994874986");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón con el selector CSS button[type='submit'] sea clickeable y hacer clic en él
WebElement submitButtonFinal = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
submitButtonFinal.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el elemento con el selector CSS div[class='bb-card bb-card__border--primary bb-card__background--undefined'] div[data-pc-section='content'] sea clickeable y hacer clic en él
WebElement contentSection = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='bb-card bb-card__border--primary bb-card__background--undefined'] div[data-pc-section='content']")));
contentSection.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón con el selector CSS .bb-button.bb-button--primary sea clickeable y hacer clic en él
WebElement primaryButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bb-button.bb-button--primary")));
primaryButton.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}


// Continuar con el siguiente paso: Envío de tarjeta Esperar a que el botón con el selector CSS .bb-button.bb-button--primary sea clickeable y hacer clic en él
WebElement nextPrimaryButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bb-button.bb-button--primary")));
nextPrimaryButton.click();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}




/* 



// Abrir una nueva pestaña y acceder a la URL especificada
((JavascriptExecutor) driver).executeScript("window.open('https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=156&ct=1722265131&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26deeplink%3dowa%252f0%252f%253fstate%253d1%2526redirectTo%253daHR0cHM6Ly9vdXRsb29rLmxpdmUuY29tL21haWwvMC8%26RpsCsrfState%3d34d7fa3c-b088-fc2b-8e77-8ee411630f27&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c', '_blank');");

// Cambiar el control a la nueva pestaña
ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));

// Esperar a que el campo con el selector CSS #i0116 sea clickeable y escribir xandrado@bolivariano.com
WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#i0116")));
emailInput.click();
emailInput.sendKeys("xandrado@bolivariano.com");

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el botón con el selector CSS #idSIButton9 sea clickeable y hacer clic en él
WebElement nextButtonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#idSIButton9")));
nextButtonLogin.click();

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// Esperar a que el campo con el selector XPath //*[@id="i0118"] sea clickeable y hacer clic en él
WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i0118']")));
passwordInput.click();
passwordInput.sendKeys("MOquito10a7b5fj1p*");

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}


// Esperar a que el botón con el selector XPath //*[@id="idSIButton9"] sea clickeable y hacer clic en él
WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='idSIButton9']")));
signInButton.click();

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
*/
        /*

        /*
        // Hacer clic en el botón "Ir a tomar la foto"
        WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnNext']")));
        botonSiguiente.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

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
        */

        /*                         FIN  PARTE DE LA BIOMETRÍA                            */

    }
}