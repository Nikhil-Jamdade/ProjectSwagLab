package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import pages.SLogin;

public class SLoginTest extends SBaseClass {

	@Test
	public void ValidLogin() throws FilloException, InterruptedException {
		Recordset recordset = connection.executeQuery("select * from Data where Testname='ValidLogin'");
		recordset.next();

		String UserName = recordset.getField("User");
		String Password = recordset.getField("Pass");

		SLogin login = new SLogin(driver);
		login.LoginFunc(UserName, Password);
	}

	@Test(dependsOnMethods="ValidLogin")
	public void InValidLogin() throws FilloException, InterruptedException {

		Recordset recordset = connection.executeQuery("select * from Data where Testname='InvalidLogin'");
		recordset.next();

		String UserName = recordset.getField("User");
		String Password = recordset.getField("Pass");

		SLogin login = new SLogin(driver);
		login.LoginFunc(UserName, Password);
		WebElement error = driver.findElement(By.xpath("//h3"));
		String ActError = error.getText();
		String ExpError = "Epic sadface: Sorry, this user has been locked out.";

		Assert.assertEquals(ExpError, ActError);
	}

}
