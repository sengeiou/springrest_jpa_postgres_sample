package com.trustaml.dataservice.kyc.kycn.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionReturn {	
    @JsonProperty ("status")	
    private int status;            // Status return code of individual functions. As per the error code set.
	@JsonProperty ("description")
	private String description;    // Description of the status for view.
	@JsonProperty ("id")
	private long id;               // id of the generated key by database
	@JsonProperty ("result")
	boolean result;                // result true or false (in case certain caller require true/false)
	@JsonProperty("result_json_string")
	String resultJsonString;
	@JsonProperty ("redirectUrl")
	private String redirectUrl;	

	
	public FunctionReturn(int status, String description, long id, boolean result, String redirectUrl) {
        super();
        this.status = status;
        this.description = description;
        this.id = id;
        this.result = result;
        this.redirectUrl = redirectUrl;
        
    }
	
	
	
	public FunctionReturn(int status, String description, long id, boolean result) {
		super();
		this.status = status;
		this.description = description;
		this.id = id;
		this.result = result;
	}



	public FunctionReturn(int status, String description, long id, boolean result, String resultJsonString, String redirectUrl) {
        super();
        this.status = status;
        this.description = description;
        this.id = id;
        this.result = result;
        this.resultJsonString = resultJsonString;
        this.redirectUrl = redirectUrl;
        
    }

	public FunctionReturn() {
		super();
		this.status = 0;
		this.description = "";
		this.id = 0;
		this.result = false;
		this.resultJsonString = "";
	    this.redirectUrl = "";
	    
	}
	

	public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

	public String getResultJsonString() {
        return resultJsonString;
    }

    public void setResultJsonString(String resultJsonString) {
        this.resultJsonString = resultJsonString;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}