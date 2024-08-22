package stepDefs;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceTheOrderStepDef {

	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		// Write code here that turns the phrase above into concrete actions

		driver.get("https://www.pizzahut.co.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@When("I enter the location as {string}")

	public void i_enter_the_location_as(String location) {
		// Write code here that turns the phrase above into concrete actions

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement locationInput = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("[placeholder=\"Enter your location for delivery\"]")));

		locationInput.sendKeys(location);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationInput);

	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() {
		// Write code here that turns the phrase above into concrete actions

		List<WebElement> dr = driver.findElements(By.xpath("//div[text()='Pune Railway Station']"));

		for (int i = 0; i < dr.size(); i++) {

			dr.get(0).click();

			break;

		}

	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
		// Write code here that turns the phrase above into concrete actions

		WebElement dealsTeb = driver
				.findElement(By.xpath("//div[@class=\"menu-wrapper--inner\"]//a/span[contains(text(), \"Deals\")]"));
		String text = dealsTeb.getText();
		System.out.println(text);
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String pizzalink) {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement Pizzaslink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(pizzalink)));

		Pizzaslink.click();
	}

	@Then("I add {string} to the basket")
	public void i_add_to_the_basket(String itemsName) {
		// Write code here that turns the phrase above into concrete actions

		String[] itemNeeded = { itemsName, itemsName };

		List<WebElement> itemsList = driver.findElements(By.cssSelector(".list-item--pizza"));

		int itemsAdded = 0;
		for (int i = 0; i < itemsList.size(); i++) {

			WebElement productnameElement = itemsList.get(i).findElement(By.cssSelector(".list-item__name"));
			String productname = productnameElement.getText().split(" \\r?\\n")[0].trim();
			String trimmedproductName = productname.replace("NEW", "").trim();
			System.out.println(trimmedproductName);

			List<String> itemsneededList = Arrays.asList(itemNeeded);

			if (itemsneededList.contains(trimmedproductName)) {

				WebElement button = driver.findElement(By.cssSelector(".list-item--pizza .mt-auto .m-10 .button "));
				button.click();

				itemsAdded++;

				if (itemsAdded == itemNeeded.length) {
					break;
				}

			}
		}
	}

	@Then("I note down the price displayed on the screen")
	public void i_note_down_the_price_displayed_on_the_screen() {
		// Write code here that turns the phrase above into concrete actions
		WebElement prizeOnAddButton = driver
				.findElement(By.xpath("//div[@class='m-10']//span[contains(text(),'₹139')]"));
		String text = prizeOnAddButton.getText();
		System.out.println(text);

	}

	@Then("I should see the pizza {string} is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart(String nameOfItemInBasket) {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> pizzaNamesInBasket = driver
				.findElements(By.xpath("//div[@data-testid='basket-item-product']//div[text()=nameOfItemInBasket]"));

		for (WebElement pn : pizzaNamesInBasket) {
			System.out.println(pn.getText());
			pn.isDisplayed();
		}

	}

	@Then("price is also displayed correctly")
	public void price_is_also_displayed_correctly() {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> prizeOfItemsInBasket = driver
				.findElements(By.xpath("//div[@data-testid='basket-item-product']//div[contains(text(),'₹139')]"));

		for (WebElement p : prizeOfItemsInBasket) {

			System.out.println(p.getText());
			p.isDisplayed();

		}

	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement checkoutBtn = driver.findElement(By.cssSelector(".basket-checkout"));
		checkoutBtn.click();

		// WebElement contShopBtn=driver.findElement(By.xpath("//span[text()='Continue
		// Shopping']"));
		// contShopBtn.click();
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
		// Write code here that turns the phrase above into concrete actions
		WebElement secureCheckText = driver.findElement(By.xpath("//h2/span"));
		System.out.println(secureCheckText.getText());
		secureCheckText.isDisplayed();

	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		driver.findElement(By.id("checkout__name")).sendKeys(data.get("Name"));
		driver.findElement(By.id("checkout__phone")).sendKeys(data.get("Mobile"));
		driver.findElement(By.id("checkout__email")).sendKeys(data.get("Email"));

	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<String> addresses = dataTable.asList(String.class);

		// Assuming you have two address fields, one for street and one for landmark
		driver.findElement(By.xpath("//input[@id='checkout__deliveryAddress.interior']")).sendKeys(addresses.get(0));
		driver.findElement(By.xpath("//input[@id='checkout__deliveryAddress.notes']")).sendKeys(addresses.get(1));

	}

	@Then("I click on Online Payment")
	public void i_click_on_Online_Payment() {
		// Write code here that turns the phrase above into concrete actions

		WebElement onlinePayment = driver.findElement(By.cssSelector(".mt-4"));
		onlinePayment.click();
		onlinePayment.isSelected();

	}

	@Then("I unable to click on cash payment")
	public void i_unable_to_click_on_cash_payment() {
		// Write code here that turns the phrase above into concrete actions
		WebElement cash = driver.findElement(By.cssSelector("#payment-method--cash"));

		if (!cash.isEnabled()) {
			System.out.println("The cash payment radio button is disabled.");
		} else {
			System.out.println("The cash payment radio button is disabled.");
		}
	}
}
