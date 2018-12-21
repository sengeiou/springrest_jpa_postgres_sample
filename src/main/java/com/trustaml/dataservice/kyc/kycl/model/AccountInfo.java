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
@Table(name = "kycl_account_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {

	@Id
	@SequenceGenerator(name = "kycl_account_info_id_seq", sequenceName = "kycl_account_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_account_info_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "kycl_id")
	@JsonIgnore
	private Kycl kycl;

	@JsonProperty("account_id")
	@Column(name = "account_id")
	private String accountId;

	@JsonProperty("for_account_id")
	@Column(name = "for_account_id")
	private String forAccountId;

	@JsonProperty("currency_of_account")
	@Column(name = "currency_of_account")
	private String currencyOfAccount;

	@JsonProperty("account_no")
	@Column(name = "account_no")
	private String accountNo;

	@JsonProperty("account_name")
	@Column(name = "account_name")
	private String accountName;

	@JsonProperty("account_short_name")
	@Column(name = "account_short_name")
	private String accountShortName;

	@JsonProperty("account_ownership")
	@Column(name = "account_ownership")
	private String accountOwnership;

	@JsonProperty("scheme_type")
	@Column(name = "scheme_type")
	private String schemeType;

	@JsonProperty("scheme_code")
	private String schemeCode;

	@JsonProperty("gl_sub_head_code")
	@Column(name = "gl_sub_head_code")
	private String glSubHeadCode;

	@JsonProperty("product_group")
	@Column(name = "product_group")
	private String productGroup;

	@JsonProperty("last_transaction_date")
	@Column(name = "last_transaction_date")
	private String lastTransactionDate;

	@JsonProperty("account_open_date")
	@Column(name = "account_open_date")
	private String accountOpenDate;

	@JsonProperty("estimated_yearly_transactions")
	@Column(name = "estimated_yearly_transactions")
	private long estimatedYearlyTransactions;

	@JsonProperty("estimated_monthly_transactions")
	@Column(name = "estimated_monthly_transactions")
	private long estimatedMonthlyTransactions;

	@JsonProperty("estimated_yearly_turnover")
	@Column(name = "estimated_yearly_turnover")
	private long estimatedYearlyTurnover;

	@JsonProperty("estimated_monthly_turnover")
	@Column(name = "estimated_monthly_turnover")
	private long estimatedMonthlyTurnover;

	@JsonProperty("regular_source_of_income")
	@Column(name = "regular_source_of_income")
	private String regularSourceOfIncome;

	@JsonProperty("source_of_fund")
	@Column(name = "source_of_fund")
	private String sourceOfFund;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("nature_of_account")
	@Column(name = "nature_of_account")
	private String natureOfAccount;

	@JsonProperty("scheme_description")
	@Column(name = "scheme_description")
	private String schemeDescription;

	@JsonProperty("dr_balance_limit")
	@Column(name = "dr_balance_limit")
	private String drBalanceLimit;

	@JsonProperty("deposite_amount")
	@Column(name = "deposite_amount")
	private String depositeAmount;

	@JsonProperty("customer_pan")
	@Column(name = "customer_pan")
	private String customerPan;

	@JsonProperty("customer_currency")
	@Column(name = "customer_currency")
	private String customerCurrency;

	@JsonProperty("is_blocked")
	@Column(name = "is_blocked")
	private String isBlocked;

	@JsonProperty("change")
	boolean change;

	@Override
	public String toString() {
		return "AccountInfo [id=" + id + ", accountId=" + accountId + ", forAccountId=" + forAccountId
				+ ", currencyOfAccount=" + currencyOfAccount + ", accountNo=" + accountNo + ", accountName="
				+ accountName + ", accountShortName=" + accountShortName + ", accountOwnership=" + accountOwnership
				+ ", schemeType=" + schemeType + ", schemeCode=" + schemeCode + ", glSubHeadCode=" + glSubHeadCode
				+ ", productGroup=" + productGroup + ", lastTransactionDate=" + lastTransactionDate
				+ ", accountOpenDate=" + accountOpenDate + ", estimatedYearlyTransactions="
				+ estimatedYearlyTransactions + ", estimatedMonthlyTransactions=" + estimatedMonthlyTransactions
				+ ", estimatedYearlyTurnover=" + estimatedYearlyTurnover + ", estimatedMonthlyTurnover="
				+ estimatedMonthlyTurnover + ", regularSourceOfIncome=" + regularSourceOfIncome + ", sourceOfFund="
				+ sourceOfFund + ", notes=" + notes + ", natureOfAccount=" + natureOfAccount + ", schemeDescription="
				+ schemeDescription + ", drBalanceLimit=" + drBalanceLimit + ", depositeAmount=" + depositeAmount
				+ ", customerPan=" + customerPan + ", customerCurrency=" + customerCurrency + ", isBlocked=" + isBlocked
				+ ", change=" + change + "]";
	}
	
	

}
