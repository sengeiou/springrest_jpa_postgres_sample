package com.trustaml.dataservice.bfi.bank.model;

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
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "bfi_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BfiInfo {

	@Id
	@SequenceGenerator(name = "bfi_info_id_seq", sequenceName = "bfi_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bfi_info_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name = "bfi_id")
	@JsonIgnore
	private Bfi bfi;

	@JsonProperty("bfi_name")
	@Column(name = "bfi_name")
	private String bfiName;

	@JsonProperty("fiu_reference_number")
	@Column(name = "fiu_reference_number")
	private String fiuReferenceNo;

	@Column(name = "bank_code")
	@JsonProperty("bank_code")
	private String bankCode;

	@Column(name = "local_currency")
	@JsonProperty("local_currency")
	private String localCurrency;

	@JsonProperty("notes")
	private String notes;

	@Column(name = "maker_id")
	@JsonProperty("maker_id")
	private int makerId;

	@Column(name = "checker_id")
	@JsonProperty("checker_id")
	private int checkerId;

	private boolean approved;
	private Date updateDate;
	private Date approvedDate;
	private String reason;
	@Override
	public String toString() {
		return "BfiInfo [id=" + id + ", bfiName=" + bfiName + ", fiuReferenceNo=" + fiuReferenceNo + ", bankCode="
				+ bankCode + ", localCurrency=" + localCurrency + ", notes=" + notes + ", makerId=" + makerId
				+ ", checkerId=" + checkerId + ", approved=" + approved + ", updateDate=" + updateDate
				+ ", approvedDate=" + approvedDate + ", reason=" + reason + "]";
	}
	
	

}