package com.trustaml.dataservice.kyc.kycn.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import com.trustaml.dataservice.identity.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "kycn_personal_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnPersonalInfo {

	@Id
	@SequenceGenerator(name = "kycn_personal_info_id_seq", sequenceName = "kycn_personal_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycn_personal_info_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name = "kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;

	@OneToOne(mappedBy = "personalInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("user")
	private User user;

	@JsonProperty("cust_id")
	@Column(name = "cust_id")
	private String customerId;

	@JsonProperty("salutation")
	@Column(name = "salutation")
	private String salutation;

	@JsonProperty("cbs_generated_name")
	@Column(name = "cbs_generated_name")
	private String cbsGeneratedName;

	@JsonProperty("first_name")
	@Column(name = "first_name")
	private String firstName;

	@JsonProperty("middle_name")
	@Column(name = "middle_name")
	private String middleName;

	@JsonProperty("last_name")
	@Column(name = "last_name")
	private String lastName;

	@JsonProperty("screening_id")
	@Column(name = "screening_id")
	private long screeningId;

	@JsonProperty("ls_title")
	@Column(name = "ls_title")
	private String lsTitle;

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

	@JsonProperty("previous_name")
	@Column(name = "previous_name")
	private String previousName;

	@JsonProperty("gender")
	@Column(name = "gender")
	private String gender;

	@JsonProperty("date_of_birth")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@JsonProperty("age")
	@Column(name = "age")
	private String age;

	@JsonProperty("marital_status")
	@Column(name = "marital_status")
	private String maritalStatus;

	@JsonProperty("notes")
	@Column(name = "notes")
	private String notes;

	@JsonProperty("customer_type")
	@Column(name = "customer_type")
	private String customerType;

	@JsonProperty("customer_group")
	@Column(name = "customer_group")
	private String customerGroup;

	@JsonProperty("customer_constitution")
	@Column(name = "customer_constitution")
	private String customerConstitution;

	@JsonProperty("customer_community")
	@Column(name = "customer_community")
	private String customerCommunity;

	@JsonProperty("customer_caste")
	@Column(name = "customer_caste")
	private String customerCaste;

	@JsonProperty("customer_employee_id")
	@Column(name = "customer_employee_id")
	private String customerEmployeeId;

	@JsonProperty("customer_open_date")
	@Column(name = "customer_open_date")
	private Date customerOpenDate;

	@JsonProperty("customer_maker")
	@Column(name = "customer_maker")
	private String customerMaker;

	@JsonProperty("customer_status_code")
	@Column(name = "customer_status_code")
	private String customerStatusCode;

	@JsonProperty("minor")
	@Column(name = "minor")
	private boolean minor;

	@JsonProperty("customer_nre_flag")
	@Column(name = "customer_nre_flag")
	private boolean nonResidentExternal;

	@JsonProperty("customer_cardholder_flag")
	@Column(name = "customer_cardholder_flag")
	private boolean cardHolder;

	@JsonProperty("pan_number")
	@Column(name = "pan_number")
	private String panNumber;

	@JsonProperty("cbs_imported_date")
	@Column(name = "cbs_imported_date")
	private Date cbsImportedDate;

	@JsonProperty("verified")
	@Column(name = "verified")
	private boolean verified;

	@JsonProperty("change")
	@Column(name = "change")
	private boolean change;

	@JsonProperty("date_of_birth_bs")
	@Column(name = "date_of_birth_bs")
	private Date dateOfBirthBS;

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
	
	@JsonProperty("screening_n_id")
	@Column(name="screening_n_id")
	private Long screeningLId;

	@Override
	public String toString() {
		return "KycnPersonalInfo [id=" + id + ", user=" + user + ", customerId=" + customerId + ", salutation="
				+ salutation + ", cbsGeneratedName=" + cbsGeneratedName + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", screeningId=" + screeningId + ", lsTitle=" + lsTitle
				+ ", lsfName=" + lsfName + ", lsmName=" + lsmName + ", lslName=" + lslName + ", secondName="
				+ secondName + ", calledByName=" + calledByName + ", previousName=" + previousName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", maritalStatus=" + maritalStatus
				+ ", notes=" + notes + ", customerType=" + customerType + ", customerGroup=" + customerGroup
				+ ", customerConstitution=" + customerConstitution + ", customerCommunity=" + customerCommunity
				+ ", customerCaste=" + customerCaste + ", customerEmployeeId=" + customerEmployeeId
				+ ", customerOpenDate=" + customerOpenDate + ", customerMaker=" + customerMaker
				+ ", customerStatusCode=" + customerStatusCode + ", minor=" + minor + ", nonResidentExternal="
				+ nonResidentExternal + ", cardHolder=" + cardHolder + ", panNumber=" + panNumber + ", cbsImportedDate="
				+ cbsImportedDate + ", verified=" + verified + ", change=" + change + ", dateOfBirthBS=" + dateOfBirthBS
				+ ", maker=" + maker + ", checker=" + checker + ", approved=" + approved + ", updateDate=" + updateDate
				+ ", approvedDate=" + approvedDate + ", reason=" + reason + ", screeningLId=" + screeningLId + "]";
	}

	

}