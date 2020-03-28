package com.autohero.cucumber.steps.search;

import com.autohero.cucumber.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchFunctionality extends SearchPage {


    @Given("^user in on homepage\\.$")
    public  void user_in_on_homepage() {
        open();
        verifySearchPageIsLoaded();
        
    }

    @When("^user set filter '(.*)' to '(.*)' for cars\\.$")
    public void user_set_filter_FILTER_NAME_to_FILTER_VALUE_for_cars(String filterName , String filterValue) {

        setFilter(filterName , filterValue);
        
    }

    @When("^sort page by '(.*)'\\.$")
    public void sort_page_by_SORT_BY(String sortByValue) throws InterruptedException {


        sortBy(sortByValue);
        
    }

    @Then("^all cars should be filtered by first registration '(.*)'\\.$")
    public void all_cars_should_be_filtered_by_FILTER_VALUE(String filterValue) {

        getFilterdListOfCars(filterValue);
    }

    @Then("^all cars are sorted by price descending\\.$")
    public void all_cars_are_sorted_by_price_descending() {

        verifySortingOfpriceDescending();
    }
}
