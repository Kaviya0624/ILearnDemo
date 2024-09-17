package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver; //for capture screenshot make it static other wise remove static
	//public  WebDriver driver; 
	public Logger logger;  //Log4j
	public Properties p;
		
		@BeforeClass(groups= {"Sanity","Regression","Master"})
		@Parameters({"os","browser"})
		public void setup(String os, String br) throws IOException
		{
			//Loading config.properties file
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
					
			logger=LogManager.getLogger(this.getClass());  //lOG4J2
					
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
			
				//os
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WINDOWS);
				}
				else if(os.equalsIgnoreCase("linux"))
				{
					capabilities.setPlatform(Platform.LINUX);
					
				}
				else if (os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os");
					return;
				}
				
				//browser
				switch(br.toLowerCase())
				{
				case "chrome": 
//					 WebDriverManager.chromedriver().setup();
//					 
//					  ChromeOptions chromeOptions = new ChromeOptions();
//					  chromeOptions.addArguments("--disable-dev-shm-usage");
//					  chromeOptions.addArguments("--no-sandbox");
//					  chromeOptions.addArguments("--disable-gpu");
//						capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
					capabilities.setBrowserName("chrome"); 
					break;
					
					
				case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
				case "firefox": capabilities.setBrowserName("firefox"); break;
				default: System.out.println("No matching browser"); return;
				}
				
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			}
			
					
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{

				switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default : System.out.println("Invalid browser name.."); return;
				}
			}
			
				
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(p.getProperty("appURL")); // reading url from properties file.
			driver.manage().window().maximize();
		}
		
		@AfterClass(groups= {"Sanity","Regression","Master"})
		public void tearDown()
		{
			driver.quit();
		}
		
	
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}
		

}
