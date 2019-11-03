package dto;

import java.util.Map;

public class RequestData {
	private String baseUri;
	private String basePath;
	private Map<String, ?> pathParams;
	private Map<String, ?> queryParamas;

	public RequestData() {
	}

	

	public String getBaseUri() {
		return baseUri;
	}

	public RequestData setBaseUri(String baseUri) {
		this.baseUri = baseUri;
		return this;
	}

	public String getBasePath() {
		return basePath;
	}

	public RequestData setBasePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public Map<String, ?> getPathParams() {
		return pathParams;
	}

	public RequestData setPathParams(Map<String, ?> pathParams) {
		this.pathParams = pathParams;
		return this;
	}

	public Map<String, ?> getQueryParamas() {
		return queryParamas;
	}

	public RequestData setQueryParamas(Map<String, ?> queryParamas) {
		this.queryParamas = queryParamas;
		return this;
	}

	public static RequestData newRequestData() {
		return new RequestData();
	}
}
