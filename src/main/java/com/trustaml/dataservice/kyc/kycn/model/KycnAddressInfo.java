package com.trustaml.dataservice.kyc.kycn.model;

import java.sql.Date;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//class for table kycn_address_info
@Entity
@Audited
@Table(name="kycn_address_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnAddressInfo {

	@Id
	@SequenceGenerator(name="kycn_address_id_seq", sequenceName = "kycn_address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "kycn_address_id_seq")
	private Long id;
	

	@ManyToOne
	@JoinColumn(name="kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;
	

	@JsonProperty("country")
	@Column(name="country")
	private String country;

	@JsonProperty("state")
	@Column(name="state")
	private String state;

	@JsonProperty("zone")
	@Column(name="zone")
	private String zone;

	@JsonProperty("district")
	@Column(name="district")
	private String district;

	@JsonProperty("province") // added looking into jsp
	@Column(name="province")
	private String province;

	@JsonProperty("mn_vdc")
	@Column(name="mn_vdc")
	private String mnVdc;

	@JsonProperty("pinzip")
	@Column(name="pinzip")
	private String pinZip;

	@JsonProperty("ward_number")
	@Column(name="ward_number")
	private String wardNumber;

	@JsonProperty("tole_area")
	@Column(name="tole_area")
	private String toleArea;

	@JsonProperty("street")
	@Column(name="street")
	private String street;

	@JsonProperty("latitude")
	@Column(name="latitude")
	private String latitude;

	@JsonProperty("longitude")
	@Column(name="longitude")
	private String longitude;

	@JsonProperty("nearest_landmark")
	@Column(name="nearest_landmark")
	private String nearestLandMark;

	@JsonProperty("house_no")
	@Column(name="house_no")
	private String houseNo;

	@JsonProperty("unit_number")
	@Column(name="unit_number")
	private String unitNumber;

	@JsonProperty("phone_no_country_code")
	@Column(name="phone_no_country_code")
	private String phoneNoCountryCode;

	@JsonProperty("phone_no_area_code")
	@Column(name="phone_no_area_code")
	private String phoneNoAreaCode;

	@JsonProperty("phone_no")
	@Column(name="phone_no")
	private String phoneNo;

	@JsonProperty("telex_no_country_code")
	@Column(name="telex_no_country_code")
	private String telexNoCountryCode;

	@JsonProperty("telex_no_area_code")
	@Column(name="telex_no_area_code")
	private String telexNoAreaCode;

	@JsonProperty("telex_no")
	@Column(name="telex_no")
	private String telexNo;

	@JsonProperty("pager_no_country_code")
	@Column(name="pager_no_country_code")
	private String pagerNoCountryCode;

	@JsonProperty("pager_no_area_code")
	@Column(name="pager_no_area_code")
	private String pagerNoAreaCode;

	@JsonProperty("pager_no")
	@Column(name="pager_no")
	private String pagerNo;

	@JsonProperty("email_id")
	@Column(name="email_id")
	private String emailId;

	@JsonProperty("notes")
	@Column(name="notes")
	private String notes;

	@JsonProperty("type")
	@Column(name="type")
	private String type;

	@JsonProperty("town") // Edited as per jsp
	@Column(name="town")
	private String townCity;

	@JsonProperty("primary_contact")
	@Column(name="primary_contact")
	private String primaryContactNumber;

	@JsonProperty("fax_number")
	@Column(name="fax_number")
	private String faxNumber;

	@JsonProperty("secondary_contact_number")
	@Column(name="secondary_contact_number")
	private String secondaryContactNumber;

	@JsonProperty("email_address")
	@Column(name="email_address")
	private String emailAddress;

	@JsonProperty("post_box_number")
	@Column(name="post_box_number")
	private String postBoxNumber;

	@JsonProperty("is_rent")
	@Column(name="is_rent")
	private String isRent;

	@JsonProperty("landlord_name")
	@Column(name="landlord_name")
	private String landlordName;

	@JsonProperty("utility_bill_number")
	@Column(name="utility_bill_number")
	private String utilityBillnuber;

	@JsonProperty("utility_bill_type")
	@Column(name="utility_bill_type")
	private String utilityBillType;

	@JsonProperty("address_type")
	@Column(name="address_type")
	private String addressType;

	@JsonProperty("change")
	@Column(name="change")
	private boolean change;

	@Column(name="maker")
	private String maker;
	
	@Column(name="checker")	
	private String checker;
	
	@Column(name="approved")
	private boolean approved;
	
	@Column(name="updateDate")
	private Date updateDate;
	
	@Column(name="approvedDate")
	private Date approvedDate;
	
	@Column(name="reason")
	private String reason;

	@Override
	public String toString() {
		return "KycnAddressInfo [id=" + id + ", country=" + country + ", state=" + state + ", zone=" + zone
				+ ", district=" + district + ", province=" + province + ", mnVdc=" + mnVdc + ", pinZip=" + pinZip
				+ ", wardNumber=" + wardNumber + ", toleArea=" + toleArea + ", street=" + street + ", latitude="
				+ latitude + ", longitude=" + longitude + ", nearestLandMark=" + nearestLandMark + ", houseNo="
				+ houseNo + ", unitNumber=" + unitNumber + ", phoneNoCountryCode=" + phoneNoCountryCode
				+ ", phoneNoAreaCode=" + phoneNoAreaCode + ", phoneNo=" + phoneNo + ", telexNoCountryCode="
				+ telexNoCountryCode + ", telexNoAreaCode=" + telexNoAreaCode + ", telexNo=" + telexNo
				+ ", pagerNoCountryCode=" + pagerNoCountryCode + ", pagerNoAreaCode=" + pagerNoAreaCode + ", pagerNo="
				+ pagerNo + ", emailId=" + emailId + ", notes=" + notes + ", type=" + type + ", townCity=" + townCity
				+ ", primaryContactNumber=" + primaryContactNumber + ", faxNumber=" + faxNumber
				+ ", secondaryContactNumber=" + secondaryContactNumber + ", emailAddress=" + emailAddress
				+ ", postBoxNumber=" + postBoxNumber + ", isRent=" + isRent + ", landlordName=" + landlordName
				+ ", utilityBillnuber=" + utilityBillnuber + ", utilityBillType=" + utilityBillType + ", addressType="
				+ addressType + ", change=" + change + ", maker=" + maker + ", checker=" + checker + ", approved="
				+ approved + ", updateDate=" + updateDate + ", approvedDate=" + approvedDate + ", reason=" + reason
				+ "]";
	}
	
	
}