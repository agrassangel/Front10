package general.pom;

//import org.junit.Assert;

public abstract class PageSteps {


    protected void checkURL(String url, PageObject page) {
        String browserURL = (url != null) ? url : page.getPagePath();
//        Assert.assertTrue(page.getCurrentUrl().contains(browserURL.toLowerCase()));

    }


    public abstract void clicksOnIcon(String icon);
}
