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

@Entity
@Audited
@Table(name="kycn_involvement_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnInvolvementInfo {

	@Id
	@SequenceGenerator(name="kycn_involvement_info_id_seq", sequenceName = "kycn_involvement_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "kycn_involvement_info_id_seq")
	private Long id;
	

	@ManyToOne
	@JoinColumn(name="kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;
	
	@JsonProperty("kycl_id")
	@Column(name="kycl_id")
	private long kyclId;

	@JsonProperty("organization_nature")
	@Column(name="organization_nature")
	private String organizationNature;

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

	@JsonProperty("involvement_ward_number")
	@Column(name="involvement_ward_number")
	private String involvementWardNumber;

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

	@JsonProperty("fax_no_country_code")
	@Column(name="fax_no_country_code")
	private String faxNoCountryCode;

	@JsonProperty("fax_no_area_code")
	@Column(name="fax_no_area_code")
	private String faxNoAreaCode;

	@JsonProperty("fax_no")
	@Column(name="fax_no")
	private String faxNo;

	@JsonProperty("email_id")
	@Column(name="email_id")
	private String emailId;

	@JsonProperty("website")
	@Column(name="website")
	private String website;

	@JsonProperty("panvat")
	@Column(name="panvat")
	private String panVat;

	@JsonProperty("poboxno")
	@Column(name="poboxno")
	private String poBoxNo;

	@JsonProperty("nature")
	@Column(name="nature")
	private String nature;

	@JsonProperty("designation")
	@Column(name="designation")
	private String designation;

	@JsonProperty("start_date")
	@Column(name="start_date")
	private Date startDate;

	@JsonProperty("end_date")
	@Column(name="end_date")
	private Date endDate;

	@JsonProperty("involvement_notes")
	@Column(name="involvement_notes")
	private String involvementNotes;

	@JsonProperty("notes")
	@Column(name="notes")
	private String notes;

	@JsonProperty("nature_of_involvement")
	@Column(name="nature_of_involvement")
	private String involvementNature;

	@JsonProperty("occupation_type")
	@Column(name="occupation_type")
	private String occupationType;

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
		return "KycnInvolvementInfo [id=" + id + ", kyclId=" + kyclId + ", organizationNature=" + organizationNature
				+ ", country=" + country + ", state=" + state + ", zone=" + zone + ", district=" + district
				+ ", province=" + province + ", mnVdc=" + mnVdc + ", pinZip=" + pinZip + ", involvementWardNumber="
				+ involvementWardNumber + ", toleArea=" + toleArea + ", street=" + street + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", nearestLandMark=" + nearestLandMark + ", houseNo=" + houseNo
				+ ", unitNumber=" + unitNumber + ", phoneNoCountryCode=" + phoneNoCountryCode + ", phoneNoAreaCode="
				+ phoneNoAreaCode + ", phoneNo=" + phoneNo + ", faxNoCountryCode=" + faxNoCountryCode
				+ ", faxNoAreaCode=" + faxNoAreaCode + ", faxNo=" + faxNo + ", emailId=" + emailId + ", website="
				+ website + ", panVat=" + panVat + ", poBoxNo=" + poBoxNo + ", nature=" + nature + ", designation="
				+ designation + ", startDate=" + startDate + ", endDate=" + endDate + ", involvementNotes="
				+ involvementNotes + ", notes=" + notes + ", involvementNature=" + involvementNature
				+ ", occupationType=" + occupationType + ", change=" + change + ", maker=" + maker + ", checker="
				+ checker + ", approved=" + approved + ", updateDate=" + updateDate + ", approvedDate=" + approvedDate
				+ ", reason=" + reason + "]";
	}
	
	
}