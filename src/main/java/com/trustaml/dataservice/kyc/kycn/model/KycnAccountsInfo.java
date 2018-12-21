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
@Table(name="kycn_accounts_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnAccountsInfo {

	@Id
	@SequenceGenerator(name="kycn_accounts_info_id_seq", sequenceName = "kycn_accounts_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "kycn_accounts_info_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;
	
	@JsonProperty("account_id")
	@Column(name="account_id")
	private String accountId;

	@JsonProperty("for_account_id")
	@Column(name="for_account_id")
	private String forAccountId;

	@Column(name="currency_of_account")
	@JsonProperty("currency_of_account")
	private String currencyOfAccount;

	@Column(name="account_no")
	@JsonProperty("account_no")
	private String accountNo;

	@Column(name="account_name")
	@JsonProperty("account_name")
	private String accountName;

	@Column(name="account_short_name")
	@JsonProperty("account_short_name")
	private String accountShortName;

	@Column(name= "account_ownership")
	@JsonProperty("account_ownership")
	private String accountOwnership;

	@Column(name="scheme_type")
	@JsonProperty("scheme_type")
	private String schemeType;

	@JsonProperty("scheme_code")
	@Column(name="scheme_code")
	private String schemeCode;

	@JsonProperty("gl_sub_head_code")
	@Column(name= "gl_sub_head_code")
	private String glSubHeadCode;

	@JsonProperty("product_group")
	@Column(name="product_group")
	private String productGroup;
	

	@JsonProperty("last_transaction_date")
	@Column(name="last_transaction_date")
	private Date lastTransactionDate;

	@JsonProperty("account_open_date")
	@Column(name="account_open_date")
	private Date accountOpenDate;

	@JsonProperty("estimated_monthly_turnover")
	@Column(name="estimated_monthly_turnover")
	private String estimatedMonthlyTurnOver;

	@JsonProperty("estimated_yearly_turnover")
	@Column(name="estimated_yearly_turnover")
	private String estimatedYearlyTurnOver;

	@JsonProperty("estimated_monthly_transactions")
	@Column(name="estimated_monthly_transactions")
	private String estimatedMonthlyTransaction;

	@JsonProperty("estimated_yearly_transactions")
	@Column(name="estimated_yearly_transactions")
	private String estimatedYearlyTransaction;

	@JsonProperty("source_of_fund")
	@Column(name="source_of_fund")
	private String sourceOfFund;

	@JsonProperty("regular_source_of_income")
	@Column(name="regular_source_of_income")
	private String regularSourceOfIncome;

	@JsonProperty("notes")
	@Column(name="notes")
	private String notes;
	
//	@JsonProperty("accounts_services_subscribed")
//	@Column(name="accounts_services_subscribed")
//	private List<String> accountServiceSubscribed;
//
//	@JsonProperty("accounts_cards_subscribed")
//	@Column(name="accounts_cards_subscribed")
//	private List<String> accountCardSubscribed;

	@JsonProperty("change")
	@Column(name="change")
	private boolean change;
	
	@JsonProperty("nature_of_account")
	@Column(name="")
	String natureOfAccount;

	@JsonProperty("scheme_description")
	@Column(name="scheme_description")
	String schemeDescription;
	
	@JsonProperty("is_blocked")
	@Column(name="is_blocked")
	private String isBlocked;

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
		return "KycnAccountsInfo [id=" + id + ", accountId=" + accountId + ", forAccountId=" + forAccountId
				+ ", currencyOfAccount=" + currencyOfAccount + ", accountNo=" + accountNo + ", accountName="
				+ accountName + ", accountShortName=" + accountShortName + ", accountOwnership=" + accountOwnership
				+ ", schemeType=" + schemeType + ", schemeCode=" + schemeCode + ", glSubHeadCode=" + glSubHeadCode
				+ ", productGroup=" + productGroup + ", lastTransactionDate=" + lastTransactionDate
				+ ", accountOpenDate=" + accountOpenDate + ", estimatedMonthlyTurnOver=" + estimatedMonthlyTurnOver
				+ ", estimatedYearlyTurnOver=" + estimatedYearlyTurnOver + ", estimatedMonthlyTransaction="
				+ estimatedMonthlyTransaction + ", estimatedYearlyTransaction=" + estimatedYearlyTransaction
				+ ", sourceOfFund=" + sourceOfFund + ", regularSourceOfIncome=" + regularSourceOfIncome + ", notes="
				+ notes + ", change=" + change + ", natureOfAccount=" + natureOfAccount + ", schemeDescription="
				+ schemeDescription + ", isBlocked=" + isBlocked + ", maker=" + maker + ", checker=" + checker
				+ ", approved=" + approved + ", updateDate=" + updateDate + ", approvedDate=" + approvedDate
				+ ", reason=" + reason + "]";
	}
	
	
	

	
	
}
