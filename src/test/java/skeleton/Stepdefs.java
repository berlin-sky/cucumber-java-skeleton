package skeleton;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

public class Stepdefs {

    @FindBy(css = "input[data-test-id=username]")
    private WebElement username;

    @FindBy(css = "input[data-test-id=password]")
    private WebElement password;

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
        openPage();
    }

    public void openPage(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://sp-shop-select-stage.herokuapp.com/login");
        driver.findElement(By.cssSelector("input[data-test-id=username]")).sendKeys("surprise");
        driver.findElement(By.cssSelector("input[data-test-id=password]")).sendKeys("4f84e9b09e41f673cc96b3de62683e06");
        driver.findElement(By.cssSelector("button[data-test-id=log-in]")).click();
        assertTrue("Cannot login", true);
    }
}
