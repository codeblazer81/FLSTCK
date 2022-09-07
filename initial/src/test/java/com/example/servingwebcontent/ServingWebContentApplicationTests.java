package com.example.servingwebcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(classes = ServingWebContentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServingWebContentApplicationTests {

	@LocalServerPort
    private int port;

	public static WebDriver driver;
	
	public static String baseURL;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterAll
    public static void afterAll() {
        driver.quit();
    }
	
	@BeforeEach
	public void beforeEach() throws InterruptedException{
		//Thread.sleep(5000);
		baseURL = "http://localhost:"+port;	
	}

	@Test
	public void testSignup() throws InterruptedException{
		
		

		driver.get(baseURL+"/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.setInputFirstName("sonu");
		signupPage.setInputLastName("sud");
		signupPage.setInputUsername("s");
		signupPage.setInputPassword("s");
		assertEquals("You successfully signed up! Please continue to the login page.", signupPage.getSuccessMsg());

		Thread.sleep(2000);

	}

}
