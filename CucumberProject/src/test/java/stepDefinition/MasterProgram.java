package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterProgram {
	public WebDriver d;
	
	
	@Given("^Launch site$")
	public void launch_site() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Given Executed");
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
	    opt.addArguments("--remote-allow-origins=*");
		d= new ChromeDriver(opt);
		d.get("https://www.opencart.com/");
		Thread.sleep(10000);
	}

	@When("^Enter username$")
	public void enter_username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When 1st executed");
		//WebElement reg=d.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[2]/a"));
		WebElement MP=d.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[3]/a"));
		Actions act=new Actions(d);
	act.click(MP).build().perform();
	d.findElement(By.xpath("/html/body/header/nav/div/div[1]/a/img")).click();
	}

	@When("^Enter password$")
	public void enter_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When 2nd executed");

	WebElement fe=d.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[1]/a"));
	Point locate=fe.getLocation();
	int X=locate.getX();
	int Y=locate.getY();
	Actions act=new Actions(d);

	act.moveByOffset(X, Y).build().perform();
	act.click(fe).build().perform();

	}

	@When("^Click submit button$")
	public void click_submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When 3rd executed");

	  
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Then executed");

	  
	}
}