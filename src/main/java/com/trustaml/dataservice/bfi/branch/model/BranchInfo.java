package com.trustaml.dataservice.bfi.branch.model;

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
@Table(name="branch_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties
public class BranchInfo {

	@Id
	@SequenceGenerator(name="branch_info_id_seq", sequenceName= "branch_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "branch_info_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name="branch_id")
	@JsonIgnore
	private DetailBranchInfo detailBranchInfo;

	@JsonProperty("branch_name")
	@Column(name="branch_name")
	private String name;

	@JsonProperty("fiu_reference_number")
	@Column(name="fiu_reference_number")
	private String reference;

	@JsonProperty("branch_code")
	@Column(name="branch_code")
	private String solId;

	@JsonProperty("local_currency")
	@Column(name="local_currency")
	private String localCurrency;

	@JsonProperty("address_type")
	@Column(name="address_type")
	private String addressType;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("address")
	private String address;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "BranchInfo [id=" + id + ", name=" + name + ", reference=" + reference + ", solId=" + solId
				+ ", localCurrency=" + localCurrency + ", addressType=" + addressType + ", notes=" + notes
				+ ", address=" + address + ", change=" + change + "]";
	}
	
	

	
}
