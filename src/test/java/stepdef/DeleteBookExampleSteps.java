package stepdef;

import org.junit.Assert;

import services.helper.AddBookExampleHelper;
import services.helper.DeleteBookExampleHelper;
import com.fasterxml.jackson.databind.JsonNode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class DeleteBookExampleSteps {
	DeleteBookExampleHelper deleteBookExampleHelper = new DeleteBookExampleHelper();
	AddBookExampleHelper addBookExampleHelper = new AddBookExampleHelper();


	public DeleteBookExampleSteps() {

	}

	@Given("^that the user want to delete book$")
	public void that_the_user_add_the_following_data_to_add_new_book() throws Throwable {

		JsonNode instanceProcessResponse = addBookExampleHelper.getJsonNodeResponse();
		deleteBookExampleHelper.setDeleteBookExampleDTO(instanceProcessResponse.findValue("ID").asText());

	}

	@When("^the user perform the delete book option$")
	public void the_user_perform_the_add_book_option() throws Throwable {
		deleteBookExampleHelper.deleteBookExample();
	}

	@Then("^the delete book action result will be \"([^\"]*)\" and the message will be \"([^\"]*)\"$")
	public void the_add_book_action_result_will_be(String result, String message) throws Throwable {

		int expectedResult;
		if (result.equals("Success")) {
			expectedResult = 200;
		} else {
			expectedResult = 500;
		}
		Response response = deleteBookExampleHelper.getResponse();
		JsonNode instanceProcessResponse = deleteBookExampleHelper.getJsonNodeResponse();

		// validate response code 200, 400, etc.
		Assert.assertEquals(expectedResult, response.getStatusCode());
		Assert.assertEquals(instanceProcessResponse.findValue("msg").asText(), message);
	}

}
