package alert;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JobAlert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","src\\alert\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);

		//Go to job page
		driver.get("https://zwift.com/careers/");
		driver.switchTo().frame("grnhse_iframe");

		// Find the QA job postings
		List<WebElement> jobs = driver.findElements(By.partialLinkText("QA"));

		//TODO add a condition for checking if the posting is new and in Long Beach

		//Check number of QA postings
		System.out.println(jobs.size() + " Job Postings:");

		//Print each job posting
		for (int i=0; i<jobs.size();i++) {
			System.out.println(jobs.get(i).getText());
		}

		//Close the browser
		driver.quit();
	}
}
