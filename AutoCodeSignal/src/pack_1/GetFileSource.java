package pack_1;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetFileSource {

	public static void main(String[] args) {
		ArrayList<String> urlList = new ArrayList<>();
		// declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");

		int count = 2;
		while (count <1000) {
			WebDriver driver = new ChromeDriver();
			count ++;
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Tao file Page : " + count );
			Login(driver);
			CodeFight(driver, urlList,count);
			driver.close();
		}
		// TODO: handle finally clause

    }
	public static Integer CodeFight(WebDriver driver, ArrayList<String> urlList,int page) {
			Integer sleep = 10;
	        String baseUrl = "https://app.codesignal.com/tournaments/page/"+ String.valueOf(page);

			try {
				/// vao tour
				 driver.get(baseUrl);
			    Thread.currentThread().sleep(5000);

			    WebElement table = driver.findElement(By.tagName("tbody"));
			    List<WebElement> rows = table.findElements(By.tagName("tr"));
			    int i=0;
			    List<String> urlLst = new ArrayList<>();
			    for (WebElement webElement : rows) {
			    	String url = webElement.findElement(By.tagName("a")).getAttribute("href");
			    	urlLst.add(url);
			    }

			    for (String string : urlLst) {
			    	String urlA = string.concat("/A");
				    String urlB = string.concat("/B");
				    LoopAB(driver,urlA);
				    LoopAB(driver,urlB);

				}

			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {

			}
			return sleep;
	    }

	public static void LoopAB(WebDriver driver,String url) {

	    try {
			driver.get(url);

	    	Thread.currentThread().sleep(5000);
		    String language ="";

	    	WebElement solution = driver.findElement(By.cssSelector("div:nth-child(2) > .vertical-tabs--item"));;
		    solution.click();
		    Thread.currentThread().sleep(5000);

		    List<WebElement> solutionRows = driver.findElements(By.cssSelector(".rt-tr-group"));
		    solutionRows.get(0).click();
		    for (WebElement detailSolutionRows : solutionRows) {
		    	List<WebElement> detailSolution = detailSolutionRows.findElements(By.cssSelector(".rt-td"));
		    	if (language.length() == 0 && ( detailSolution.get(2).getText().contains("Java")||
		    			detailSolution.get(2).getText().contains("JS")
		    			|| detailSolution.get(2).getText().contains("Py3")
		    			|| detailSolution.get(2).getText().contains("Py2")
		    			|| detailSolution.get(2).getText().contains("C++"))) {
		    		language = detailSolution.get(2).getText();
		    		break;
		    	}
		    }
		    if (language.length() > 0) {
		    	Thread.currentThread().sleep(2000);
		    	WriteFile(driver,language);
		    }

		} catch (Exception e) {
			// see task
			//System.out.println("REGISTER Khong tim thay");

		}

    }
	 public static void Login(WebDriver driver) {

	        String loginUrl = "https://app.codesignal.com/login";

			try {
				driver.get(loginUrl);
		        Thread.currentThread().sleep(2000);
		        driver.findElement(By.name("username")).sendKeys("toan-nd_fjs");;
		        driver.findElement(By.name("password")).sendKeys("111111Aa");
		        Thread.currentThread().sleep(2000);
		        driver.findElement(By.cssSelector(".-padding-v-2 > .button--content")).click();;
		        System.out.println("Login OK");
		        Thread.currentThread().sleep(2000);

			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {

			}
	    }

	 private static boolean WriteFile(WebDriver driver, String language) {
		String  menthodName = "";
		try {
			WebElement code = driver.findElement(By.cssSelector(".CodeMirror textarea"));;
			//WebElement code = driver.findElement(By.className("CodeMirror-code"));;
			//JavascriptExecutor js = (JavascriptExecutor) driver;


			WebElement menthodNameElement = driver.findElement(By.cssSelector(".cm-def:nth-child(2)"));;
			menthodName = menthodNameElement.getText();
			if (menthodName.length() > 0) {
				//menthodName = menthodName.split("(")[0];
				//menthodName = menthodName.replace("function ", "");
			     String folderJS ="E:\\DOCUMENT\\CODESIGNAL\\Selenium\\JS\\";
			     String folderJava = "E:\\DOCUMENT\\CODESIGNAL\\Selenium\\Java\\";
			     String folderC = "E:\\DOCUMENT\\CODESIGNAL\\Selenium\\C++\\";
			     String folderPy2 = "E:\\DOCUMENT\\CODESIGNAL\\Selenium\\Py2\\";
			     String folderPy3 = "E:\\DOCUMENT\\CODESIGNAL\\Selenium\\Py3\\";


			     String folder = "";
			     String content = "";

			     code.sendKeys(Keys.CONTROL + "a");
		         Thread.currentThread().sleep(2000);
		         code.sendKeys(Keys.CONTROL + "c");

		         content = (String) Toolkit.getDefaultToolkit()
		                 .getSystemClipboard().getData(DataFlavor.stringFlavor);
		         Thread.currentThread().sleep(1000);
				if(language.equals("JS")) {
					folder = folderJS;
				}
				if(language.equals("Java")) {
					folder = folderJava;
				}
				if(language.equals("Py2")) {
					folder = folderPy2;
				}
				if(language.equals("Py3")) {
					folder = folderPy3;
				}
				if(language.equals("C++")) {
					folder = folderC;
				}
			    createFileSource(folder,menthodName, language, content);

			}

		}catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		 return true;
	 }

		    private static void createFileSource(String folder, String fileName, String extention,String content) throws IOException
		    {
		    	  File file = new File(folder + fileName + "." + extention);
		          //Create the file
		          if (file.createNewFile()){
		            System.out.println("File is created!" + file.getName());
		          }else{
		            System.out.println("File already exists." + file.getName());
		          }

		          //Write Content
		          FileWriter writer = new FileWriter(file);
		          writer.write(content);
		          writer.close();
		    }
		}



