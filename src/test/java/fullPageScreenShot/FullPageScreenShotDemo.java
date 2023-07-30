package fullPageScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FullPageScreenShotDemo {

    @Test
    public void TakeFullPageScreenShot() throws InterruptedException, IOException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);


        //Full page screenshot demo
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File(".//ScreenShot//FullPageScreenshot.png"));
        driver.quit();
    }
}
