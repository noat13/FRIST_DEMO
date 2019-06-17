package pack_1;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class MyClass {

	public static void main(String[] args) {

		ArrayList<String> urlList = new ArrayList<>();
		// declaration and instantiation of objects/variables
		//System.setProperty("webdriver.chrome.marionette","F:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		int count = 5000;

		Login(driver);
		while (count > 4985) {
			Integer sleep = 3;
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  Lam thu : " + (5001 - count));
			sleep = CodeFight(driver, urlList);
			count --;
			try {
				Random r = new Random();
			    int time = r.nextInt(2);
			    sleep += time;
			    System.out.println("Cho de dang ky Tournaments : " + sleep + " Minute");
				Thread.currentThread().sleep(sleep*60000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロ�?ク
				e.printStackTrace();
			}

		}
		driver.close();
		// TODO: handle finally clause
	}

	public static Integer CodeFight(WebDriver driver, ArrayList<String> urlList) {
			Integer sleep = 2;
	        String baseUrl = "https://app.codesignal.com/tournaments";

			try {
				/// vao tour
				 driver.get(baseUrl);
			    Thread.currentThread().sleep(15000);

			    try {
			    	WebElement gotask = driver.findElement(By.cssSelector(".-flex > .button > .button--content"));;
				    if (gotask.getText().equals("LET'S GO!")) {
				    	gotask.click();
				    }
				    if (gotask.getText().equals("DONE")) {
				    	gotask.click();
				    }
				    gotask.click();

				} catch (Exception e) {
					// see task
					//System.out.println("Dong dialog neu co");
				}


			    WebElement table = driver.findElement(By.tagName("tbody"));
			    List<WebElement> rows = table.findElements(By.tagName("tr"));
//			    WebElement a =rows.get(0).findElement(By.tagName("a")).getAttribute("href");
//			    a.click();

			    //dang ky hay vao tour

			    String currentUrl = rows.get(0).findElement(By.tagName("a")).getAttribute("href");
			    Thread.currentThread().sleep(10000);
			    boolean see = true;
			    boolean registerFlag = false;
			    Integer loopPlay = 0;
			    while (see) {
			    	loopPlay ++;
					if (loopPlay > 50 ) {
						driver.get(baseUrl);
					}
			    	driver.get(currentUrl);
			    	Thread.currentThread().sleep(10000);
				    try {


					    WebElement Error = driver.findElement(By.cssSelector("h2"));;
					    if (Error.getText().equals("Tournament is not found")) {
					    	see = false;
					    	currentUrl = "https://app.codesignal.com/tournaments";
					    }

				    	WebElement register = driver.findElement(By.cssSelector(".-hide-xs-lte .button--content"));;
					    if (register.getText().equals("REGISTER")) {
					    	register.click();
					    	registerFlag = true;
					    	//confirm dang ky
					    	driver.findElement(By.cssSelector(".-type-primary > .button--content")).click();;
					    	currentUrl = driver.getCurrentUrl();
					    }
					} catch (Exception e) {
						// see task
						//System.out.println("REGISTER Khong tim thay");

					}

				    try {
				    	WebElement gotask = driver.findElement(By.cssSelector(".-flex > .button > .button--content"));;
					    if (gotask.getText().equals("LET'S GO!")) {
					    	gotask.click();
					    	//confirm dang ky
					    }
					    if (gotask.getText().equals("DONE")) {
					    	gotask.click();
					    	//confirm dang ky
					    	see = false;
					    }

					} catch (Exception e) {
						// see task
						//System.out.println("See tasks Khong tim thay");
					}

			    	try {
				    	WebElement closeButton = driver.findElement(By.cssSelector(".growl-notification--close-button"));;
				    	closeButton.click();
				    	closeButton = driver.findElement(By.cssSelector(".growl-next-regular-tournament--footer .button--content"));;
				    	closeButton.click();

					} catch (Exception e) {
						// see task
						//System.out.println("Khong co Close button");
					}
			    	try {
			    		WebElement Pending = driver.findElement(By.cssSelector(".-view-glass > .-layout-h"));;
			    		WebElement registerElement = driver.findElement(By.cssSelector(".-nowrap"));;

					    if (Pending.getText().contains("Pending") && registerElement.getText().contains("registered")) {
					    	Pattern p = Pattern.compile("\\d+");

					    	WebElement countdown = driver.findElement(By.cssSelector(".countdown"));;
					    	if (countdown.getText().contains("seconds") || countdown.getText().contains("a minute")) {
					    		Thread.currentThread().sleep(60000);
					    	} else {
					    		Matcher m = p.matcher(countdown.getText());
						        while(m.find()) {
						            System.out.println("Waiting Tournaments : " + m.group() + " Minute");
						            Integer countdownStr = Integer.parseInt(m.group());
									Thread.currentThread().sleep((countdownStr - 1) * 60000);

						        }
					    	}

					    }

					} catch (Exception e) {
						// see task
						//System.out.println("chua co dang ky");
					}
				    try {
				    	WebElement seetask = driver.findElement(By.cssSelector(".-vertical > .button > .button--content"));;
					    if (seetask.getText().equals("SEE TASKS")) {
					    	seetask.click();
					    	//confirm dang ky
					    	see = false;
					    }

					} catch (Exception e) {
						// see task
						//System.out.println("See tasks Khong tim thay");
					}

				    try {
				    	WebElement winner = driver.findElement(By.tagName("h3"));;
					    if (winner.getText().equals("And the Winner is")) {
					    	see = false;
					    	driver.get(baseUrl);
					    }

					} catch (Exception e) {
						// see task
						//System.out.println("chua co nguoi winner");
					}

			    }

			    System.out.println("Tournaments : " + currentUrl);

			    String urlA = currentUrl.concat("/A");
			    String urlB = currentUrl.concat("/B");
			    String urlC = currentUrl.concat("/C");
			    String urlD = currentUrl.concat("/D");
			    String urlE = currentUrl.concat("/E");


			    Random r = new Random();
			    int time = r.nextInt(3);
//			    WriteAnswer(urlA,driver);
//			    Thread.currentThread().sleep(time * 30000);
//			    time = r.nextInt(3)+1;
//			    WriteAnswer(urlB,driver);
//			    Thread.currentThread().sleep(time * 30000);
//			    time = r.nextInt(3)+1;
			    WriteAnswer(urlC,driver);
			    Thread.currentThread().sleep(time * 30000);
			    WriteAnswer(urlD,driver);
			    time = r.nextInt(3);
			    Thread.currentThread().sleep(time * 40000);
			    WriteAnswer(urlE,driver);
			    time = r.nextInt(3);
			    Thread.currentThread().sleep(time * 40000);

			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					try {
				    	List<WebElement> timer = driver.findElements(By.cssSelector(".task-title--subheader"));;
				    	for (WebElement webElement : timer) {
				    		String[] timerStr = webElement.getText().split("M");
					    	Integer timerIns = Integer.valueOf(timerStr[0].substring(timerStr[0].length()-1, timerStr[0].length()));
					    	System.out.println("*************************************Cho Tour moi sau : " + timerIns + "minute ****************************************** ");
					    	//Thread.currentThread().sleep((timerIns + 1)*60000);
					    	sleep = timerIns +1;
						}

					} catch (Exception e) {
						// see task
						//System.out.println("chua co nguoi winner");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return sleep;
	    }

	 public static void Login(WebDriver driver) {

	        String loginUrl = "https://app.codesignal.com/login";

			try {
				driver.get(loginUrl);
		        Thread.currentThread().sleep(2000);
		        driver.findElement(By.name("username")).sendKeys("AAAAAA");;
		        driver.findElement(By.name("password")).sendKeys("BBBBBB");
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

	 private static boolean WriteAnswer(String url, WebDriver driver) {
		 driver.get(url);
		 System.out.println(driver.getCurrentUrl());
		String  menthodName = "";
		try {
			Thread.currentThread().sleep(10000);
			WebElement code = driver.findElement(By.cssSelector(".CodeMirror textarea"));;
			//WebElement code = driver.findElement(By.className("CodeMirror-code"));;
			JavascriptExecutor js = (JavascriptExecutor) driver;


			Thread.currentThread().sleep(3000);

			WebElement menthodNameElement = driver.findElement(By.cssSelector(".cm-def:nth-child(2)"));;
			menthodName = menthodNameElement.getText();
			if (menthodName.length() > 0) {
				//menthodName = menthodName.split("(")[0];
				//menthodName = menthodName.replace("function ", "");
			     File folderJS = new File("F:\\Selenium\\OTS\\CodeFights-master\\CodeFights-master\\solutions\\javascript\\" + menthodName + ".js");
			     File folderJava = new File("F:\\Selenium\\OTS\\Java_new\\" + menthodName + ".java");

		         String sourceCode = new String("");
		         String sourceCodeJS = new String("");
		         String sourceCodeJava = new String("");
		         String Mode = "JS";
		         // Doc source JS
		         sourceCodeJS = readContent(folderJS);
		         if (sourceCodeJS.length() > 0) {
		        	 sourceCode = sourceCodeJS;
		        	 System.out.println("OK=======Co Source JS");
		         } else {
		        	 sourceCodeJava = readContent(folderJava);
		        	 if (sourceCodeJava.length() > 0) {
		        		 Mode = "Java";
			        	 sourceCode = sourceCodeJava;
			        	 System.out.println("OK=======Co Source Java ");
		        	 } else {
		        		 createFileNotFound("F:\\Selenium\\OTS\\Method_SourceCodeNotFound\\",menthodName,"java");
		        	 }
		         }

		         if (sourceCode.length() > 0) {
		        	 // Chon ngon ngu
		        	 try {
						    if (Mode.equals("Java")) {
						    	WebElement language = driver.findElement(By.cssSelector(".select:nth-child(2) .select--title"));;
						    	language.click();
						    	Thread.currentThread().sleep(3000);
					    		WebElement language1 = driver.findElement(By.cssSelector(".-space-v-8:nth-child(3) > .select-menu--item:nth-child(1) > .select-menu--text"));;
					    		language1.click();

						    }
						    if (Mode.equals("JS")) {
						    	WebElement language = driver.findElement(By.cssSelector(".select:nth-child(2) .select--title"));;
						    	language.click();
						    	Thread.currentThread().sleep(3000);
						    	WebElement language1 = driver.findElement(By.cssSelector(".-space-v-8:nth-child(3) > .select-menu--item:nth-child(2) > .select-menu--text"));;
					    		language1.click();
						    }

						} catch (Exception e) {
							// see task
							System.out.println("FAIL=======Loi chon ngon ngu");
						}

		        	 String myString = sourceCode;
		        	 StringSelection stringSelection = new StringSelection(myString);
		        	 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		        	 clipboard.setContents(stringSelection, null);

		        	code.sendKeys(Keys.CONTROL + "a");
		        	Thread.currentThread().sleep(sourceCode.length()*100);
		 			//code.sendKeys(sourceCode);
		 			code.sendKeys(Keys.CONTROL + "v");
			         //String executeScript = "return document.getElementsByClassName(' CodeMirror-line ')[0].innerText='" + sourceCode +"'";
			         //js.executeScript(executeScript);

		 			Thread.currentThread().sleep(22000);
		 			try {
				    	WebElement submit = driver.findElement(By.cssSelector(".-type-success > .button--content"));;
				    	submit.click();
				    	Thread.currentThread().sleep(10000);

				    	WebElement messageSubmit = driver.findElement(By.cssSelector(".verdict-message"));;
				    	if (messageSubmit.getText().contains("error") && Mode.equals("JS")) {
				    		System.out.println("FAIL=======Dap AN JS SAI");
				    		createFileNotFound("F:\\Selenium\\OTS\\Method_SourceCodeError\\",menthodName,"js");
				    		WebElement language = driver.findElement(By.cssSelector(".select:nth-child(2) .select--title"));;
					    	language.click();
					    	Thread.currentThread().sleep(3000);
					    	// neu la JS chon lai Java
						    WebElement language1 = driver.findElement(By.cssSelector(".-space-v-8:nth-child(3) > .select-menu--item:nth-child(1) > .select-menu--text"));;
					    	language1.click();
						    sourceCode = readContent(folderJava);
//						    try {
//							    Thread.currentThread().sleep(1000);
//							    js.executeScript("return document.getElementsByClassName(' CodeMirror-line ')[0].remove();");
//					 			js.executeScript("return document.getElementsByClassName(' CodeMirror-line ')[0].remove();");
//					 			js.executeScript("return document.getElementsByClassName(' CodeMirror-line ')[0].remove();");
//					 			Thread.currentThread().sleep(1000);
//							} catch (Exception e) {
//								// TODO: handle exception
//							}

//				 			code.sendKeys(sourceCode);
						    stringSelection = new StringSelection(myString);
				        	clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				        	clipboard.setContents(stringSelection, null);

				        	code.sendKeys(Keys.CONTROL + "a");
				        	Thread.currentThread().sleep(sourceCode.length()*100);
				 			code.sendKeys(Keys.CONTROL + "v");

				 			Thread.currentThread().sleep(10000);
				 			messageSubmit = driver.findElement(By.cssSelector(".verdict-message"));;
					    	if (messageSubmit.getText().contains("error")) {
					    		System.out.println("FAIL========Dap AN JAVA SAI");
					    		createFileNotFound("F:\\Selenium\\OTS\\Method_SourceCodeError\\",menthodName,"java");
					    	} else {
					    		System.out.println("OK*******Co Dap AN JAVA");
					    	}
					    } else {
					    	System.out.println("OK*******Khong Co Dap AN JS");
					    }

					} catch (Exception e) {
						// see task
						System.out.println("ERROR========Co Loi");
						createFileNotFound("F:\\Selenium\\OTS\\Method_SourceCodeError\\",menthodName,"java");
						e.printStackTrace();
					}

		         } else {

		        	 System.out.println("FAIL=========Khong Co Dap AN");
		         }
			}

		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {

		}
		return true;
	 }
//		    // Uses Files.walk method
//		    public void listAllFiles(String path){
//		        System.out.println("In listAllfiles(String path) method");
//		        try(Stream<Path> paths = Files.walk(Paths.get(path))) {
//		            paths.forEach(filePath -> {
//		                if (Files.isRegularFile(filePath)) {
//		                    try {
//		                        readContent(filePath);
//		                    } catch (Exception e) {
//		                        // TODO Auto-generated catch block
//		                        e.printStackTrace();
//		                    }
//		                }
//		            });
//		        } catch (IOException e) {
//		            // TODO Auto-generated catch block
//		            e.printStackTrace();
//		        }
//		    }

		    private static String readContent(File file) {
		    	try {
		    		System.out.println("read file " + file.getCanonicalPath() );
			        StringBuffer allLine = new StringBuffer();
			        String temp = "";
			        try(BufferedReader br  = new BufferedReader(new FileReader(file))){
			              String strLine;
			              // Read lines from the file, returns null when end of stream
			              // is reached
			              while((strLine = br.readLine()) != null){
			               //System.out.println(strLine);
			               allLine.append(strLine).append("\n");
			              }
			        }
			        temp = allLine.toString();
			        System.out.println(temp);
			        return temp;
				} catch (Exception e) {
					return "";
				}
		    }

//		    public String readContent(Path filePath) throws IOException{
//		    	StringBuffer allLine = new StringBuffer();
//		        System.out.println("read file " + filePath);
//		        List<String> fileList = Files.readAllLines(filePath);
//		        System.out.println("" + fileList);
//		        return fileList.toString();
//		    }


		    private static void createFileNotFound(String folder, String fileName, String extention) throws IOException
		    {
		    	  File file = new File(folder + fileName + "." + extention);
		          //Create the file
		          if (file.createNewFile()){
		            System.out.println("File is created : " + file.getName());
		          }else{
		            System.out.println("File already exists : " + file.getName());
		          }

		          //Write Content
		          FileWriter writer = new FileWriter(file);
		          writer.write("Loi");
		          writer.close();
		    }
		}



