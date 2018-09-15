package com.selenim.page;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {

	WebDriver driver;
	private static final By ADD_TO_CART = By.cssSelector("#add-to-cart-button");
	private static final By QUANTITY = By.cssSelector("#quantity");
	private static final By CART_BUTTON = By
			.cssSelector("#hlb-view-cart-announce");
	private static final By CART_BUTTON11 = By
			.cssSelector("#attach-sidesheet-view-cart-button");
	private static final By PRICE = By.cssSelector("#priceblock_ourprice");
	private static final By SUM_OF_PRICE = By
			.cssSelector("#sc-subtotal-amount-activecart");

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	// select quantity equal to 8
	public void selectQuantity() {
		try {
			Select select = new Select(driver.findElement(QUANTITY));
			select.selectByIndex(7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("quantity 8 is not there");
		}
	}

	// click add to cart button
	public void clickAddToCart() {
		driver.findElement(ADD_TO_CART).click();
	}

	// click cart button
	public void clickCartButton() {
		try {
			driver.findElement(CART_BUTTON).click();
		} catch (Exception e) {
			driver.findElement(CART_BUTTON11).click();
		}
	}

	// get the price
	public String getPrice() {
		String price = driver.findElement(PRICE).getText();
		return price;
	}

	// sum of price
	public String getSumOfPrice() {
		String sum = driver.findElement(SUM_OF_PRICE).getText();
		return sum;
	}

	// take screenshot
	public void takeScreenshots() throws IOException {
		// take screenshot
		Date date = new Date();
		File SrcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File(
				"E:\\GIT\\Amazon\\screenshots\\test_" + date.getDate() + "_"
						+ date.getTime() + ".png"));
	}

}
