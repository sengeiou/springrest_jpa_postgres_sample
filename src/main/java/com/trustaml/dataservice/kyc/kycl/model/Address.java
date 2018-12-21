package com.trustaml.dataservice.kyc.kycl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "kycl_address_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@SequenceGenerator(name = "kycl_address_id_seq", sequenceName = "kycl_address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_address_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "kycl_id")
	@JsonIgnore
	private Kycl kycl;

	@JsonProperty("address_type")
	@Column(name = "address_type")
	private String addressType;

	@JsonProperty("country")
	private String country;

	@JsonProperty("zone")
	private String zone;

	@JsonProperty("district")
	private String district;

	@JsonProperty("mn_vdc")
	@Column(name = "mn_vdc")
	private String mnVdc;

	@JsonProperty("pinzip")
	private String pinzip;

	@JsonProperty("ward_number")
	@Column(name = "ward_number")
	private String wardNumber;

	@JsonProperty("tole_area")
	@Column(name = "tole_area")
	private String toleArea;

	@JsonProperty("street")
	private String street;

	@JsonProperty("house_no")
	@Column(name = "house_no")
	private String houseNo;

	@JsonProperty("unit_number")
	@Column(name = "unit_number")
	private String unitNumber;

	@JsonProperty("nearest_landmark")
	@Column(name = "nearest_landmark")
	private String nearestLandmark;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;

	@JsonProperty("phone_no_country_code")
	@Column(name = "phone_no_country_code")
	private String phoneNoCountryCode;

	@JsonProperty("phone_no_area_code")
	@Column(name = "phone_no_area_code")
	private String phoneNoAreaCode;

	@JsonProperty("phone_no")
	@Column(name = "phone_no")
	private String phoneNo;

	@JsonProperty("telex_no_country_code")
	@Column(name = "telex_no_country_code")
	private String telexNoCountryCode;

	@JsonProperty("telex_no_area_code")
	@Column(name = "telex_no_area_code")
	private String telexNoAreaCode;

	@JsonProperty("telex_no")
	@Column(name = "telex_no")
	private String telexNo;

	@JsonProperty("pager_no_country_code")
	@Column(name = "pager_no_country_code")
	private String pagerNoCountryCode;

	@JsonProperty("pager_no_area_code")
	@Column(name = "pager_no_area_code")
	private String pagerNoAreaCode;

	@JsonProperty("pager_no")
	@Column(name = "pager_no")
	private String pagerNo;

	@JsonProperty("email_id")
	@Column(name = "email_id")
	private String emailId;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("state")
	private String state;

	@JsonProperty("change")
	private boolean change;

	@JsonProperty("province")
	private String province;

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressType=" + addressType + ", country=" + country + ", zone=" + zone
				+ ", district=" + district + ", mnVdc=" + mnVdc + ", pinzip=" + pinzip + ", wardNumber=" + wardNumber
				+ ", toleArea=" + toleArea + ", street=" + street + ", houseNo=" + houseNo + ", unitNumber="
				+ unitNumber + ", nearestLandmark=" + nearestLandmark + ", latitude=" + latitude + ", longitude="
				+ longitude + ", phoneNoCountryCode=" + phoneNoCountryCode + ", phoneNoAreaCode=" + phoneNoAreaCode
				+ ", phoneNo=" + phoneNo + ", telexNoCountryCode=" + telexNoCountryCode + ", telexNoAreaCode="
				+ telexNoAreaCode + ", telexNo=" + telexNo + ", pagerNoCountryCode=" + pagerNoCountryCode
				+ ", pagerNoAreaCode=" + pagerNoAreaCode + ", pagerNo=" + pagerNo + ", emailId=" + emailId + ", notes="
				+ notes + ", state=" + state + ", change=" + change + ", province=" + province + "]";
	}

	
}
