package com.trustaml.dataservice.kyc.kycl.model;

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
@Table(name= "kycl_legal")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycLegal {
	
	@Id
	@SequenceGenerator(name= "kycl_legal_id_seq", sequenceName="kycl_legal_id_seq", allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="kycl_legal_id_seq")
	private Long id;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="kycl_id")
	private Kycl kycl;
	
	
	@JsonProperty("screening_l_id")
	@Column(name="screening_l_id")
	private Long screeningLId;
	
	@JsonProperty("primary_sol_id")
	@Column(name="primary_sol_id")
	private String primarySolId;

	@JsonProperty("salutation")
	private String salutation;

	@JsonProperty("name_of_the_institution")
	@Column(name="name_of_the_institution")
	private String nameOfTheInstitution;

	@JsonProperty("ls_name")
	@Column(name="ls_name")
	private String lsName;

	@JsonProperty("cust_short_name")
	@Column(name="cust_short_names")
	private String custShortName;

	@JsonProperty("date_of_establishment")
	@Column(name="date_of_establishment")
	private String dateOfEstablishment;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("customer_type")
	@Column(name="customer_type")
	private String customerType;

	@JsonProperty("customer_group")
	@Column(name="customer_group")
	private String customerGroup;

	@JsonProperty("customer_constitution")
	@Column(name="customer_constitution")
	private String customerConstitution;

	@JsonProperty("customer_community")
	@Column(name="customer_community")
	private String customerCommunity;

	@JsonProperty("customer_employee_id")
	@Column(name="customer_employee_id")
	private String customerEmployeeId;

	@JsonProperty("customer_open_date")
	@Column(name="customer_open_date")
	private String customerOpenDate;

	@JsonProperty("customer_maker")
	@Column(name="customer_maker")
	private String customerMaker;


	@JsonProperty("pan_number")
	@Column(name="pan_number")
	private String panNumber;

	@JsonProperty("minor")
	private boolean minor;

	@JsonProperty("customer_status_code")
	@Column(name="customer_status_code")
	private String customerStatusCode;

	@JsonProperty("card_holder")
	@Column(name="card_holder")
	private boolean cardHolder;

	@JsonProperty("non_resident_external")
	@Column(name="non_resident_external")
	private boolean nonResidentExternal;

	@JsonProperty("cust_id")
	@Column(name="cust_id")
	private String custId;

	@JsonProperty("kycl_status")
	@Column(name="kycl_status")
	private String kyclStatus;

	@JsonProperty("last_update_date")
	@Column(name="last_update_date")
	private String lastUpdateDate;

	@JsonProperty("last_screened_date")
	@Column(name="last_screened_date")
	private String lastScreenedDate;

	@JsonProperty("verified_record")
	@Column(name="verified_record")
	boolean verifiedRecord;

	@JsonProperty("audited_fiscal_year")
	@Column(name="audited_fiscal_year")
	private String auditedFiscalYear;

	@JsonProperty("net_profit")
	@Column(name="net_profit")
	private String netProfit;

	@JsonProperty("net_loss")
	@Column(name="net_loss")
	private String netLoss;

	@JsonProperty("tax_clearence_certificate_date")
	@Column(name="tax_clearence_certificate_date")
	private String taxClearenceCertificateDate;

	@JsonProperty("tax_clearence_fiscal_year")
	@Column(name="tax_clearence_fiscal_year")
	private String taxClearenceFiscalYear;

	@JsonProperty("next_clearence_certificate_date")
	@Column(name="next_clearence_certificate_date")
	private String nextClearenceCertificateDate;

	@JsonProperty("taxable_amount")
	@Column(name="taxable_amount")
	private String taxableAmount;

	@JsonProperty("taxable_income")
	@Column(name="taxable_income")
	private String taxableIncome;

	@JsonProperty("tax_paid")
	@Column(name="tax_paid")
	private String taxPaid;

	@JsonProperty("tax_paid_date")
	@Column(name="tax_paid_date")
	private String taxPaidDate;

	@JsonProperty("types_of_industry")
	@Column(name="types_of_industry")
	private String typeOfIndustry;

	@JsonProperty("change")
	private boolean change;

	@JsonProperty("date_of_establishment_bs")
	@Column(name="date_of_establishment_bs")
	private Date dateOfEstablishmentBS;

	@Override
	public String toString() {
		return "Legal [id=" + id + ", screeningLId=" + screeningLId + ", primarySolId=" + primarySolId + ", salutation="
				+ salutation + ", nameOfTheInstitution=" + nameOfTheInstitution + ", lsName=" + lsName
				+ ", custShortName=" + custShortName + ", dateOfEstablishment=" + dateOfEstablishment + ", notes="
				+ notes + ", customerType=" + customerType + ", customerGroup=" + customerGroup
				+ ", customerConstitution=" + customerConstitution + ", customerCommunity=" + customerCommunity
				+ ", customerEmployeeId=" + customerEmployeeId + ", customerOpenDate=" + customerOpenDate
				+ ", customerMaker=" + customerMaker + ", panNumber=" + panNumber + ", minor=" + minor
				+ ", customerStatusCode=" + customerStatusCode + ", cardHolder=" + cardHolder + ", nonResidentExternal="
				+ nonResidentExternal + ", custId=" + custId + ", kyclStatus=" + kyclStatus + ", lastUpdateDate="
				+ lastUpdateDate + ", lastScreenedDate=" + lastScreenedDate + ", verifiedRecord=" + verifiedRecord
				+ ", auditedFiscalYear=" + auditedFiscalYear + ", netProfit=" + netProfit + ", netLoss=" + netLoss
				+ ", taxClearenceCertificateDate=" + taxClearenceCertificateDate + ", taxClearenceFiscalYear="
				+ taxClearenceFiscalYear + ", nextClearenceCertificateDate=" + nextClearenceCertificateDate
				+ ", taxableAmount=" + taxableAmount + ", taxableIncome=" + taxableIncome + ", taxPaid=" + taxPaid
				+ ", taxPaidDate=" + taxPaidDate + ", typeOfIndustry=" + typeOfIndustry + ", change=" + change
				+ ", dateOfEstablishmentBS=" + dateOfEstablishmentBS + "]";
	}

	

	
}
