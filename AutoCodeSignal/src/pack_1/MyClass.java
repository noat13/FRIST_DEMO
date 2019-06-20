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
	public static final String PATH_SOURCE = "D:\\GitHub\\CodeFight\\Answer\\";

	public static void main(String[] args) {

		ArrayList<String> urlList = new ArrayList<>();
		// declaration and instantiation of objects/variables
		// System.setProperty("webdriver.chrome.marionette","F:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\GitHub\\CodeFight\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int count = 100000;

		Login(driver);
		while (count > 4985) {
			Integer sleep = 3;
			System.out.println(
					"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  Lam thu : " + (5001 - count));
			sleep = CodeFight(driver, urlList);
			count--;
			try {
				Random r = new Random();
				int time = r.nextInt(2);
				sleep += time;
				System.out.println("Cho de dang ky Tournaments : " + sleep + " Minute");
				Thread.currentThread();
				Thread.sleep(sleep * 60000);
			} catch (InterruptedException e) {
				// TODO è‡ªå‹•ç”Ÿæˆ�ã�•ã‚Œã�Ÿ catch ãƒ–ãƒ­ãƒ?ã‚¯
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
			Thread.currentThread();
			Thread.sleep(5000);
			try {
				WebElement gotask = driver.findElement(By.cssSelector(".-flex > .button > .button--content"));
				;
				if (gotask.getText().equals("LET'S GO!")) {
					gotask.click();
				}
				if (gotask.getText().equals("DONE")) {
					gotask.click();
				}
				gotask.click();

			} catch (Exception e) {
				// see task
				// System.out.println("Dong dialog neu co");
			}

			WebElement table = driver.findElement(By.tagName("tbody"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));

			// dang ky hay vao tour
			String currentUrl = rows.get(0).findElement(By.tagName("a")).getAttribute("href");
			Thread.currentThread();
			Thread.sleep(10000);
			boolean see = true;
			boolean registerFlag = false;
			Integer loopPlay = 0;
			while (see) {
				
				Thread.currentThread();
				Thread.sleep(5000);
				loopPlay++;
				if (loopPlay > 50) {
					driver.get(baseUrl);
				}
				driver.get(currentUrl);
				Thread.currentThread();
				Thread.sleep(10000);
				try {

					WebElement Error = driver.findElement(By.cssSelector("h2"));
					;
					if (Error.getText().equals("Tournament is not found")) {
						see = false;
						currentUrl = "https://app.codesignal.com/tournaments";
					}

					WebElement register = driver.findElement(By.cssSelector(".-hide-xs-lte .button--content"));
					;
					if (register.getText().equals("REGISTER")) {
						register.click();
						registerFlag = true;
						// confirm dang ky
						driver.findElement(By.cssSelector(".-type-primary > .button--content")).click();
						;
						currentUrl = driver.getCurrentUrl();
					}
				} catch (Exception e) {
					// see task
					// System.out.println("REGISTER Khong tim thay");
				}

				try {
					WebElement gotask = driver.findElement(By.cssSelector(".-flex > .button > .button--content"));
					;
					if (gotask.getText().equals("LET'S GO!")) {
						gotask.click();
						// confirm dang ky
					}
					if (gotask.getText().equals("DONE")) {
						gotask.click();
						// confirm dang ky
						see = false;
					}

				} catch (Exception e) {
					// see task
					// System.out.println("See tasks Khong tim thay");
				}

				try {
					WebElement closeButton = driver.findElement(By.cssSelector(".growl-notification--close-button"));
					;
					closeButton.click();
					closeButton = driver
							.findElement(By.cssSelector(".growl-next-regular-tournament--footer .button--content"));
					closeButton.click();
					closeButton = driver.findElement(By.className("dismiss-button"));
					closeButton.click();
					

				} catch (Exception e) {
					// see task
					// System.out.println("Khong co Close button");
				}
				try {
					WebElement Pending = driver.findElement(By.cssSelector(".-view-glass > .-layout-h"));
					;
					WebElement registerElement = driver.findElement(By.cssSelector(".-nowrap"));
					;

					if (Pending.getText().contains("Pending") && registerElement.getText().contains("registered")) {
						Pattern p = Pattern.compile("\\d+");

						WebElement countdown = driver.findElement(By.cssSelector(".countdown"));
						;
						if (countdown.getText().contains("seconds") || countdown.getText().contains("a minute")) {
							Thread.currentThread();
							Thread.sleep(60000);
						} else {
							Matcher m = p.matcher(countdown.getText());
							while (m.find()) {
								System.out.println("Waiting Tournaments : " + m.group() + " Minute");
								Integer countdownStr = Integer.parseInt(m.group());
								Thread.currentThread();
								Thread.sleep((countdownStr - 1) * 60000);

							}
						}

					}

				} catch (Exception e) {
					// see task
					// System.out.println("chua co dang ky");
				}
				try {
					WebElement seetask = driver.findElement(By.cssSelector(".-vertical > .button > .button--content"));
					;
					if (seetask.getText().equals("SEE TASKS")) {
						seetask.click();
						// confirm dang ky
						see = false;
					}

				} catch (Exception e) {
					// see task
					// System.out.println("See tasks Khong tim thay");
				}

				try {
					WebElement winner = driver.findElement(By.tagName("h3"));
					;
					if (winner.getText().equals("And the Winner is")) {
						see = false;
						driver.get(baseUrl);
					}

				} catch (Exception e) {
					// see task
					// System.out.println("chua co nguoi winner");
				}

			}

			System.out.println("Tournaments : " + currentUrl);

			String urlC = currentUrl.concat("/C");
			String urlD = currentUrl.concat("/D");
			String urlE = currentUrl.concat("/E");

			WriteAnswer(urlC, driver);
			Thread.currentThread();
			Thread.sleep(15000);
			WriteAnswer(urlD, driver);
			Thread.currentThread();
			Thread.sleep(25000);
			WriteAnswer(urlE, driver);
			Thread.currentThread();
			Thread.sleep(35000);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				try {
					List<WebElement> timer = driver.findElements(By.cssSelector(".task-title--subheader"));
					;
					for (WebElement webElement : timer) {
						String[] timerStr = webElement.getText().split("M");
						Integer timerIns = Integer
								.valueOf(timerStr[0].substring(timerStr[0].length() - 1, timerStr[0].length()));
						System.out.println("*************************************Cho Tour moi sau : " + timerIns
								+ "minute ****************************************** ");
						// Thread.currentThread().sleep((timerIns + 1)*60000);
						sleep = timerIns + 1;
					}

				} catch (Exception e) {
					// see task
					// System.out.println("chua co nguoi winner");
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
			Thread.currentThread();
			Thread.sleep(2000);
			driver.findElement(By.name("username")).sendKeys("toan-nd_fjs");
			;
			driver.findElement(By.name("password")).sendKeys("111111Aa");
			Thread.currentThread();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".-padding-v-2 > .button--content")).click();
			;
			System.out.println("Login OK");
			Thread.currentThread();
			Thread.sleep(2000);

		} catch (Exception ex) {
			System.out.println("Login Error : " + ex.getMessage());
		} finally {

		}
	}

	private static boolean WriteAnswer(String url, WebDriver driver) {
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		String menthodName = "";
		try {
			Thread.currentThread();
			Thread.sleep(10000);
			WebElement code = driver.findElement(By.cssSelector(".CodeMirror textarea"));
			;
			JavascriptExecutor js = (JavascriptExecutor) driver;

			Thread.currentThread();
			Thread.sleep(3000);

			// Kiem tra co dap an hay khong
			WebElement menthodNameElement = driver.findElement(By.cssSelector(".cm-def:nth-child(2)"));
			boolean isOk = false;
			menthodName = menthodNameElement.getText();
			if (menthodName.length() > 0) {
				String[] languageArr = { "Py3", "Py2", "C++", "Java", "JS" };
				File[] foderArr = new File[languageArr.length];
				String[] sourceCodeArr = new String[languageArr.length];
				for (int i = 0; i < languageArr.length; i++) {
					foderArr[i] = new File(PATH_SOURCE + languageArr[i] + "\\" + menthodName + "." + languageArr[i]);
					sourceCodeArr[i] = new String("");
				}
				String[] modeArr = {"", "", "", "", ""};
				isOk = false;
				for (int i = 0; i < languageArr.length; i++) {
					sourceCodeArr[i] = readContent(foderArr[i]);
					if (sourceCodeArr[i].length() > 0) {
						modeArr[i] = languageArr[i];
						System.out.println("OK=======Co Source" + languageArr[i]);
						isOk = true;
					}
				}
				if (!isOk) {
					System.out.println("Ko co source " + menthodName);
					createFileNotFound(PATH_SOURCE + "NF\\", menthodName,".nf");
				}

				String cssSelectorLanguage1 = ".select:nth-child(2) .select--title";
				String[] cssSelectorLanguage2 = { ".-space-v-8:nth-child(4) > .select-menu--item:nth-child(5) > .select-menu--text"
												, ".-space-v-8:nth-child(4) > .select-menu--item:nth-child(4) > .select-menu--text"
												, ".-space-v-8:nth-child(1) > .select-menu--item:nth-child(5) > .select-menu--text"
												, ".-space-v-8:nth-child(3) > .select-menu--item:nth-child(1) > .select-menu--text"
												, ".-space-v-8:nth-child(3) > .select-menu--item:nth-child(2) > .select-menu--text"};
				for (int i = 0; i < languageArr.length; i++) {
					if (!modeArr[i].equalsIgnoreCase("")) {
						// chon ngon ngu
						try {
							WebElement language1 = driver.findElement(By.cssSelector(cssSelectorLanguage1));
							language1.click();
							Thread.currentThread();
							Thread.sleep(3000);
							WebElement language2 = driver.findElement(By.cssSelector(cssSelectorLanguage2[i]));
							language2.click();
							Thread.currentThread();
							Thread.sleep(3000);
						} catch (Exception e) {
							System.out.println("FAIL=======Loi chon ngon ngu");
						}
						// copy paste kq
						String myString = sourceCodeArr[i];
						System.out.println("Dap an = " + myString);
						StringSelection stringSelection = new StringSelection(myString);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, null);
						Thread.currentThread();
						Thread.sleep(3000);
						code.sendKeys(Keys.CONTROL + "a");
						Thread.currentThread();
						Thread.sleep(10000);
						code.sendKeys(Keys.CONTROL + "v");
						Thread.currentThread();
						Thread.sleep(5000);

						// submit va kiem tra
						try {
							WebElement submit = driver.findElement(By.cssSelector(".-type-success > .button--content"));
							submit.click();
							Thread.currentThread();
							Thread.sleep(10000);
							WebElement messageSubmit = driver.findElement(By.cssSelector(".verdict-message"));
							if (messageSubmit.getText().contains("error")) {
								System.out.println("FAIL=======Dap AN : " + menthodName + ". " + modeArr[i] + " SAI");
								createFileNotFound(PATH_SOURCE + "Error\\", menthodName,".errSubmit");
							} else {
								break;
							}
						} catch (Exception e) {
							createFileNotFound(PATH_SOURCE + "Error\\", menthodName,".errSubmit");
						}
					}
				}
			} else {
				createFileNotFound(PATH_SOURCE + "\\Error\\", menthodName, "errMethodName");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
		}
		return true;
	}

	private static String readContent(File file) {
		try {
			System.out.println("read file " + file.getCanonicalPath());
			StringBuffer allLine = new StringBuffer();
			String temp = "";
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String strLine;
				// Read lines from the file, returns null when end of stream
				// is reached
				while ((strLine = br.readLine()) != null) {
					// System.out.println(strLine);
					allLine.append(strLine).append("\n");
				}
			}
			temp = allLine.toString();
			System.out.println("file dap an = " + file.getName());
			return temp;
		} catch (Exception e) {
			return "";
		}
	}

	private static void createFileNotFound(String folder, String fileName, String extention) throws IOException {
		File file = new File(folder + fileName + "." + extention);
		// Create the file
		if (file.createNewFile()) {
			System.out.println("File is created : " + file.getName());
		} else {
			System.out.println("File already exists : " + file.getName());
		}

		// Write Content
		FileWriter writer = new FileWriter(file);
		writer.write("Loi");
		writer.close();
	}
}
