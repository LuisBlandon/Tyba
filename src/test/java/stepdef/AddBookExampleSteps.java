package stepdef;

import java.util.List;

import org.junit.Assert;

import dto.AddBookExampleDTO;
import services.helper.AddBookExampleHelper;
import com.fasterxml.jackson.databind.JsonNode;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class AddBookExampleSteps {
	AddBookExampleHelper addBookExampleHelper = new AddBookExampleHelper();

	public AddBookExampleSteps() {

	}

	@Given("^that the user add the following data to add new book$")
	public void that_the_user_add_the_following_data_to_add_new_book(DataTable addBookExampleDTO) throws Throwable {

		List<AddBookExampleDTO> lstAddBookExampleDTO = addBookExampleDTO.asList(AddBookExampleDTO.class);
		int lstSize = lstAddBookExampleDTO.size();
		for (int i = 0; i < lstSize; i++) {
			addBookExampleHelper.setAddBookExampleDTO(lstAddBookExampleDTO.get(i));

		}

	}

	@When("^the user perform the add book option$")
	public void the_user_perform_the_add_book_option() throws Throwable {
		addBookExampleHelper.addBookExample();
	}

	@Then("^the add book action result will be \"([^\"]*)\" and the message will be \"([^\"]*)\"$")
	public void the_add_book_action_result_will_be(String result, String message) throws Throwable {

		int expectedResult;
		if (result.equals("Success")) {
			expectedResult = 200;
		} else {
			expectedResult = 500;
		}
		Response response = addBookExampleHelper.getResponse();
		JsonNode instanceProcessResponse = addBookExampleHelper.getJsonNodeResponse();

		// validate response code 200, 400, etc.
		Assert.assertEquals(expectedResult, response.getStatusCode());
		Assert.assertEquals(instanceProcessResponse.findValue("Msg").asText(), message);
	}

}
