package com.trustaml.dataservice.kyc.kycl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LandlordAddress {

	@JsonProperty("land_lord_first_name")
	private String landLordFirstName;

	@JsonProperty("land_lord_middle_name")
	private String landLordMiddleName;

	@JsonProperty("land_lord_last_name")
	private String landLordLastName;

	@JsonProperty("country")
	private String country;

	@JsonProperty("province")
	private String province;

	@JsonProperty("district")
	private String district;

	@JsonProperty("mn_vdc")
	private String mnVdc;

	@JsonProperty("ward_no")
	private String wardNo;

	@JsonProperty("town_city")
	private String townCity;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("phone_no_country_code")
	private String phoneNoCountryCode;

	@JsonProperty("phone_no_area_code")
	private String phoneNoAreaCode;

	@JsonProperty("phone_no")
	private String phoneNo;

	@JsonProperty("telex_no_country_code")
	private String telexNoCountryCode;

	@JsonProperty("telex_no_area_code")
	private String telexNoAreaCode;

	@JsonProperty("telex_no")
	private String telexNo;

	@JsonProperty("pager_no_country_code")
	private String pagerNoCountryCode;

	@JsonProperty("pager_no_area_code")
	private String pagerNoAreaCode;

	@JsonProperty("pager_no")
	private String pagerNo;

	@JsonProperty("email_id")
	private String emailId;


	

}
