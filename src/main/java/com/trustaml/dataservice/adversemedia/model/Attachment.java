package com.trustaml.dataservice.adversemedia.model;

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
import com.trustaml.dataservice.pepentry.model.Pepentry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Audited
@Table(name="attachment_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {


	@Id
	@SequenceGenerator(name="adverse_media_attachment_info_id_seq", sequenceName= "adverse_media_attachment_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "adverse_media_attachment_info_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="adverse_media_id")
	@JsonIgnore
	private AdverseMedia adverseMedia;
	
	@ManyToOne
	@JoinColumn(name="hot_list_id")
	@JsonIgnore
	private HotList hotList;
	

	@ManyToOne
	@JoinColumn(name="pepentry_id")
	@JsonIgnore
	private Pepentry pepentry;

	@JsonProperty("source_type")
	@Column(name="source_type")
	private String sourceType;

	@JsonProperty("extension_text")
	@Column(name="extension_text")
	private String extensionText;

	@JsonProperty("media_content")
	@Column(name="media_content")
	private String mediaContent;

	@JsonProperty("source_name")
	@Column(name="source_name")
	private String sourceOfInformation;

	@JsonProperty("published_date")
	@Column(name= "published_date")
	private String publishedDate;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("media_type")
	@Column(name="media_type")
	private String mediaType;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "AdverseAttachment [id=" + id + ", sourceType=" + sourceType + ", extensionText=" + extensionText
				+ ", mediaContent=" + mediaContent + ", sourceOfInformation=" + sourceOfInformation + ", publishedDate="
				+ publishedDate + ", notes=" + notes + ", mediaType=" + mediaType + ", change=" + change + "]";
	}

	

}
