package dto;

import java.io.File;
import java.util.Map;

public class RequestData {
	private String baseUri;
	private String basePath;
	private String token;
	private File multiparteFile;
	private int port;
	private boolean securityEnabled;
	private boolean formurlencoded;
	private Map<String, ?> pathParams;
	private Map<String, ?> queryParamas;
	private Map<String, ?> headers;
	private Map<String, ?> formParams;

	public RequestData() {
	}

	public File getMultiparteFile() {
		return multiparteFile;
	}

	public RequestData setMultiparteFile(File multiparteFile) {
		this.multiparteFile = multiparteFile;
		return this;
	}

	public int getPort() {
		return port;
	}

	public RequestData setPort(int port) {
		this.port = port;
		return this;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public RequestData setBaseUri(String baseUri) {
		this.baseUri = baseUri;
		return this;
	}

	public Map<String, ?> getHeaders() {
		return headers;
	}

	public RequestData setHeaders(Map<String, ?> headers) {
		this.headers = headers;
		return this;
	}

	public Map<String, ?> getFormParams() {
		return formParams;
	}

	public RequestData setFormParams(Map<String, ?> formParams) {
		this.formParams = formParams;
		return this;
	}

	public boolean isSecurityEnabled() {
		return securityEnabled;
	}

	public RequestData setSecurityEnable(boolean needBearerToken) {
		this.securityEnabled = needBearerToken;
		return this;
	}

	public boolean isFormurlencoded() {
		return formurlencoded;
	}

	public RequestData setFormurlencoded(boolean formurlencoded) {
		this.formurlencoded = formurlencoded;
		return this;
	}

	public String getBasePath() {
		return basePath;
	}

	public RequestData setBasePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public String getToken() {
		return token;
	}

	public RequestData setToken(String token) {
		this.token = token;
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
