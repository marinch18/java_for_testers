package manager;

import org.openqa.selenium.By;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void attach(By locator, String file) {
        var path = Paths.get(file).toAbsolutePath();
        System.out.println("PHOTO PATH: " + path);
        System.out.println("PHOTO EXISTS: " + java.nio.file.Files.exists(path));
        manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }
}
