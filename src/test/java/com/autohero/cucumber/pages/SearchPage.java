package com.autohero.cucumber.pages;



import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class SearchPage extends PageObject {




    @FindBy(css = "a[title='Autohero']")
    WebElement logoAutoHero;

    @FindBy(css = "div[data-qa-selector='filter-year']")
    WebElement filterRegistrationDate;

    @FindBy(css = "select[name='yearRange.min']")
    WebElement selectRegistrationDate;

    @FindBy(css = "select[name='sort']")
    WebElement selectSortBy;

    @FindBy(css = "div[data-qa-selector='loading-banner']")
    WebElement loader;

    @FindBy(css = "a[data-qa-selector='ad']")
    List<WebElement> listOfCarResults;

    @FindBy(css = "a[data-qa-selector='ad'] div[data-qa-selector='price']")
    List<WebElement> listOfPriceOfCars;

    @FindBy(css = "a[data-qa-selector='ad'] ul li:nth-child(1)")
    List<WebElement> listOfRegistrationYearOfCars;

    @FindBy(css = "div[data-qa-selector='title']")
    List<WebElement> carName;


    public void verifySearchPageIsLoaded()
    {
        Assert.assertTrue(logoAutoHero.isDisplayed(), "Search page should be shown");
    }

    public void setFilter(String filterName , String filterValue)
    {
        switch (filterName) {
            case "Erstzulassung ab":

                filterRegistrationDate.click();
                selectFromDropdown(selectRegistrationDate , filterValue);
                //waitForLoaderToDisappear();
                break;

                /*
                *   All filter's can be set here
                *
                *
                * */
            default:
                Assert.fail("Please check the filter and correct "+filterName+"");
        }

    }

    public void sortBy(String sortByValue) throws InterruptedException {

        selectFromDropdown(selectSortBy, sortByValue);


    }


    public void getFilterdListOfCars(String filterValue )
    {
        for (int i=0 ; i<listOfCarResults.size() ; i++)
        {
            String registrationYear = StringUtils.substringAfter(listOfRegistrationYearOfCars.get(i).getText(),"/") ;
            Assert.assertTrue(Integer.parseInt(registrationYear) >= Integer.parseInt(filterValue) ,
                    "Registraion year for "+carName.get(i).getText()+" is "+Integer.parseInt(registrationYear)+" which is out of filter range "+Integer.parseInt(filterValue)+"  ");
        }
    }

    public void verifySortingOfpriceDescending()
    {
       ArrayList<Float> prices = new ArrayList<>();
       for (WebElement element : listOfPriceOfCars)
       {
               prices.add(Float.parseFloat(StringUtils.substringBeforeLast(element.getText()," ")));
       }

            for (int i = 1; i < prices.size(); i++) {

                if (prices.get(i-1) < prices.get(i))
                {
                        Assert.fail("Prices are not sorted");
                }
        }

    }

}
