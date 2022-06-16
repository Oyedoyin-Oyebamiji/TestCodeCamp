import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

    import com.google.common.base.Predicates;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Seleniumblog_automation {

    //Import Selenium driver
        private WebDriver driver;

        @BeforeTest
        public void setup() throws InterruptedException {
            //1. locate the chrome driver
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            //2. Open Chrome browser
            driver = new ChromeDriver();
        }

    @Test(priority = 0)
    public void openUrl() throws InterruptedException {
        //3. Input and open url
        driver.get("http://selenium-blog.herokuapp.com");
        //4. Make sure the URL page fully loads by delaying by 5000 millisecond
        Thread.sleep(5000);
        //Test case 1: Verify that user inputs the right url and is directed to the right webpage
        String expectedUrl = "http://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Valid webpage");
        else
            //fail
            System.out.println("Invalid webpage");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void clicksignup() throws InterruptedException {
        //5. Click Signup button
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test case 2: Verify that signup page opens at the click of Signup button
        String expectedUrl = "http://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(5000);
        if (actualUrl.contains(expectedUrl))
            System.out.println("Correct signup page");
            //pass

        else
            System.out.println("Incorrect signup page");
        //fail
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void Validsignup() throws InterruptedException {
    //6. Create Username, email address, password and click signup
        driver.findElement(By.id("user_username")).sendKeys("Adukemi12");
        driver.findElement(By.id("user_email")).sendKeys("adukemi123@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("Adegirl@12345");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Test case 3: Verify that user will successfully sign up with valid username,email and password
        String expectedTitle = "Alpha Blog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //pass
            System.out.print("Sign up successful");
        else
            //fail
            System.out.println("Sign up fail");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void clickuser1() throws InterruptedException {
     //7. Click User1
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);

        //Test case 4: Verify that "Welcome to user1's page" page opens at the click of User1 button
        String expectedUrl = "http://selenium-blog.herokuapp.com/users/1";
        String actualUrl = (driver.getCurrentUrl());

        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Valid page");
        else
            //fail
            System.out.print("Invalid page");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void clickxpath() throws InterruptedException {
//  //8. Click Learn Xpath button to open Learn Xpath article
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(5000);

        //Test case 5: Verify that the article content will open at the click of Learn Xpath
        String expectedUrl = "http://selenium-blog.herokuapp.com/articles/59";
        String actualUrl = (driver.getCurrentUrl());

        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct page");
        else
            //fail
            System.out.println("Incorrect page");
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void Logoutsuccesfully() throws InterruptedException {
    //9. Click logout button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);

        //Test case 6: Verify that user will be logged out and directed to home page at the click of logout button
        String expectedUrl = "http://selenium-blog.herokuapp.com/";
        String actualUrl = (driver.getCurrentUrl());

        if (actualUrl.contains(expectedUrl))
            //pass

            System.out.println("log out successful");
        else
            //fail
            System.out.println("log out fail");
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void invalidusername() throws InterruptedException {

        //10. Input Invalid username
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test case 7: Verify that user cannot sign up with invalid username successfully

        driver.findElement(By.id("user_username")).sendKeys("A");
        driver.findElement(By.id("user_email")).sendKeys("adukemi12@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("Adegirl@1234");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)

    public void emptysignupfield() throws InterruptedException {
        //11. Signup with empty sign up fields
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //Test case 8: Verify that user cannot sign up with empty fields successfully

        driver.findElement(By.id("user_username")).sendKeys(" ");
        driver.findElement(By.id("user_email")).sendKeys(" ");
        driver.findElement(By.id("user_password")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void invalidemailsignup() throws InterruptedException {

            //12. Input invalid email address
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //Test case 9: Verify that user cannot sign up with invalid email address successfully

        driver.findElement(By.id("user_username")).sendKeys("Adukemi1");
        driver.findElement(By.id("user_email")).sendKeys("adukemi12@mailinator");
        driver.findElement(By.id("user_password")).sendKeys("Adegirl@1234");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void tooshortpassword() throws InterruptedException {

            //13. Input too short password
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //Test case 10: Verify that user cannot use less than or equal to one character password to sign up successfully

        driver.findElement(By.id("user_username")).sendKeys("Adukemi1");
        driver.findElement(By.id("user_email")).sendKeys("adukemi12@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("A");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void quitpage() {

        driver.quit();
    }


}
