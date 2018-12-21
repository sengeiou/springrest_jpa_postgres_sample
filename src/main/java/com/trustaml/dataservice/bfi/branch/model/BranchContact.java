package com.trustaml.dataservice.bfi.branch.model;

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
@Table(name="branch_contact")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties
public class BranchContact {

	@Id
	@SequenceGenerator(name="branch_contact_id_seq", sequenceName= "branch_contact_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "branch_contact_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	@JsonIgnore
	private DetailBranchInfo detailBranchInfo;

	@JsonProperty("type")
	private String type;

	@JsonProperty("contact_number")
	@Column(name="contact_number")
	private String number;

	@JsonProperty("contact_country_prefix")
	@Column(name="contact_country_prefix")
	private String prefix;

	@JsonProperty("contact_extension")
	@Column(name="contact_extension")
	private String extension;

	@JsonProperty("contact_communication_type")
	@Column(name="contact_communication_type")
	private String communicationType;

	@JsonProperty("email")
	private String email;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "BranchContact [id=" + id + ", type=" + type + ", number=" + number + ", prefix=" + prefix
				+ ", extension=" + extension + ", communicationType=" + communicationType + ", email=" + email
				+ ", notes=" + notes + ", change=" + change + "]";
	}
	
	


}
