package com.trustaml.dataservice.exception.response;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trustaml.dataservice.adversemedia.model.AdverseMedia;
import com.trustaml.dataservice.bfi.bank.model.Bfi;
import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;
import com.trustaml.dataservice.hotlist.model.HotList;
import com.trustaml.dataservice.investigation.model.Investigation;
import com.trustaml.dataservice.kyc.kycl.model.KycLegal;
import com.trustaml.dataservice.kyc.kycl.model.Kycl;
import com.trustaml.dataservice.kyc.kycn.model.KycnBase;
import com.trustaml.dataservice.pepentry.model.Pepentry;
import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;
import com.trustaml.dataservice.str.model.StrBase;
import com.trustaml.dataservice.ttr.model.TtrBase;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class TrustAmlApiResponse {

	private HttpStatus status;
	private String message;
	private List<String> errors;

	private AdverseMedia adverseMedia;
	private List<AdverseMedia> adverseMediaList;

	private Bfi bfi;
	private List<Bfi> bfiList;

	private DetailBranchInfo detailBranchInfo;
	private List<DetailBranchInfo> detailBranchInfoList;

	private HotList hotList;
	private List<HotList> hotListList;

	private Investigation investigation;
	private List<Investigation> investigationList;

	private KycnBase kycn;
	private List<KycnBase> kycnList;

	private Kycl kycl;
	private List<Kycl> kyclList;
	private List<KycLegal> kycLegalList;

	private Pepentry pepentry;
	private List<Pepentry> pepentryList;

	private ScreeningLRequest screeningLRequest;
	private List<ScreeningLRequest> screeningLRequestList;

	private ScreeningNRequest screeningNRequest;
	private List<ScreeningNRequest> screeningNRequestList;

	private StrBase str;
	private List<StrBase> strList;

	private TtrBase ttr;
	private List<TtrBase> ttrList;

	public TrustAmlApiResponse() {
		super();
	}

	public TrustAmlApiResponse(final HttpStatus status) {
		super();
		this.status = status;
		this.message = "success";
	}

	public TrustAmlApiResponse(final HttpStatus status, final String message) {
		super();
		this.status = status;
		this.message = message;

	}

	public TrustAmlApiResponse(final HttpStatus status, final String message, final List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public TrustAmlApiResponse(final HttpStatus status, final String message, final String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

}
