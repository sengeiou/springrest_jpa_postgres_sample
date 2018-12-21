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
@Table(name = "kycn_identification_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnIdentificationInfo {

	@Id
	@SequenceGenerator(name = "kycn_identification_info_id_seq", sequenceName = "kycn_identification_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycn_identification_info_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;

	@JsonProperty("primary_identification_document_type")
	@Column(name = "primary_identification_document_type")
	private String primaryIdentificationDocumentType;

	@JsonProperty("primary_identification_document_no")
	@Column(name = "primary_identification_document_no")
	private String primaryIdentificationDocumentNo;

	@JsonProperty("country_of_issue")
	@Column(name = "country_of_issue")
	private String countryOfIssue;

	@JsonProperty("expiry_date")
	@Column(name = "expiry_date")
	private Date expiryDate;

	@JsonProperty("visa_no")
	@Column(name = "visa_no")
	private String visaNo;

	@JsonProperty("visa_expiry_date")
	@Column(name = "visa_expiry_date")
	private Date visaExpiryDate;

	@JsonProperty("nepal_entry_date")
	@Column(name = "nepal_entry_date")
	private Date nepalEntryDate;

	@JsonProperty("notes")
	@Column(name = "notes")
	private String notes;

	@JsonProperty("identification_number")
	@Column(name = "identification_number")
	private String identificationNumber;

	@JsonProperty("issuing_authority")
	@Column(name = "issuing_authority")
	private String issuingAuthority;

	@JsonProperty("place_of_issue")
	@Column(name = "place_of_issue")
	private String placeOfIssue;

	@JsonProperty("issue_date")
	@Column(name = "issue_date")
	private java.sql.Date issueDate;

	@JsonProperty("change")
	@Column(name = "change")
	private boolean change;

	@Column(name = "maker")
	private String maker;

	@Column(name = "checker")
	private String checker;

	@Column(name = "approved")
	private boolean approved;

	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "approvedDate")
	private Date approvedDate;

	@Column(name = "reason")
	private String reason;

	@Override
	public String toString() {
		return "KycnIdentificationInfo [id=" + id + ", primaryIdentificationDocumentType="
				+ primaryIdentificationDocumentType + ", primaryIdentificationDocumentNo="
				+ primaryIdentificationDocumentNo + ", countryOfIssue=" + countryOfIssue + ", expiryDate=" + expiryDate
				+ ", visaNo=" + visaNo + ", visaExpiryDate=" + visaExpiryDate + ", nepalEntryDate=" + nepalEntryDate
				+ ", notes=" + notes + ", identificationNumber=" + identificationNumber + ", issuingAuthority="
				+ issuingAuthority + ", placeOfIssue=" + placeOfIssue + ", issueDate=" + issueDate + ", change="
				+ change + ", maker=" + maker + ", checker=" + checker + ", approved=" + approved + ", updateDate="
				+ updateDate + ", approvedDate=" + approvedDate + ", reason=" + reason + "]";
	}
}
