package com.trustaml.dataservice.kyc.kycl.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trustaml.dataservice.identity.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "kycl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kycl {

	@Id
	@SequenceGenerator(name = "kycl_id_seq", sequenceName = "kycl_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_id_seq")
	private Long id;

	@JsonProperty("kycl_info")
	@OneToOne(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private KycLegal legal;

	@JsonProperty("accounts_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<AccountInfo> listAccountInfo = new HashSet<>();

	@JsonProperty("address_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Address> listAddress = new HashSet<>();

	@JsonProperty("audit_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<AuditInfo> listAuditInfo = new HashSet<>();

	@JsonProperty("business_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<BusinessInfo> listBusinessInfo = new HashSet<>();

	@JsonProperty("compliance_info")
	@OneToOne(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ComplianceInfo complianceInfo;

	@JsonProperty("document_status_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DocumentStatus> listDocumentStatus = new HashSet<>();

	@JsonProperty("landlord_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<LandlordInfo> listLandlordAddress = new HashSet<>();

	@JsonProperty("registration_address_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RegistrationAddress> listRegistrationAddress = new HashSet<>();

	@JsonProperty("registration_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RegistrationInfo> listRegistrationInfo = new HashSet<>();

	@JsonProperty("related_entity_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RelatedEntity> listRelatedEntityInfo = new HashSet<>();

	@JsonProperty("related_person_info")
	@OneToMany(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RelatedPerson> listRelatedPerson = new HashSet<>();

	@JsonProperty("user")
	@OneToOne(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

	@JsonProperty("financial_info")
	@OneToOne(mappedBy = "kycl", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private FinancialInfo financialInfo;

	private boolean updated;

	@Column(name = "maker")
	private String maker;

	@Column(name = "checker")
	private String checker;

	@Column(name = "approved")
	private boolean approved;

	@Column(name = "update_Date")
	@JsonProperty("update_Date")
	private Date updateDate;

	@Column(name = "approved_Date")
	@JsonProperty("approved_Date")
	private Date approvedDate;

	@Column(name = "reason")
	private String reason;

	@JsonProperty("search_text")
	@Column(name = "search_text")
	private String searchText;

	@Override
	public String toString() {
		return "Kycl [id=" + id + ", legal=" + legal + ", listAccountInfo=" + listAccountInfo + ", listAddress="
				+ listAddress + ", listAuditInfo=" + listAuditInfo + ", listBusinessInfo=" + listBusinessInfo
				+ ", complianceInfo=" + complianceInfo + ", listDocumentStatus=" + listDocumentStatus
				+ ", listLandlordAddress=" + listLandlordAddress + ", listRegistrationAddress="
				+ listRegistrationAddress + ", listRegistrationInfo=" + listRegistrationInfo
				+ ", listRelatedEntityInfo=" + listRelatedEntityInfo + ", listRelatedPerson=" + listRelatedPerson
				+ ", user=" + user + ", financialInfo=" + financialInfo + ", updated=" + updated + ", searchText="
				+ searchText + "]";
	}

}
