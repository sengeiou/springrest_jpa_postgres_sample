package com.trustaml.dataservice.str.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "str_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrInfo {

	@Id
	@SequenceGenerator(name = "str_info_id_seq", sequenceName = "str_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "str_info_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "natural_id")
	@JsonIgnore
	private StrNatural natural;

	@ManyToOne
	@JoinColumn(name = "legal_id")
	@JsonIgnore
	private StrLegal legal;

	@JsonProperty("branch_sol_id")
	@Column(name = "branch_sol_id")
	private String branchSolId;

	@JsonProperty("account_type")
	@Column(name = "acount_type")
	private String accountType;

	@JsonProperty("trans_date")
	@Column(name = "trans_date")
	private String transDate;


	@Column(name = "city_code")
	@JsonProperty("city_code")
	private String cityCode;

	@Column(name = "trans_id")
	@JsonProperty("trans_id")
	private String transId;

	@Column(name = "kyc_id")
	@JsonProperty("kyc_id")
	private String kycId;

	@JsonProperty("account_no")
	@Column(name = "account_no")
	private String accountNo;

	@Column(name = "rate_code")
	@JsonProperty("rate_code")
	private String rateCode;

	@Column(name = "currency_code")
	@JsonProperty("currency_code")
	private String currencyCode;

	@Column(name = "extra_cheque_no")
	@JsonProperty("extra_cheque_no")
	private String extraChequeNo;

	@Column(name = "account_type_type")
	@JsonProperty("account_type_type")
	private String accountTypeType;

	@Column(name = "entered_by")
	@JsonProperty("entered_by")
	private String enteredBy;

	@Column(name = "trans_detail")
	@JsonProperty("trans_detail")
	private String transDetail;


	@JsonProperty("local_currency_amount")
	@Column(name = "local_currency_amount")
	private Double localCurrencyAmount;


	@JsonProperty("notice")
	private String notice;

	@JsonProperty("amount")
	private Double amount;

	@JsonProperty("trans_instrument")
	@Column(name = "trans_instrument")
	private String transInstrument;

	@JsonProperty("cheque_no")
	@Column(name = "cheque_no")
	private String chequeNo;

	@Column(name = "trans_category")
	@JsonProperty("trans_category")
	private String transCategory;

	@Column(name = "trans_source")
	@JsonProperty("trans_source")
	private String transSource;

	@JsonProperty("trans_currency_code")
	@Column(name = "trans_currency_code")
	private String transCurrencyCode;

	@JsonProperty("abbs_code")
	@Column(name = "abbs_code")
	private String abbsCode;

	@Column(name = "cust_code")
	@JsonProperty("cust_code")
	private String custCode;

	@JsonProperty("trans_sub_category")
	@Column(name = "trans_sub_category")
	private String transSubCategory;

	@Column(name = "approved_by")
	@JsonProperty("approved_by")
	private String approvedBy;

	@Column(name = "source_of_fund")
	@JsonProperty("source_of_fund")
	private String sourceOfFund;

	@Column(name = "reference_no")
	@JsonProperty("reference_no")
	private String referenceNo;

	@Column(name = "sequence_no")
	@JsonProperty("sequence_no")
	private String sequenceNo;

	@JsonProperty("status")
	private String status;

	@Override
	public String toString() {
		return "StrInfo [id=" + id + ", branchSolId=" + branchSolId + ", accountType=" + accountType + ", transDate="
				+ transDate + ", cityCode=" + cityCode + ", transId=" + transId + ", kycId=" + kycId + ", accountNo="
				+ accountNo + ", rateCode=" + rateCode + ", currencyCode=" + currencyCode + ", extraChequeNo="
				+ extraChequeNo + ", accountTypeType=" + accountTypeType + ", enteredBy=" + enteredBy + ", transDetail="
				+ transDetail + ", localCurrencyAmount=" + localCurrencyAmount + ", notice=" + notice + ", amount="
				+ amount + ", transInstrument=" + transInstrument + ", chequeNo=" + chequeNo + ", transCategory="
				+ transCategory + ", transSource=" + transSource + ", transCurrencyCode=" + transCurrencyCode
				+ ", abbsCode=" + abbsCode + ", custCode=" + custCode + ", transSubCategory=" + transSubCategory
				+ ", approvedBy=" + approvedBy + ", sourceOfFund=" + sourceOfFund + ", referenceNo=" + referenceNo
				+ ", sequenceNo=" + sequenceNo + ", status=" + status + "]";
	}

	
	

	
}
