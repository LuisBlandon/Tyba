package util;

import static java.lang.ThreadLocal.withInitial;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public enum TestContext {

	CONTEXT;

	private static final String WORKING_ENTITY = "WORKING_ENTITY";
	private static final String REQUEST_SPECIFICATION = "REQUEST_SPECIFICATION";
	private static final String RESPONSE = "RESPONSE";
	private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

	public RequestSpecification getRequest() {
		return get(REQUEST_SPECIFICATION);
	}

	public void setRequest(RequestSpecification request) {
		set(REQUEST_SPECIFICATION, request);
	}

	public Response getResponse() {
		return get(RESPONSE);
	}

	public Response setResponse(Response response) {
		return set(RESPONSE, response);
	}

	public <T> T getWorkingEntity() {
		return get(WORKING_ENTITY);
	}

	public <T> void setWorkingEntity(T object) {
		set(WORKING_ENTITY, object);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) testContexts.get().get(name);
	}

	public <T> T set(String name, T object) {
		testContexts.get().put(name, object);
		return object;
	}

	public void reset() {
		setResponse(null);
		setWorkingEntity(null);
		setRequest(null);
	}
}
