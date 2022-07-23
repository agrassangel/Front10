package google;

import general.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GooSteps {
    private GoogleMainPage googleMainPage;
    private SearchPage searchPage;

    public GooSteps() {
        googleMainPage = new GoogleMainPage();
        searchPage = new SearchPage();
    }


    public void validateGooglePage() {
        Assert.assertTrue("Google is not the default page ", googleMainPage.getDriver().getCurrentUrl().contains("https://www.google.com/"));
        googleMainPage.validateElements();

    }

    public void introduceSearchCriteria(String string) {
        Setup.setKeyValueStore("searchCriteria", string);
        WebElement search = googleMainPage.getInputSearch();
        search.sendKeys(string);
        Setup.getActions().moveToElement(search).sendKeys(Keys.ESCAPE);
    }

    public void clicksOnSearchButton() {
        googleMainPage.getButtonSerach().click();
//        Setup.getActions().moveToElement(googleMainPage.getButtonSerach()).click().build();
    }

    public void validateGoogleSearch() {
        String criteria = Setup.getValueStore("searchCriteria").toString();
        String currentURL = googleMainPage.getDriver().getCurrentUrl();
        Assert.assertTrue("The criteria:  " + criteria + " is not contained in the URL", currentURL.contains(criteria));
        Assert.assertTrue("This is not a page for google search", currentURL.contains("https://www.google.com/"));
        searchPage.validateElements();
    }

    public void performsEneter() {
        googleMainPage.getButtonSerach().sendKeys(Keys.ENTER);
    }

    public void validateSearchCriteria() {
        String criteria = Setup.getValueStore("searchCriteria").toString();
        String[] listCriteria = criteria.split(" ");
        Boolean conditionCriteria = false;
        for (String ser : listCriteria) {
            List<WebElement> listH3 = searchPage.getAllTitle(ser);
            if (listH3.size() > 0)
                conditionCriteria = true;
            break;

        }
        Assert.assertTrue("There arent matches for the search criteria: " + criteria, conditionCriteria);


    }

    public void clickOnLinkResult() {
        List<WebElement> listEl = searchPage.getAllTitle();
        WebElement h3Element = listEl.get(new Random().nextInt(listEl.size() - 1));
        WebElement aElement = h3Element.findElement(By.xpath("ancestor::a"));
        String url = aElement.getAttribute("href");
        Setup.setKeyValueStore("newURL", url);
        h3Element.findElement(By.xpath("ancestor::a")).click();
    }

    public void validateNewPage() {
        String newURL = Setup.getValueStore("newURL").toString();
        String dns = newURL.split("//")[1].toString().split("/")[0];

        Setup.getWait().executeExpectedCondition(ExpectedConditions.urlContains(dns),
                "Url dont not match with the result URL", 20);
    }
}
