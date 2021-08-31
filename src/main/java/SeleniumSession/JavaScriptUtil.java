package SeleniumSession;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtil {
	
	private WebDriver driver;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
	}

	public String gettitleByJS()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}
	
	public void refreshBrowserByJS() {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
		
	}

}
