import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("Get website title")
    @Test
    public void getTitle() {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @DisplayName(("Registration_Form"))
    @Test
    public void registrationForm() {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        //first name
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("Subrina");

        //last name
        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Ferdous");

        //email
        WebElement email = driver.findElement(By.id("user_email"));
        email.sendKeys("subrina1@gmail.com");

        //password
        WebElement pass = driver.findElement(By.id("user_pass"));
        pass.sendKeys("1234@#a1234");

        //gender
        WebElement gender = driver.findElement(By.id("radio_1665627729_Female"));
        gender.click();

        //Birth_date
        WebElement dateSelect = driver.findElement(By.id("date_box_1665628538_field"));
        dateSelect.click();

        //month
        WebElement monthDropdown = driver.findElement(By.cssSelector("[class=flatpickr-monthDropdown-months]"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("May");

        //year
        WebElement year=driver.findElement(By.cssSelector(".cur-year"));
        year.click();
        year.sendKeys(Keys.BACK_SPACE);
        year.sendKeys("1999");

        //Day
        WebElement day = driver.findElement(By.xpath("//span[contains(@class, 'flatpickr-day') and text()='28']"));
        day.click();

        //Phone_Number
        WebElement number= driver.findElement(By.cssSelector("[name=phone_1665627880]"));
        number.click();
        number.sendKeys("1234567890");

        //nationality
        WebElement nationality = driver.findElement(By.id("input_box_1665629217"));
        nationality.sendKeys("Bangladeshi");

        //country
        Select select = new Select(driver.findElement(By.id("country_1665629257")));
        select.selectByVisibleText("Bangladesh");
        Utils.scroll(driver, 1200);

        //Term and Conditions
        WebElement termsCheckbox = driver.findElement(By.id("privacy_policy_1665633140"));
        termsCheckbox.click();

        //Submit
        WebElement submit= driver.findElement(By.cssSelector("[class=\"btn button ur-submit-button \"]"));
        Actions actions=new Actions(driver);
        actions.click(submit).perform();
        //submit.click();
        WebElement success=driver.findElement(By.xpath("//ul[contains(text(),'User successfully registered.')]"));
        String actualMessage = success.getText();
        String messageExpected="User successfully registered.";
        Assertions.assertTrue(actualMessage.contains(messageExpected));


    }

    }




