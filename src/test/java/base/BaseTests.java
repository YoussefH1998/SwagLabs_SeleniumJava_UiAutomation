package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.*;

public class BaseTests {
    private WebDriver driver;
    private String url;
    private String browser;
    protected String validPassword;
    protected HomePage homePage;
    @BeforeClass
    public void setUp1() throws IOException {
        String filePath=System.getProperty("user.dir")+"/src/test/resources/global.properties";
        Properties prop;
        prop=new Properties();
        FileInputStream fis=new FileInputStream(filePath);
        prop.load(fis);
        url=prop.getProperty("url");
        browser=prop.getProperty("browser").toLowerCase();
        validPassword=prop.getProperty("password");
        initializeDrive(browser);
        driver.get(url);
        homePage=new HomePage(driver);
        assertEquals(driver.getTitle(),"Swag Labs");
    }
    @AfterClass
    public  void cleanup(){
        driver.quit();
    }
    @AfterMethod
    public void recordFailure(ITestResult result){
        //this method used to take screenshots of test that failed
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File(System.getProperty("user.dir")+"/src/resources/screenshots/"+result.getName()+".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
       private void initializeDrive(String browser){
        switch (browser){
            case "chrome":driver=new ChromeDriver();break;
            case "edge":driver=new EdgeDriver();break;
            case "firefox":driver=new FirefoxDriver();break;
            default:System.out.println("The required webbrowser is not configured will run tests on chrome driver");
                driver= new ChromeDriver();
        }
    }
}
