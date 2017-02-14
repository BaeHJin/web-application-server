package webserver;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.HttpRequestUtils;

public class RequestLine {
	private static final Logger log = LoggerFactory.getLogger(RequestLine.class);
	
	private String url;
	private String path;
	private String type;
	private String queryString;
	private Map<String, String> params;
	
	public RequestLine(String url) {
		this.url = splitUrl(url);
	}

	public String urlCheck(){
		log.debug("url : {}", url);
		if(this.url.contains("?")){
			int index = url.indexOf("?");
	    	this.path = url.substring(0, index);
	    	this.queryString = url.substring(index+1);
	    	this.setParams(HttpRequestUtils.parseQueryString(queryString));
		}
		return this.path;
	}
	
	public String getParameter(String param){
		log.debug("params : {}", this.params.toString());
		return this.params.get(param);
	}
	
    private String splitUrl(String line){
    	String[] tokens = line.split(" ");
    	this.type =tokens[0];
    	if(tokens[1]=="/"){
    		tokens[1] = "/index.html";
    	}
    	if(tokens[1].contains("?")){
    		
    	}
    	return tokens[1];
    }
	
    
    
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public String getQueryString() {
		return queryString;
	}
	
	public String getType() {
		return type;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
