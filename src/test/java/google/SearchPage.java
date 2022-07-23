package google;

import general.Setup;
import general.pom.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends PageObject {


    private String moreXPATH = "//div[text()='More' ]";
    private String bookXPATH = "//a[text()='Books' ]";
    private String videoXPATH = "//a[text()='Videos' ]";
    private String imagesXPATH = "//a[text()='Images' ]";

    public SearchPage() {
        super();
    }

    public void validateElements() {

        Setup.getWait().visibilityOfElement(By.xpath(moreXPATH), "More button is not visible");
//        Setup.getWait().visibilityOfElement(By.xpath(bookXPATH), "Books button is not visible");
        Setup.getWait().visibilityOfElement(By.xpath(videoXPATH), "Videos button is not visible");
        Setup.getWait().visibilityOfElement(By.xpath(imagesXPATH), "Images button is not visible");
    }

    public List<WebElement> getAllTitle() {
        return this.getElements(By.xpath("//h3"));
    }

    public List<WebElement> getAllTitle(String criteria) {
        return this.getAllTitle().stream().filter(webElement -> webElement.getText().
                toLowerCase().contains(criteria.toLowerCase())).collect(Collectors.toList());
    }


}
