package defn;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class defn {
	
	 public static WebDriver driver;
	 FileWriter writer;
	 String header = "model,price,ratting";
		String delimiter=",";
		String newline="\n";
		@Given("user is present on the login page")
		public void user_is_present_on_the_login_page()  {
		    System.out.println("user is at the login page");
		    System.setProperty("webdriver.gecko.driver", "E:\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/");
		}

		@When("title of the page is")
		public void title_of_the_page_is() {
			String s = driver.getTitle();
			System.out.println("title of the page is");
			
		}

		@Then("user enters username and password")
		public void user_enters_username_and_password() {
			System.out.println("user enters username and password");
			driver.findElement(By.xpath("//input[@class=\"_2zrpKA _1dBPDZ\"]")).sendKeys("8867247166");
			driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Suma@1106");
		}

		@Then("clicks on submit button")
		public void clicks_on_submit_button() {
			System.out.println("clicks on submit button");
			driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();
		}

		@Then("user is at home page")
		public void user_is_at_home_page() {
			System.out.println("user is at home page");
		    String hometitle = driver.getTitle();
		    Assert.assertEquals(hometitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		   
		}
		
		@Given("^user is in the home page$")
		public void user_is_in_the_home_page()  {
			System.out.println("user is in the home page");
			String hometitle = driver.getTitle();
		    Assert.assertEquals(hometitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		}

		@When("^user enter iphone in the search box and presses enter$")
		public void user_enter_iphone_in_the_search_box_and_presses_enter() {
			driver.findElement(By.xpath("//input[@class=\"LM6RPg\"]")).sendKeys("iphone");
			driver.findElement(By.xpath("//input[@class=\"LM6RPg\"]")).sendKeys(Keys.ENTER);
		}

		@Then("^user creates a file$")
		public void user_creates_a_file() throws IOException{
			
			writer = new FileWriter("E:\\suma-testing\\SumaFlipkartSelenium\\src\\main\\java\\Test\\prac\\demo.csv");
			writer.append(header);
		}
		
		@And("^user stores details of all the iphoes having max price 40000$")
		public void user_stores_the_iphone_details_in_a_file() throws IOException {
			List<WebElement> F = driver.findElements(By.xpath("//a[@class=\"_2Xp0TH\"]"));
			for(int j=0;j<F.size();j++) {
			List<WebElement> L1 = driver.findElements(By.xpath("//div[@class=\"_3wU53n\"]"));
			List<WebElement> L2 = driver.findElements(By.xpath("//div[@class=\"_1vC4OE _2rQ-NK\"]"));
			List<WebElement> L3 = driver.findElements(By.xpath("//span[@class=\"_38sUEc\"]"));
			for(int i=0;i<L1.size();i++) {
				String amt=L2.get(i).getText();
				String price=amt.replaceAll("[^a-zA-Z0-9]", "");
				String model = L1.get(i).getText();
				String review = L3.get(i).getText();
				String rating1[] = review.split("&");
				String rating=rating1[0].replaceAll("[^a-zA-Z0-9]", "");	
				if(Integer.parseInt(price)<= 40000) {
					writer.append(newline);
					writer.append(model);
					writer.append(delimiter);
					writer.append(amt);
					writer.append(delimiter);
					writer.append(rating);				
				System.out.println(L1.get(i).getText()+","+L2.get(i).getText()+","+L3.get(i).getText());
				}
			}
			}
		}
		
		@Then("^closes the file and the application$")
		public void closes_the_file_and_the_application() throws IOException{
			writer.flush();
			writer.close();
			driver.close();
		}

}
