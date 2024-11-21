package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabHomePage {

	
	@FindBy(xpath="//div[@data-test='inventory-item-name']") private List<WebElement>productsName;
	@FindBy(xpath="//div[@data-test='inventory-item-prise']") private List<WebElement>productsPrise;
	@FindBy(xpath="//button[@class='btn btn primary btn_small btn_inventory']") private List<WebElement>addToCart;
	@FindBy(xpath="//select[@data-test='product-sort-container']") private WebElement sort;
	@FindBy(xpath="//button[@id='product-sort-container']") private WebElement menu;
	@FindBy(xpath="//a@id='about_sidebar_link']") private WebElement about;
	@FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement logout;
	@FindBy(xpath="//a[2class='shopping_cart_link']")private WebElement cart;
	
	
	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName(int index) {
		return productsName.get(index).getText();
	} 
	
	public String[] getAllProductName() {
		String[] names=new String[productsName.size()];
		for(int i=0;i<productsName.size();i++)
		{
			names[i]=productsName.get(i).getText();
		}
		return names;
		
	}
	
	public String getProductPrise(int index) {
		return productsPrise.get(index).getText();
}
	
	public double[] getAllProductsPrice() {
		double[] price=new double[productsName.size()];
		for(int i=0;i<productsName.size();i++)
		{
		 String amount=productsPrise.get(i).getText().substring(1);
         price[i]=Double.parseDouble(amount);
		}
		return price;
	}
	
	public void clickOnAddToCart(int index) {
		addToCart.get(index).click();
	}
	
	public void sortProducts(String text, WebDriver driver) {
	Select select=new Select(sort);
	select.selectByVisibleText(text);
	}
	
	public void clickOnMenu() {
		menu.click();
	}
	
	public void clickOnAbout() {
		about.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
	}

