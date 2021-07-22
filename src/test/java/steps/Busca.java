package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Busca {
    WebDriver driver;

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        System.out.println("Passo Inicial");
    }

    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Passo Final");
    }

    @Dado("^que abri o Google$")
    public void queAbriOGoogle() {
        driver.get("https://www.google.com.br");
        System.out.println("Passo 1");
    }

    @Quando("^digito \"([^\"]*)\"$")
    public void digito(String termo) {
        driver.findElement(By.name("q")).sendKeys(termo);
        System.out.println("Passo 2");
    }

    @E("^aperto a tecla Enter$")
    public void apertoATeclaEnter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("Passo 3");
    }

    @Entao("^exibe os resultados para \"([^\"]*)\"$")
    public void exibeOsResultadosPara(String termo) {
        assertEquals(driver.getTitle(), termo + " - Pesquisa Google");
        System.out.println("Passo 4");
    }
}
