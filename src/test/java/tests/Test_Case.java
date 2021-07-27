package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadFile;

public class Test_Case {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void verifyContentFile() {

		// please not forgot to change the file location
		System.out.println("--------please not forgot to change the file location-------");
		String url = "file:///D:/TasksTimer%20WKS/ReadPDFFileUsingSelenim/doc/1-Fiche_Prog_JEE.pdf";
		String path = System.getProperty("user.dir");
		System.out.println(path);
		driver.get(url);

		try {
			String pdfContent = ReadFile.readContentFile(url);
			ReadFile.getPageCount(ReadFile.doc);
			System.out.println("--------------------------------");
			System.out.println(pdfContent);
			System.out.println("--------------------------------");
			Assert.assertTrue(pdfContent.contains("Développement Java EE  (Hibernate, Spring, JSF2) "));
			Assert.assertTrue(pdfContent.contains("Pré-requis"));
			Assert.assertTrue(pdfContent.contains("- Connaissance en JAVA"));
			Assert.assertTrue(pdfContent
					.contains("- Cette formation s'adresse aux développeurs, \r\n" + "concepteurs et chefs de projet"));
			// features"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
