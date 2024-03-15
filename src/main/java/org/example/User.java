package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class User {

    public String email = "";
    public String password = "";
    public String firstName = "testfirst";
    public String lastName = "testlast";
    private final Random rand = new Random();

    public User()
    {
        registerUser();
    }

    private void registerUser()
    {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        int num = rand.nextInt();
        email = "testemail" + num + "@gmail.com";
        password = "testpass" + num;


        driver.get("https://demowebshop.tricentis.com/register");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        driver.quit();
    }
}
