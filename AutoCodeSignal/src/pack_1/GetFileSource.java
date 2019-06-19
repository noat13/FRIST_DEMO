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
	public static final String PATH_SRC = "D:\\GitHub\\CodeFight\\Answer";
	public static void main(String[] args) {
		ArrayList<String> urlList = new ArrayList<>();
		// declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","D:\\GitHub\\CodeFight\\chromedriver.exe");

		int count = 61;
		while (count <1000) {
			WebDriver driver = new ChromeDriver();
			count ++;
			System.out.println("Tao file Page : " + count );
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
				/// go tour
				 driver.get(baseUrl);
			    Thread.currentThread();
				Thread.sleep(5000);

			    WebElement table = driver.findElement(By.tagName("tbody"));
			    List<WebElement> rows = table.findElements(By.tagName("tr"));
			    List<String> urlLst = new ArrayList<>();
			    for (WebElement webElement : rows) {
			    	String url = webElement.findElement(By.tagName("a")).getAttribute("href");
			    	urlLst.add(url);
			    }

			    for (String string : urlLst) {
			    	String urlA = string.concat("/A");
			    	String urlB = string.concat("/B");
				    String urlC = string.concat("/C");
				    String urlD = string.concat("/D");
				    String urlE = string.concat("/E");
				    LoopAB(driver,urlA, false);
				    LoopAB(driver,urlB, false);
				    LoopAB(driver,urlC, true);
				    LoopAB(driver,urlD, true);
				    LoopAB(driver,urlE, true);

				}

			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {

			}
			return sleep;
	    }

	public static void LoopAB(WebDriver driver,String url, boolean isNotAB) {

	    try {
			driver.get(url);

	    	Thread.currentThread();
			Thread.sleep(5000);
		    String language ="";

	    	WebElement solution = driver.findElement(By.cssSelector("div:nth-child(2) > .vertical-tabs--item"));;
		    solution.click();
		    Thread.currentThread();
			Thread.sleep(5000);

		    List<WebElement> solutionRows = driver.findElements(By.cssSelector(".rt-tr-group"));
			solutionRows.get(0).click();
			boolean isFirstRow = true;
		    for (WebElement detailSolutionRows : solutionRows) {
		    	List<WebElement> detailSolution = detailSolutionRows.findElements(By.cssSelector(".rt-td"));
		    	if (language.length() == 0
		    			&& (!isNotAB || "300".equals(detailSolution.get(3).getText()))
		    			&& ( detailSolution.get(2).getText().contains("Py3")
			    			|| detailSolution.get(2).getText().contains("Py2"))) {
		    		language = detailSolution.get(2).getText();
		    		if (!isFirstRow) {
			    		detailSolution.get(2).click();
		    		}
			    	Thread.currentThread();
					Thread.sleep(2000);
		    		break;
		    	}
		    	if (language.length() == 0
		    			&& (!isNotAB || "300".equals(detailSolution.get(3).getText()))
		    			&& ( detailSolution.get(2).getText().contains("Java")
				    			|| detailSolution.get(2).getText().contains("JS")
				    			|| detailSolution.get(2).getText().contains("C++"))) {
		    		language = detailSolution.get(2).getText();
		    		if (!isFirstRow) {
		    			detailSolution.get(2).click();
		    		}
			    	Thread.currentThread();
					Thread.sleep(2000);
		    		break;
		    	}
		    	isFirstRow = false;
		    }
		    	Thread.currentThread();
				Thread.sleep(2000);
		    	WriteFile(driver,language);
		} catch (Exception e) {
			// see task
			//System.out.println("REGISTER Khong tim thay");

		}

    }
	 public static void Login(WebDriver driver) {

	        String loginUrl = "https://app.codesignal.com/login";

			try {
				driver.get(loginUrl);
		        Thread.currentThread();
				Thread.sleep(2000);
		        driver.findElement(By.name("username")).sendKeys("noatnd");;
		        driver.findElement(By.name("password")).sendKeys("noatnd@1");
		        Thread.currentThread();
				Thread.sleep(2000);
		        driver.findElement(By.cssSelector(".-padding-v-2 > .button--content")).click();;
		        System.out.println("Login OK");
		        Thread.currentThread();
				Thread.sleep(2000);

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
			     String folderJS = PATH_SRC + "\\JS\\";
			     String folderJava = PATH_SRC + "\\Java\\";
			     String folderC = PATH_SRC + "\\C++\\";
			     String folderPy2 = PATH_SRC + "\\Py2\\";
			     String folderPy3 = PATH_SRC + "\\Py3\\";

			     String folder = "";
			     String content = "";

			     code.sendKeys(Keys.CONTROL + "a");
		         Thread.currentThread();
				Thread.sleep(2000);
		         code.sendKeys(Keys.CONTROL + "c");

		         content = (String) Toolkit.getDefaultToolkit()
		                 .getSystemClipboard().getData(DataFlavor.stringFlavor);
		         Thread.currentThread();
				Thread.sleep(1000);
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
				if(language.equals("")) {
					folder = "";
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
