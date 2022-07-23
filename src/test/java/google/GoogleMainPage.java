package google;

import general.Setup;
import general.pom.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleMainPage extends PageObject {

    private String inputSearchXPATHLocator = "//input[@title='Search']";
    private String buttonSerachNameLocator = "//input[@name='btnK']";
    private String gmailButtonXPATH = "//a[text()='Gmail' ]";

    public GoogleMainPage() {
        super();
    }


    public WebElement getInputSearch() {
        return this.getElement(By.xpath(inputSearchXPATHLocator));
    }

    public WebElement getButtonSerach() {

        List<WebElement> listEl = this.getElements(By.xpath(buttonSerachNameLocator)).stream().filter(webElement -> webElement.isDisplayed()).collect(Collectors.toList());
        return listEl.get(0);
    }


    public void validateElements() {
        Setup.getWait().visibilityOfElement(By.xpath(inputSearchXPATHLocator), "Search input is not visible");
        List<WebElement> listEl = this.getElements(By.xpath(buttonSerachNameLocator)).stream().filter(webElement -> webElement.isDisplayed()).collect(Collectors.toList());

        Assert.assertTrue("Search button is not visible", listEl.size() > 0);
        Setup.getWait().visibilityOfElement(By.xpath(gmailButtonXPATH), "Gmail button is not visible");
    }
}
