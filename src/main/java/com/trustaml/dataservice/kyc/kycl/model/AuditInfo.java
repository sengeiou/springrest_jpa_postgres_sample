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
@Table(name = "kycl_audit_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditInfo {

	@Id
	@SequenceGenerator(name = "kycl_id_seq", sequenceName = "kycl_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="kycl_id")
	@JsonIgnore
	private Kycl kycl;

	@JsonProperty("audited_report")
	@Column(name = "audited_report")
	private String auditedReport;

	@JsonProperty("authorized_letter")
	@Column(name = "authorized_letter")
	private String authorizedLetter;

	@JsonProperty("authorized_letter_date")
	@Column(name = "authorized_letter_date")
	private String authorizedLetterDate;

	@JsonProperty("authorized_letter_agency")
	@Column(name = "authorized_letter_agency")
	private String authorizedLetterAgency;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "AuditInfo [id=" + id + ", auditedReport=" + auditedReport + ", authorizedLetter=" + authorizedLetter
				+ ", authorizedLetterDate=" + authorizedLetterDate + ", authorizedLetterAgency="
				+ authorizedLetterAgency + ", notes=" + notes + ", change=" + change + "]";
	}

	
}
