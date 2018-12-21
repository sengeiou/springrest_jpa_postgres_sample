package com.trustaml.dataservice.kyc.kycn.model;

import java.sql.Date;

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
@Table(name = "kycn_education_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnEducationInfo {
	@Id
	@SequenceGenerator(name = "kycn_education_info_id_seq", sequenceName = "kycn_education_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycn_education_info_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;

	@JsonProperty("qualification")
	@Column(name = "qualification")
	private String qualification;

	@Column(name = "name_of_institute")
	@JsonProperty("name_of_institute")
	private String nameOfInstitute;

	@JsonProperty("field_of_study")
	@Column(name = "field_of_study")
	private String fieldOfStudy;

	@JsonProperty("year_of_graduation")
	@Column(name = "year_of_graduation")
	private String yearOfGraduation;

	@JsonProperty("notes")
	@Column(name = "notes")
	private String notes;

	@JsonProperty("change")
	@Column(name = "change")
	private boolean change;

	@Column(name = "maker")
	private String maker;

	@Column(name = "checker")
	private String checker;

	@Column(name = "approved")
	private boolean approved;

	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "approvedDate")
	private Date approvedDate;

	@Column(name = "reason")
	private String reason;

	@Override
	public String toString() {
		return "KycnEducationInfo [id=" + id + ", qualification=" + qualification + ", nameOfInstitute="
				+ nameOfInstitute + ", fieldOfStudy=" + fieldOfStudy + ", yearOfGraduation=" + yearOfGraduation
				+ ", notes=" + notes + ", change=" + change + ", maker=" + maker + ", checker=" + checker
				+ ", approved=" + approved + ", updateDate=" + updateDate + ", approvedDate=" + approvedDate
				+ ", reason=" + reason + "]";
	}

}