package tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadFile;

public class Test_Case extends BaseTest {

	@Test
	public void verifyContentFile() {

		// please don't forgot to change the file location
		System.out.println("--------please don't forgot to change the file location-------");
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
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
