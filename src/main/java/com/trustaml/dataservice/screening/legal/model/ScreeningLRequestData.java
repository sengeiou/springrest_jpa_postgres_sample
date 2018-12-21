package com.trustaml.dataservice.screening.legal.model;

import java.io.Serializable;
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
@Table(name = "screening_l_request_data")
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningLRequestData  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "screening_l_request_data_id_seq", sequenceName = "screening_l_request_data_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_l_request_data_id_seq")
	private Long id;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="screening_l_request_id")
	private ScreeningLRequest screeningLRequest;
	
	@JsonProperty("accounts_l_sub_type")
	@Column(name = "accounts_l_sub_type")
	private String accountsLSubType;

	@JsonProperty("kycl_id")
	@Column(name = "kycl_id")
	private String kyclId;

	@JsonProperty("cust_id")
	@Column(name = "cust_id")
	private String custId;

	@JsonProperty("name_of_institution")
	@Column(name = "name_of_institution")
	private String nameOfInstitution;

	@JsonProperty("ls_name")
	@Column(name = "ls_name")
	private String lsName;

	@JsonProperty("date_of_establishment")
	@Column(name = "date_of_establishment")
	private String dateOfEstablishment;

	@JsonProperty("registration_no")
	@Column(name = "registration_no")
	private String registrationNo;

	@JsonProperty("type_of_industry")
	@Column(name = "type_of_industry")
	private String typeOfIndustry;

	@JsonProperty("country_of_issue")
	@Column(name = "country_of_issue")
	private String countryOfIssue;

	@JsonProperty("zone")
	@Column(name = "zone")
	private String zone;

	@JsonProperty("district")
	@Column(name = "district")
	private String district;

	@JsonProperty("mn_vdc")
	@Column(name = "mn_vdc")
	private String mnVdc;

	@JsonProperty("province")
	@Column(name = "province")
	private String province;

	@JsonProperty("ward_no")
	@Column(name = "ward_no")
	private String wardNo;

	@JsonProperty("pan_number")
	@Column(name = "pan_number")
	private String panNumber;

	@JsonProperty("contact_number")
	@Column(name = "contact_number")
	private String contactNumber;

	@JsonProperty("email_id")
	@Column(name = "email_id")
	private String emailId;

	@JsonProperty("notes")
	@Column(name = "notes")
	private String notes;

	@JsonProperty("find_match_index")
	@Column(name = "find_match_index")
	private String findMatchIndex;

	@JsonProperty("has_kyc")
	@Column(name = "has_kyc")
	private boolean haskyc;

	@JsonProperty("has_cust_id")
	@Column(name = "has_cust_id")
	boolean hasCustId;

	@JsonProperty("branch_sol_id")
	@Column(name = "branch_sol_id")
	private String branchSolId;

	@JsonProperty("date_of_establishment_bs")
	@Column(name = "date_of_establishment_bs")
	private Date dateOfEstablishmentBS;

	@JsonProperty("repair_screening_l_request_id")
	@Column(name = "repair_screening_l_request_id")
	private long repairScreeningLRequestId;

	@JsonProperty("search_text")
	@Column(name = "search_text")
	private String searchText;

}
