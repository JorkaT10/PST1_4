import org.example.Main;
import org.example.WebTests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTests {

    ChromeDriver driver;
    WebTests tests = new WebTests();

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
        Assertions.assertTrue(tests.test1(driver));
    }
    @Test
    public void unitTest2()
    {
        Assertions.assertTrue(tests.test2(driver));
    }
}
