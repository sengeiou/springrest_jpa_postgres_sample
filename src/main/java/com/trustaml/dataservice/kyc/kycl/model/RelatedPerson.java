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
@Table(name = "kycl_related_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatedPerson {

	@Id
	@SequenceGenerator(name = "kycl_related_person_id_seq", sequenceName = "kycl_related_person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_related_person_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="kycl_id")
	@JsonIgnore
	private Kycl kycl;

	@JsonProperty("person_type")
	@Column(name = "perosn_type")
	private String personType;

	@JsonProperty("cust_id")
	@Column(name = "cust_id")
	private String custId;

	@JsonProperty("salutation")
	private String salutation;

	@JsonProperty("first_name")
	@Column(name = "first_name")
	private String firstName;

	@JsonProperty("middle_name")
	@Column(name = "middle_name")
	private String middleName;

	@JsonProperty("last_name")
	@Column(name = "last_name")
	private String lastName;

	@JsonProperty("lsf_name")
	@Column(name = "lsf_name")
	private String lsfName;

	@JsonProperty("lsm_name")
	@Column(name = "lsm_name")
	private String lsmName;

	@JsonProperty("lsl_name")
	@Column(name = "lsl_name")
	private String lslName;

	@JsonProperty("second_name")
	@Column(name = "second_name")
	private String secondName;

	@JsonProperty("called_by_name")
	@Column(name = "called_by_name")
	private String calledByName;

	@JsonProperty("primary_identification_document_type")
	@Column(name = "primary_identification_document_type")
	private String primaryIdentificationDocumentType;

	@JsonProperty("primary_identification_document_no")
	@Column(name = "primary_identification_document_no")
	private String primaryIdentificationDocumentNo;

	@JsonProperty("country")
	private String country;

	@JsonProperty("issuing_authority")
	@Column(name = "issuing_authority")
	private String issuingAuthority;

	@JsonProperty("place_of_issue")
	@Column(name = "place_of_issue")
	private String placeOfIssue;

	@JsonProperty("issue_date")
	@Column(name = "issue_date")
	private String issueDate;

	@JsonProperty("expiry_date")
	@Column(name = "expiry_date")
	private String expiryDate;

	@JsonProperty("notes")
	private String notes;

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

	@JsonProperty("email_id")
	@Column(name = "email_id")
	private String emailId;

	@JsonProperty("change")
	private boolean change;

	@JsonProperty("province")
	private String province;

	@Override
	public String toString() {
		return "RelatedPerson [id=" + id + ", personType=" + personType + ", custId=" + custId + ", salutation="
				+ salutation + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", lsfName=" + lsfName + ", lsmName=" + lsmName + ", lslName=" + lslName + ", secondName="
				+ secondName + ", calledByName=" + calledByName + ", primaryIdentificationDocumentType="
				+ primaryIdentificationDocumentType + ", primaryIdentificationDocumentNo="
				+ primaryIdentificationDocumentNo + ", country=" + country + ", issuingAuthority=" + issuingAuthority
				+ ", placeOfIssue=" + placeOfIssue + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate
				+ ", notes=" + notes + ", zone=" + zone + ", district=" + district + ", mnVdc=" + mnVdc + ", pinzip="
				+ pinzip + ", wardNumber=" + wardNumber + ", toleArea=" + toleArea + ", street=" + street + ", houseNo="
				+ houseNo + ", unitNumber=" + unitNumber + ", nearestLandmark=" + nearestLandmark + ", latitude="
				+ latitude + ", longitude=" + longitude + ", phoneNoCountryCode=" + phoneNoCountryCode
				+ ", phoneNoAreaCode=" + phoneNoAreaCode + ", phoneNo=" + phoneNo + ", telexNoCountryCode="
				+ telexNoCountryCode + ", telexNoAreaCode=" + telexNoAreaCode + ", telexNo=" + telexNo + ", emailId="
				+ emailId + ", change=" + change + ", province=" + province + "]";
	}
	
	

}
