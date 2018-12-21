package com.trustaml.dataservice.kyc.kycl.model;

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
@Table(name = "kycl_compliance_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceInfo {

	@Id
	@SequenceGenerator(name = "kycl_compliance_id_seq", sequenceName = "kycl_compliance_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_compliance_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name = "kycl_id")
	@JsonIgnore
	private Kycl kycl;

	@JsonProperty("level_of_compliance_on_aml")
	@Column(name = "level_of_compliance_on_aml")
	private String levelOfComplianceOnAml;

	@JsonProperty("level_of_compliance_on_tax")
	@Column(name = "level_of_compliance_on_tax")
	private String levelOfComplianceOnTax;

	@JsonProperty("level_of_compliance_on_corruption")
	@Column(name = "level_of_compliance_on_corruption")
	private String levelOfComplianceOnCorruption;

	@JsonProperty("level_of_compliance_on_others")
	@Column(name = "level_of_compliance_on_others")
	private String levelOfComplianceOnOthers;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("change")
	boolean change;

	@Override
	public String toString() {
		return "ComplianceInfo [id=" + id + ", levelOfComplianceOnAml=" + levelOfComplianceOnAml
				+ ", levelOfComplianceOnTax=" + levelOfComplianceOnTax + ", levelOfComplianceOnCorruption="
				+ levelOfComplianceOnCorruption + ", levelOfComplianceOnOthers=" + levelOfComplianceOnOthers
				+ ", notes=" + notes + ", change=" + change + "]";
	}
	
	

}
