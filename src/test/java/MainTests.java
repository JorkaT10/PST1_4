import org.example.User;
import org.example.WebTests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTests {

    ChromeDriver driver;
    static User user;
    WebTests tests = new WebTests();

    @BeforeAll public static void before()
    {
        user = new User();
    }

    @BeforeEach public void init()
    {
        driver = new ChromeDriver();
    }

    @AfterEach void after()
    {
        driver.quit();
    }

    @Test
    public void unitTest1()
    {
        Assertions.assertTrue(tests.test1(driver, user.email, user.password));
    }
    @Test
    public void unitTest2()
    {
        Assertions.assertTrue(tests.test2(driver, user.email, user.password));
    }
}
