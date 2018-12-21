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
@Table(name="kycn_related_person_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnRelatedPersonInfo {

	@Id
	@SequenceGenerator(name="kycn_related_person_info_id_seq", sequenceName = "kycn_related_person_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "kycn_related_person_info_id_seq")
	private Long id;


	@ManyToOne
	@JoinColumn(name="kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;
	
	@JsonProperty("person_type")
	@Column(name="person_type")
	private String personType;

	@JsonProperty("cust_id")
	@Column(name="cust_id")
	private String custId;

	@JsonProperty("kycn_id")
	@Column(name="kycn_id")
	private long kycnId;

	@JsonProperty("salutation")
	@Column(name="salutation")
	private String salutation;

	@JsonProperty("first_name")
	@Column(name="first_name")
	private String firstName;

	@JsonProperty("middle_name")
	@Column(name="middle_name")
	private String middleName;

	@JsonProperty("last_name")
	@Column(name="last_name")
	private String lastName;

	@JsonProperty("lsf_name")
	@Column(name="lsf_name")
	private String lsfName;

	@JsonProperty("lsm_name")
	@Column(name="lsm_name")
	private String lsmName;

	@Column(name="lsl_name")
	@JsonProperty("lsl_name")
	private String lslName;

	@Column(name="second_name")
	@JsonProperty("second_name")
	private String secondName;

	@JsonProperty("called_by_name")
	@Column(name="called_by_name")
	private String calledByName;

	@Column(name="primary_identitificatin_document_type")
	@JsonProperty("primary_identification_document_type")
	private String primaryIdentificationDocumentType;

	@Column(name="primary_identification_document_no")
	@JsonProperty("primary_identification_document_no")
	private String primaryIdentificationDocumentNo;

	@Column(name="country")
	@JsonProperty("country")
	private String country;

	@Column(name="issuing_authority")
	@JsonProperty("issuing_authority")
	private String issuingAuthority;

	@Column(name="place_of_issue")
	@JsonProperty("place_of_issue")
	private String placeOfIssue;

	@Column(name="issue_date")
	@JsonProperty("issue_date")
	private Date issueDate;

	@Column(name="expiry_date")
	@JsonProperty("expiry_date")
	private Date expiryDate;

	@Column(name="notes")
	@JsonProperty("notes")
	private String notes;

	@Column(name="change")
	@JsonProperty("change")
	private boolean change;


	@Override
	public String toString() {
		return "KycnRelatedPersonInfo [id=" + id + ", personType=" + personType + ", custId=" + custId + ", kycnId="
				+ kycnId + ", salutation=" + salutation + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", lsfName=" + lsfName + ", lsmName=" + lsmName + ", lslName=" + lslName
				+ ", secondName=" + secondName + ", calledByName=" + calledByName
				+ ", primaryIdentificationDocumentType=" + primaryIdentificationDocumentType
				+ ", primaryIdentificationDocumentNo=" + primaryIdentificationDocumentNo + ", country=" + country
				+ ", issuingAuthority=" + issuingAuthority + ", placeOfIssue=" + placeOfIssue + ", issueDate="
				+ issueDate + ", expiryDate=" + expiryDate + ", notes=" + notes + ", change=" + change + "]";
	}


	

}
