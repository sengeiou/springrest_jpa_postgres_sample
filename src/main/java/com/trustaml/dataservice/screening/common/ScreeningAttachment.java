package com.trustaml.dataservice.screening.common;

import java.io.Serializable;

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
import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;
import com.trustaml.dataservice.screening.natural.model.ScreeningRelatedRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "screening_attachment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningAttachment implements Serializable{

	private static final long serialVersionUID = 1005053891872674233L;

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "n_attachment_seq", sequenceName = "n_attachment_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "n_attachment_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "screeningn_id")
	@JsonIgnore
	private ScreeningNRequest screeningNRequest;
	
	@ManyToOne
	@JoinColumn(name = "screeningl_id")
	@JsonIgnore
	private ScreeningLRequest screeningLRequest;

	@ManyToOne
	@JoinColumn(name = "screeningn_related_id")
	@JsonIgnore
	private ScreeningRelatedRequest screeningNRelated;

	@JsonProperty("scanned_document_type")
	@Column(name = "scanned_document_type")
	private String scannedDocumentType;

	@JsonProperty("scanned_content")
	@Column(name = "scanned_content")
	private String scannedContent;

	@JsonProperty("extension_text")
	@Column(name = "extension_text")
	private String extensionText;

	@JsonProperty("notes")
	@Column(name = "notes")
	String notes;

	@JsonProperty("action_id")
	@Column(name = "action_id")
	private String screeningActionId;

	@Override
	public String toString() {
		return "ScreeningNAttachment [id=" + id + ", scannedDocumentType=" + scannedDocumentType + ", scannedContent="
				+ scannedContent + ", extensionText=" + extensionText + ", notes=" + notes + ", screeningActionId="
				+ screeningActionId + "]";
	}

}
