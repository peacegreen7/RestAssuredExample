package Helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumHelpers {
	
	static public WebDriver driver;
	
	public void init(String dpath, String url) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", dpath);
		driver= new ChromeDriver();
        Actions act = new Actions(driver);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        Thread.sleep(3000);
	}
	
	public void reset() {
		driver.close();
	}
	
	public void LoginPage(String email, String pwd) throws InterruptedException{
        WebElement eleEmail = driver.findElement(By.id("formHorizontalEmail"));
        eleEmail.sendKeys(email);
        WebElement elePwd = driver.findElement(By.id("formHorizontalPassword"));
        elePwd.sendKeys(pwd);
        WebElement btnLogin = driver.findElement(By.className("col-login__btn"));
        btnLogin.click();
        Thread.sleep(3000);
	}
	
	public ArrayList<String> getCurrentData() {
		
		WebElement table = driver.findElement(By.className("table-body"));
		ArrayList<String> aList = new ArrayList<String>();
				
		for (int i = 1; i <= getNumberRows(); i++) {
			WebElement fcell = table.findElement(By.xpath(".//tr["+i+"]/td[6]"));
			String text = fcell.getText();
			aList.add(text);
		}
		return aList;
	}
	
	public ArrayList<String> getDataASC() {
    	ArrayList<String> List = getCurrentData();
    	Collections.sort(List);
    	return List;
    }
    
    public ArrayList<String> getDataDESC() {
    	ArrayList<String> List = getDataASC();
    	Collections.sort(List, Collections.reverseOrder());
    	return List;
    }
    
    public int getNumberRows() {
    	List rows = driver.findElements(By.xpath(".//tr/td[2]")); 
        return rows.size();
    }
		
	//Sort action
	public void doSort(int flag) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement header = driver.findElement(By.className("table-header"));
		WebElement hcell = driver.findElement(By.xpath(".//tr[1]/th[6]"));
		
		// sort ASC if flag = 2
		// sort DESC if flag = 1
		if (flag == 2) {		
			actions.doubleClick(hcell).perform();
		} else if (flag == 1) {
			actions.click(hcell).perform();
		}	
		Thread.sleep(1000);
	}
	
	// select Filter
	public void selectFilter(int index) throws InterruptedException {
		WebElement btn_filter = driver.findElement(By.className("module_grid__btn_filter"));
		btn_filter.click();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id("formControlsSelect")));
		select.selectByIndex(index);
		WebElement btn = driver.findElement(By.xpath("//button[text()='Apply Filters']"));
		btn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	// check result after filter
	public boolean isGetCorrectRequestStatus(String status) {
		
		WebElement table = driver.findElement(By.className("table-body"));
		ArrayList<String> aList = new ArrayList<String>();
		boolean check = false;
				
		for (int i = 1; i <= getNumberRows(); i++) {
			WebElement cell = table.findElement(By.xpath(".//tr["+i+"]/td[2]"));
			String text = cell.getText();
			aList.add(text);
		}
		
		for (int j = 0; j < aList.size(); j++) {
			if (aList.get(j).equals(status)) {
				check = true;
				continue;
			} else {
				check = false;
				break;
			}
		}
		return check;
	}
	
	// check result after filter
	public void getXpath(String status, String date) {
		
		WebElement requestStatus = null;
		WebElement submitDate = null;
			
		for (int i = 1; i <= getNumberRows(); i++) {
			requestStatus = driver.findElement(By.xpath(".//tr["+i+"]/td[2]"));
			submitDate = driver.findElement(By.xpath(".//tr["+i+"]/td[3]"));
			
			if (requestStatus.getText().contains(status) && submitDate.getText().contains(date)) {
				System.out.println(requestStatus + " " + submitDate);
			}
		}
	}
}
