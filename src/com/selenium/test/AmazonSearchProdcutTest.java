package com.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenim.page.AddToCartPage;
import com.selenim.page.AmazonSearchPage;

public class AmazonSearchProdcutTest {

	WebDriver driver;
	AmazonSearchPage searchPage;
	AddToCartPage cartPage;

	/**
	 * @param args
	 * @throws IOException
	 */

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\GIT\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
	}

	@Test
	public void amazonSearchProducts() throws IOException {
		// TODO Auto-generated method stub

		// init pages
		searchPage = new AmazonSearchPage(driver);
		cartPage = new AddToCartPage(driver);

		// search product
		searchPage.searchProducts("Best Sellers in Digital Cameras");
		cartPage.takeScreenshots();

		// select 5th prodcut
		String name = searchPage.getProductName();
		searchPage.selectFifthProduct();
		cartPage.takeScreenshots();

		// get the price
		String price = cartPage.getPrice();
		System.out.println("price : " + price.substring(1));
		double price1 = Double.parseDouble(price.substring(1).trim());
		double price2 = price1 * 8;
		System.out.println("price of 8 product : " + price2);

		// select quantity
		cartPage.selectQuantity();
		cartPage.takeScreenshots();

		// click add to cart
		cartPage.clickAddToCart();
		cartPage.takeScreenshots();

		// click card button
		cartPage.clickCartButton();
		cartPage.takeScreenshots();

		// verify the correct product is added
		String cartName = searchPage.getProductNameCart();
		if (name.equalsIgnoreCase(cartName)) {
			cartPage.takeScreenshots();
			System.out.println("product added is correct : " + name);
			System.out.println("product added is correct :" + cartName);
		} else {
			System.out.println("product added is incorrect : " + name);
			System.out.println("product added is incorrct :" + cartName);
		}

		// verify the sum of price
		String sumPrice = cartPage.getSumOfPrice();
		System.out.println("sum price : " + sumPrice.substring(1));
		double sumPrice1 = Double.parseDouble(sumPrice.substring(1).trim());
		if (price2 == sumPrice1) {
			System.out.println("sum of the price is correct : " + price2);
			System.out.println("sum of the price is correct : " + sumPrice1);
		} else {
			System.out.println("sum of the price is incorrect : " + price2);
			System.out.println("sum of the price is incorrect : " + sumPrice1);
		}
	}

	@After
	public void tearDown() {
		// close browser
		driver.quit();

	}
}
