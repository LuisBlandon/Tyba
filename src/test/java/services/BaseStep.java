package services;



import static util.TestContext.CONTEXT;
import static io.restassured.http.ContentType.JSON;

import java.io.File;

import org.junit.Assert;

import dto.RequestData;
import com.adsk.dw.setup.ConfigureProperties;
import com.fasterxml.jackson.databind.JsonNode;

import bsh.org.objectweb.asm.Constants;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseStep {
	private static final String MULTIPART_FORM_DATA = "multipart/form-data";
	private static final String XML_FORM_DATA = "application/xml";
	private static final String PROCESS_FILE = "processFile";
	private static final String FORM_URLENCODED = "application/x-www-form-urlencoded";

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

		if (request.getMultiparteFile() != null) {
			File multipartFile = request.getMultiparteFile();
			getSpec().contentType(MULTIPART_FORM_DATA).multiPart(PROCESS_FILE, multipartFile, XML_FORM_DATA);
		}

		if (request.getPort() > 0) {
			getSpec().given().port(request.getPort());
		}

		if (request.getFormParams() != null) {
			getSpec().formParams(request.getFormParams());
		}
		if (request.getPathParams() != null) {
			getSpec().pathParams(request.getPathParams());
		}
		if (request.getToken() != null) {
			getSpec().auth().oauth2(request.getToken());
		}
		if (request.isFormurlencoded() == true) {
			getSpec().contentType(FORM_URLENCODED);
		}
		if (request.getQueryParamas() != null) {
			getSpec().queryParams(request.getQueryParamas());
		}
		if (request.getHeaders() != null) {
			getSpec().headers(request.getHeaders());
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
		case Constants.EXAMPLE_ENV:
			return ConfigureProperties.getMavenProperty("ExampleBaseUri");
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
