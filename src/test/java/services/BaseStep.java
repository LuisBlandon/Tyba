package services;

import static io.restassured.http.ContentType.JSON;
import static util.TestContext.CONTEXT;

import org.junit.Assert;

import com.fasterxml.jackson.databind.JsonNode;

import dto.RequestData;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.ConfigureProperties;
import setup.Constants;

public abstract class BaseStep {

	protected RequestSpecification getSpec() {
		RequestSpecification spec = CONTEXT.getRequest();
		if (spec == null) {
			RestAssured.defaultParser = Parser.JSON;
			spec = RestAssured.given().and().contentType(JSON).log().all();
			CONTEXT.setRequest(spec);
		}
		return spec;
	}

	protected void log(Response response) {
		response.then().log().all();
	}

	public void iSendPOSTRequest(RequestData request) {
		prepareRequest(request);
		Object object = CONTEXT.getWorkingEntity();
		if (object != null) {
			getSpec().body(object);
		}
		Response response = getSpec().post();
		CONTEXT.setResponse(response);
		log(response);
	}

	protected void iSendDELETERequest(RequestData request) {
		prepareRequest(request);
		Response response = getSpec().delete();
		CONTEXT.setResponse(response);
		log(response);
	}

	protected void iSendPUTRequest(RequestData request) {
		prepareRequest(request);
		Object object = CONTEXT.getWorkingEntity();
		if (object != null) {
			getSpec().body(object);
		}
		Response response = getSpec().put();
		CONTEXT.setResponse(response);
		log(response);
	}

	protected void iSendGETRequest(RequestData request) {
		prepareRequest(request);
		Response response = getSpec().get();
		CONTEXT.setResponse(response);
		log(response);
	}

	private void prepareRequest(RequestData request) {
		getSpec().given().baseUri(request.getBaseUri());

		getSpec().given().basePath(request.getBasePath());

		if (request.getPathParams() != null) {
			getSpec().pathParams(request.getPathParams());
		}

		if (request.getQueryParamas() != null) {
			getSpec().queryParams(request.getQueryParamas());
		}

	}

	/*
	 * System.getProperty(Constants.ENV_KEY) set value into Debug/Run
	 * configuration. go to Arguments/VM Arguments set variable
	 * -DENV_KEY={yourenviroment} example: -DENV_KEY=ExampleEnv To Run with
	 * maven use mvn -DargLine=, example: mvn clean test
	 * -DargLine="-DENV_KEY=ExampleEnv"
	 */
	public String getBaseUri() {
		switch (System.getProperty(Constants.ENV_KEY)) {
		case Constants.DOCKER_ENV:
			return ConfigureProperties.getMavenProperty("DockerBaseUri");
		case Constants.TEST_ENV:
			return ConfigureProperties.getMavenProperty("TestBaseUri");
		case Constants.DEV_ENV:
			return ConfigureProperties.getMavenProperty("DevBaseUri");
		default:
			Assert.fail("BaseStep - Environment should be set to Docker,Test or Dev");
			return null;
		}
	}

	public Response getResponse() {
		return CONTEXT.getResponse();
	}

	public JsonNode getJsonNodeResponse() {
		return CONTEXT.getResponse().as(JsonNode.class);
	}
}
