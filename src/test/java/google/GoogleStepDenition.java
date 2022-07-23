package google;

import io.cucumber.java.en.*;

public class GoogleStepDenition {

    private GooSteps gooSteps;

    public GoogleStepDenition() {
        gooSteps = new GooSteps();
    }

    @Given("User is on Google web side")
    public void user_is_on_google_web_side() {
        gooSteps.validateGooglePage();

    }

    @When("User introduces the required criteria {string}")
    public void user_introduces_the_required_criteria(String string) {
        gooSteps.introduceSearchCriteria(string);
    }

    @When("user clicks on Google Search button")
    public void user_clicks_on_google_search_button() {
        gooSteps.clicksOnSearchButton();
    }

    @Then("The system redirects to search page")
    public void the_system_redirects_to_search_page() {
        gooSteps.validateGoogleSearch();
    }

    @When("user performs ENTER click")
    public void user_performs_enter_click() {
        gooSteps.performsEneter();

    }

    @Then("the result match with the criteria introduced")
    public void the_result_match_with_the_criteria_introduced() {
        gooSteps.validateSearchCriteria();

    }

    @Given("user select one of the link result")
    public void user_select_one_of_the_link_result() {
        gooSteps.clickOnLinkResult();
    }

    @Then("browser will redirect to new url")
    public void browser_will_redirect_to_new_url() {
        gooSteps.validateNewPage();
    }

}
