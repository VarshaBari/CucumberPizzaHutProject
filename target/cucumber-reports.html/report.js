$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/PizzaHut_PlaceTheOrder.feature");
formatter.feature({
  "name": "This feature will be used to automate PizzaHut Website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@placeOrder"
    }
  ]
});
formatter.scenario({
  "name": "This scenario will be used to Place the Order",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@placeOrder"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have launched the application",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_have_launched_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the location as \"Pune\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_enter_the_location_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the very first suggestion from the list",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_select_the_very_first_suggestion_from_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should land on the Deals page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_should_land_on_the_Deals_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the tab as \"Pizzas\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_select_the_tab_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add \"Schezwan Margherita\" to the basket",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_add_to_the_basket(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I note down the price displayed on the screen",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_note_down_the_price_displayed_on_the_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the pizza \"Schezwan Margherita\" is added to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_should_see_the_pizza_is_added_to_the_cart(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "price is also displayed correctly",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.price_is_also_displayed_correctly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Checkout button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_click_on_the_Checkout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be landed on the secured checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_should_be_landed_on_the_secured_checkout_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the personal details",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_enter_the_personal_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the address details",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_enter_the_address_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Online Payment",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_click_on_Online_Payment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I unable to click on cash payment",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PlaceTheOrderStepDef.i_unable_to_click_on_cash_payment()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});