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
@Table(name = "kycl_document_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentStatus {

	@Id
	@SequenceGenerator(name = "kycl_document_status_id_seq", sequenceName = "kycl_document_status_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_document_status_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="kycl_id")
	@JsonIgnore
	private Kycl kycl;

	@JsonProperty("document_type")
	@Column(name = "document_type")
	String documentType;

	@JsonProperty("document_status")
	@Column(name = "document_status")
	String documentStatus;

	@JsonProperty("application_submitted_date")
	@Column(name = "application_submitted_date")
	String applictionSubmittedDate;

	@JsonProperty("refresh_date")
	@Column(name = "refresh_date")
	String refreshDate;

	@JsonProperty("notes")
	String notes;

	@JsonProperty("change")
	boolean change;

	@Override
	public String toString() {
		return "DocumentStatus [id=" + id + ", documentType=" + documentType + ", documentStatus=" + documentStatus
				+ ", applictionSubmittedDate=" + applictionSubmittedDate + ", refreshDate=" + refreshDate + ", notes="
				+ notes + ", change=" + change + "]";
	}
	
	

}
