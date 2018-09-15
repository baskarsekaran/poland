package com.selenim.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AmazonSearchPage {

	WebDriver driver;
	private static final By SEARCH_TEXT_FIELD = By
			.cssSelector("#twotabsearchtextbox");
	private static final By SELECT_FIFTH_PRODUCT = By
			.xpath("//*[starts-with(@id,'result_')][4]/following::h2");
	private static final By PRODUCT_NAME = By
			.cssSelector(".sc-list-item-content span.a-list-item");

	public AmazonSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// search products
	public void searchProducts(String value) {
		driver.findElement(SEARCH_TEXT_FIELD).sendKeys(value);
		driver.findElement(SEARCH_TEXT_FIELD).sendKeys(Keys.ENTER);
	}

	// get product name
	public String getProductName() {
		String productName = driver.findElement(SELECT_FIFTH_PRODUCT).getText();
		return productName;
	}

	// click 5th product
	public void selectFifthProduct() {
		driver.findElement(SELECT_FIFTH_PRODUCT).click();
	}

	// get product name after added to cart
	public String getProductNameCart() {
		String productNameCart = driver.findElement(PRODUCT_NAME).getText();
		return productNameCart;
	}

}
