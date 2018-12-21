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
@Table(name = "branch_email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchEmail {

	@Id
	@SequenceGenerator(name = "branch_email_id_seq", sequenceName = "branch_email_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_email_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	@JsonIgnore
	private DetailBranchInfo detailBranchInfo;

	@JsonProperty("email")
	private String email;

	@JsonProperty("email_type")
	@Column(name = "email_type")
	private String emailType;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "BranchEmail [id=" + id + ", email=" + email + ", emailType=" + emailType + ", change=" + change + "]";
	}

	
}
