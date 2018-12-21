package com.trustaml.dataservice.kyc.kycn.model;

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
@Table(name="kycn_related_entity_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnRelatedEntityInfo {

	@Id
	@SequenceGenerator(name="kycn_related_entity_info_id_seq", sequenceName = "kycn_related_entity_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "kycn_related_entity_info_id_seq")
	private Long id;


	@ManyToOne
	@JoinColumn(name="kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;
	
	@JsonProperty("related_entity_type")
	@Column(name="related_entity_type")
	private String relatedEntityType;

	@JsonProperty("salutatiton")
	@Column(name="salutatiton")
	private String salutatiton;

	@JsonProperty("cust_id")
	@Column(name="cust_id")
	private String custId;

	@JsonProperty("kycn_id")
	@Column(name="kycn_id")
	private long kycnId;

	@JsonProperty("name")
	@Column(name="name")
	private String name;

	@JsonProperty("ls_name")
	@Column(name="ls_name")
	private String lsName;

	@JsonProperty("called_by_name")
	@Column(name="called_by_name")
	private String calledByName;

	@JsonProperty("primary_identification_document_type")
	@Column(name="primary_identification_document_type")
	private String primaryIdentificationDocumentType;

	@JsonProperty("registration_no")
	@Column(name="registration_no")
	private String registrationNo;

	@JsonProperty("related_entity_country")
	@Column(name="related_entity_country")
	private String relatedEntityCountry;

	@JsonProperty("zone")
	@Column(name="zone")
	private String zone;

	@JsonProperty("district")
	@Column(name="district")
	private String district;

	@JsonProperty("mn_vdc")
	@Column(name="mn_vdc")
	private String mnVdc;

	@JsonProperty("pinzip")
	@Column(name="pinzip")
	private String pinzip;

	@JsonProperty("ward_number")
	@Column(name="ward_number")
	private String wardNumber;

	@JsonProperty("tole_area")
	@Column(name="tole_area")
	private String toleArea;

	@JsonProperty("street")
	@Column(name="street")
	private String street;

	@JsonProperty("house_no")
	@Column(name="house_no")
	private String houseNo;

	@JsonProperty("unit_number")
	@Column(name="unit_number")
	private String unitNumber;

	@JsonProperty("nearest_landmark")
	@Column(name="nearest_landmark")
	private String nearestLandmark;

	@JsonProperty("latitude")
	@Column(name="latitude")
	private String latitude;

	@JsonProperty("longitude")
	@Column(name="longitude")
	private String longitude;

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

	@JsonProperty("email_id")
	@Column(name="email_id")
	private String emailId;

	@JsonProperty("notes")
	@Column(name="notes")
	private String notes;

	@JsonProperty("change")
	@Column(name="change")
	private boolean change;

	@JsonProperty("province")
	@Column(name="province")
	private String province;

	@Override
	public String toString() {
		return "KycnRelatedEntityInfo [id=" + id + ", relatedEntityType=" + relatedEntityType + ", salutatiton="
				+ salutatiton + ", custId=" + custId + ", kycnId=" + kycnId + ", name=" + name + ", lsName=" + lsName
				+ ", calledByName=" + calledByName + ", primaryIdentificationDocumentType="
				+ primaryIdentificationDocumentType + ", registrationNo=" + registrationNo + ", relatedEntityCountry="
				+ relatedEntityCountry + ", zone=" + zone + ", district=" + district + ", mnVdc=" + mnVdc + ", pinzip="
				+ pinzip + ", wardNumber=" + wardNumber + ", toleArea=" + toleArea + ", street=" + street + ", houseNo="
				+ houseNo + ", unitNumber=" + unitNumber + ", nearestLandmark=" + nearestLandmark + ", latitude="
				+ latitude + ", longitude=" + longitude + ", phoneNoCountryCode=" + phoneNoCountryCode
				+ ", phoneNoAreaCode=" + phoneNoAreaCode + ", phoneNo=" + phoneNo + ", telexNoCountryCode="
				+ telexNoCountryCode + ", telexNoAreaCode=" + telexNoAreaCode + ", telexNo=" + telexNo + ", emailId="
				+ emailId + ", notes=" + notes + ", change=" + change + ", province=" + province + "]";
	}

	
	
}
