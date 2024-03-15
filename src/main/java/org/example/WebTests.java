package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Scanner;

public class WebTests {
    public WebTests()
    {}

    public boolean test1(ChromeDriver driver, String email, String pass)
    {
        boolean result = false;
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com");

        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/digital-downloads\"]")).click();




        try
        {
            File data  = new File("src\\main\\java\\org\\example\\data1.txt");
            Scanner input = new Scanner(data);
            do
            {
                String next = input.nextLine();
                WebElement element = driver.findElement(By.xpath("//a[text()=\""+next+"\"]/following::input[@class=\"button-2 product-box-add-to-cart-button\"]"));
                element.click();
                WebElement element2 = driver.findElement(By.id("bar-notification"));
                wait.until(ExpectedConditions.visibilityOf(element2));
                driver.findElement(By.xpath("//span[@class=\"close\"]")).click();
                wait.until(ExpectedConditions.invisibilityOf(element2));
            }while(input.hasNextLine());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        driver.get("https://demowebshop.tricentis.com/cart");
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        try{
            WebElement billing = driver.findElement(By.id("billing-address-select"));
            Select billingSelect = new Select(billing);

            if(billingSelect.getFirstSelectedOption().getText().equals("New Address"))
            {
                WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
                Select countrySelect = new Select(country);
                countrySelect.selectByIndex(1);
                driver.findElement(By.id("BillingNewAddress_City")).sendKeys("City1");
                driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Address1");
                driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
                driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("37061234567");
            }
        }catch(NoSuchElementException ex)
        {
            WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select countrySelect = new Select(country);
            countrySelect.selectByIndex(1);
            driver.findElement(By.id("BillingNewAddress_City")).sendKeys("City1");
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Address1");
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("37061234567");
        }
        driver.findElement(By.xpath("//div[@id=\"billing-buttons-container\"]/child::input[@title=\"Continue\"]")).click();
        WebElement el1 = driver.findElement(By.xpath("//div[@id=\"payment-method-buttons-container\"]//descendant::input[@value=\"Continue\"]"));
        new Actions(driver).scrollToElement(el1);
        wait.until(ExpectedConditions.visibilityOf(el1));
        el1.click();
        WebElement el2 = driver.findElement(By.xpath("//div[@id=\"payment-info-buttons-container\"]//descendant::input[@value=\"Continue\"]"));
        new Actions(driver).scrollToElement(el2);
        wait.until(ExpectedConditions.visibilityOf(el2));
        el2.click();
        WebElement el3 = driver.findElement(By.xpath("//div[@id=\"confirm-order-buttons-container\"]//descendant::input[@value=\"Confirm\"]"));
        new Actions(driver).scrollToElement(el3);
        wait.until(ExpectedConditions.visibilityOf(el3));
        el3.click();
        wait.until(ExpectedConditions.invisibilityOf(el3));
        WebElement el4 = driver.findElement(By.xpath("//a[contains(@href,\"/orderdetails/\")]"));
        new Actions(driver).scrollToElement(el4);
        wait.until(ExpectedConditions.visibilityOf(el4));
        el4.click();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"order-details\"]/span[text()=\"Order Status: Pending\"]"));
        if(status.getText().equals("Order Status: Pending"))
        {
            result = true;
        }

        return result;
    }

    public boolean test2(ChromeDriver driver, String email, String pass)
    {
        boolean result = false;
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com");

        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/digital-downloads\"]")).click();


        try
        {
            File data  = new File("src\\main\\java\\org\\example\\data2.txt");
            Scanner input = new Scanner(data);
            do
            {
                String next = input.nextLine();
                WebElement element = driver.findElement(By.xpath("//a[text()=\""+next+"\"]/following::input[@class=\"button-2 product-box-add-to-cart-button\"]"));
                element.click();
                WebElement element2 = driver.findElement(By.id("bar-notification"));
                wait.until(ExpectedConditions.visibilityOf(element2));
                driver.findElement(By.xpath("//span[@class=\"close\"]")).click();
                wait.until(ExpectedConditions.invisibilityOf(element2));
            }while(input.hasNextLine());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        driver.get("https://demowebshop.tricentis.com/cart");
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        try{
            WebElement billing = driver.findElement(By.id("billing-address-select"));
            Select billingSelect = new Select(billing);

            if(billingSelect.getFirstSelectedOption().getText().equals("New Address"))
            {
                WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
                Select countrySelect = new Select(country);
                countrySelect.selectByIndex(1);
                driver.findElement(By.id("BillingNewAddress_City")).sendKeys("City1");
                driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Address1");
                driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
                driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("37061234567");
            }
        }catch(NoSuchElementException ex)
        {
            WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select countrySelect = new Select(country);
            countrySelect.selectByIndex(1);
            driver.findElement(By.id("BillingNewAddress_City")).sendKeys("City1");
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Address1");
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("37061234567");
        }

        driver.findElement(By.xpath("//div[@id=\"billing-buttons-container\"]/child::input[@title=\"Continue\"]")).click();
        WebElement el1 = driver.findElement(By.xpath("//div[@id=\"payment-method-buttons-container\"]//descendant::input[@value=\"Continue\"]"));
        new Actions(driver).scrollToElement(el1);
        wait.until(ExpectedConditions.visibilityOf(el1));
        el1.click();
        WebElement el2 = driver.findElement(By.xpath("//div[@id=\"payment-info-buttons-container\"]//descendant::input[@value=\"Continue\"]"));
        new Actions(driver).scrollToElement(el2);
        wait.until(ExpectedConditions.visibilityOf(el2));
        el2.click();
        WebElement el3 = driver.findElement(By.xpath("//div[@id=\"confirm-order-buttons-container\"]//descendant::input[@value=\"Confirm\"]"));
        new Actions(driver).scrollToElement(el3);
        wait.until(ExpectedConditions.visibilityOf(el3));
        el3.click();
        wait.until(ExpectedConditions.invisibilityOf(el3));
        WebElement el4 = driver.findElement(By.xpath("//a[contains(@href,\"/orderdetails/\")]"));
        new Actions(driver).scrollToElement(el4);
        wait.until(ExpectedConditions.visibilityOf(el4));
        el4.click();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"order-details\"]/span[text()=\"Order Status: Pending\"]"));
        if(status.getText().equals("Order Status: Pending"))
        {
            result = true;
        }

        return result;
    }
}
