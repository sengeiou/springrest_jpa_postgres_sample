package com.trustaml.dataservice.investigation.model;

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
import com.trustaml.dataservice.hotlist.model.HotList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Audited
@Table(name="investigation_media_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvestigationMediaInfo {
	

	@Id
	@SequenceGenerator(name="investigation_media_info_id_seq", sequenceName= "investigation_media_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "investigation_media_info_id_seq")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="hot_list_id")
	@JsonIgnore
	private HotList hotList;
	
	@ManyToOne
	@JoinColumn(name="investigation_id")
	@JsonIgnore
	private Investigation investigation;


	@JsonProperty("photo_id_number")
	@Column(name="photo_id_number")
	private String photoIdNumber;

	@JsonProperty("photo_serial_number")
	@Column(name="photo_serial_number")
	private String photoSerialNumber;

	@JsonProperty("photo_comment")
	@Column(name="photo_comment")
	private String photoComment;

	@JsonProperty("social_media")
	@Column(name="social_media")
	private String socialMedia;

	@JsonProperty("social_media_publication_date")
	@Column(name="social_media_publication_date")
	private String socialMediaPublicationDate;

	@JsonProperty("adverse_media")
	@Column(name="adverse_media")
	private String adverseMedia;

	@JsonProperty("adverse_media_publication_date")
	@Column(name="adverse_media_publication_date")
	private String adverseMediaPublicationDate;

	@JsonProperty("date_of_entry")
	@Column(name= "date_of_entry")
	private String dateOfEntry;

	@JsonProperty("date_of_validation")
	@Column(name ="date_of_validation")
	private String dateOfValidation;

	@JsonProperty("source_of_information")
	@Column(name="source_of_information")
	private String sourceOfInformation;

	@JsonProperty("type_of_source")
	@Column(name="type_of_source")
	private String typeOfSource;

	@JsonProperty("confidence_level_of_source")
	@Column(name="confidence_level_of_source")
	private String confidenceLevelOfSource;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("change")
	private boolean isChange;

	

}
