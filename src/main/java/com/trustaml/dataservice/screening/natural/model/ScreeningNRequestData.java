package com.trustaml.dataservice.screening.natural.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "screening_n_request_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningNRequestData {

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "screening_n_request_data_id_seq", sequenceName = "screening_n_request_data_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_n_request_data_id_seq")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="screening_n_request_id")
	@JsonIgnore
	private ScreeningNRequest screeningNRequest;
	

	@OneToOne
	@JoinColumn(name="screening_related_request_id")
	@JsonIgnore
	private ScreeningRelatedRequest screeningRelatedRequest;
	
	@JsonProperty("branch_sol_id")
	@Column(name = "branch_sol_id")
	private String branchSolId;

	@JsonProperty("purpose_of_screening_n")
	@Column(name = "purpose_of_screening_n")
	private String purposeOfScreeningN;

	@JsonProperty("sender_receiver")
	@Column(name = "sender_receiver")
	private String senderReceiver;

	@JsonProperty("has_kycn")
	@Column(name = "has_kycn")
	private boolean hasKycn;

	@JsonProperty("kycn_id")
	@Column(name = "kycn_id")
	private long kycnId;

	@JsonProperty("has_cust_id")
	@Column(name = "has_cust_id")
	private boolean hasCustId;

	@JsonProperty("cust_id")
	@Column(name = "cust_id")
	private String custId;

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

	@JsonProperty("date_of_birth")
	@Column(name = "date_of_birth")
	private java.sql.Date dateOfBirth;

	@JsonProperty("primary_identification_document_type")
	@Column(name = "primary_identification_document_type")
	private String primaryIdentificationType;

	@JsonProperty("primary_identification_document_no")
	@Column(name = "primary_identification_document_no")
	private String primaryIdentificationNo;

	@JsonProperty("country_of_issue")
	@Column(name = "country_of_issue")
	private String countryOfIssue;

	@JsonProperty("state")
	@Column(name = "state")
	private String state;

	@JsonProperty("district")
	@Column(name = "district")
	private String district;

	@JsonProperty("mn_vdc")
	@Column(name = "mn_vdc")
	private String mnVdc;

	@JsonProperty("ward_no")
	@Column(name = "ward_no")
	private String wardNo;

	@JsonProperty("username")
	@Column(name = "username")
	private String maker;

	@JsonProperty("request_date")
	@Column(name = "request_date")
	private java.sql.Date requestDate;

	@JsonProperty("request_time")
	@Column(name = "request_time")
	private java.sql.Time requestTime;

	@JsonProperty("status")
	@Column(name = "status")
	private String status;

	@JsonProperty("screening_completed")
	@Column(name = "screening_completed")
	private boolean screeningCompleted;

	@JsonProperty("risk")
	@Column(name = "risk")
	private int risk;

	@JsonProperty("workflow_completed")
	@Column(name = "workflow_completed")
	private boolean workflowCompleted;

	@JsonProperty("account_type")
	@Column(name = "account_type")
	private String accountType;

	@JsonProperty("account_sub_type")
	@Column(name = "account_sub_type")
	private String accountSubType;

	@JsonProperty("has_nominee")
	@Column(name = "has_nominee")
	private boolean hasNominee;

	@JsonProperty("num_nominee")
	@Column(name = "num_nominee")
	private int numNominee;

	@JsonProperty("has_mandate")
	@Column(name = "has_mandate")
	private boolean hasMandate;

	@JsonProperty("num_mandate")
	@Column(name = "num_mandate")
	private int numMandate;

	@JsonProperty("has_signatory")
	@Column(name = "has_signatory")
	private boolean hasSignatory;

	@JsonProperty("num_signatory")
	@Column(name = "num_signatory")
	private int numSignatory;

	@JsonProperty("has_joint_account_holder")
	@Column(name = "has_joint_account_holder")
	private boolean hasJointAccountHolder;

	@JsonProperty("num_joint_account_holder")
	@Column(name = "num_joint_account_holder")
	private int numJointAccountHolder;

	@JsonProperty("find_match_index")
	@Column(name = "find_match_index")
	private float matchIndex;

	@JsonProperty("notes")
	@Column(name = "notes")
	private String notes;

	@JsonProperty("zone")
	@Column(name = "zone")
	private String zone;

	@JsonProperty("province")
	@Column(name = "province")
	private String province;

	@JsonProperty("repair_screening_n_request_id")
	@Column(name = "repair_screening_n_request_id")
	private long repairScreeningNRequestId;

	@JsonProperty("salutation")
	@Column(name = "salutation")
	private String salutation;

	@JsonProperty("gender")
	@Column(name = "gender")
	private String gender;

	@JsonProperty("mobile_number")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@JsonProperty("email_id")
	@Column(name = "email_id")
	private String emailId;

	@JsonProperty("nature_of_account")
	@Column(name = "nature_of_account")
	private String natureOfAccount;

	@JsonProperty("scheme_description")
	@Column(name = "scheme_description")
	private String schemeDescription;

	@JsonProperty("deposit_amount")
	@Column(name = "deposit_amount")
	private String depositAmount;

	@JsonProperty("pan_number")
	@Column(name = "pan_number")
	private String panNumber;

	@JsonProperty("repaired")
	@Column(name = "repaired")
	private boolean repaired;

	@JsonProperty("migrated")
	@Column(name = "migrated")
	private boolean migrated;

	@JsonProperty("date_of_birth_bs")
	@Column(name = "date_of_birth_bs")
	private Date dateOfBirthBS;

	@JsonProperty("search_text")
	@Column(name = "search_text")
	private String searchText;
}
