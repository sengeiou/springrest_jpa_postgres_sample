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
@Table(name="kycl_registration_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegistrationInfo {

	@Id
	@SequenceGenerator(name = "kycl_registration_info_id_seq",sequenceName = "kycl_registration_info_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_registration_info_id_seq")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="kycl_id")
	@JsonIgnore
	private Kycl kycl;
	
	@JsonProperty("registration_authority")
	@Column(name="registration_authority")
	String registrationAuthority;

	@JsonProperty("self_regulatory_body")
	@Column(name="self_regulatory_body")
	String selfRegulatoryBody;

	@JsonProperty("regd_number")
	@Column(name="regd_number")
	String regdNumber;

	@JsonProperty("licensing_authority")
	@Column(name= "licensing_authority")
	String licensingAuthority;

	@JsonProperty("license_number")
	@Column(name="license_number")
	String licenseNumber;

	@JsonProperty("notes")
	String notes;

	@JsonProperty("change")
	boolean change;

	@Override
	public String toString() {
		return "RegistrationInfo [id=" + id + ", registrationAuthority=" + registrationAuthority
				+ ", selfRegulatoryBody=" + selfRegulatoryBody + ", regdNumber=" + regdNumber + ", licensingAuthority="
				+ licensingAuthority + ", licenseNumber=" + licenseNumber + ", notes=" + notes + ", change=" + change
				+ "]";
	}

	

}
