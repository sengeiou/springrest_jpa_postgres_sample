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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trustaml.dataservice.hotlist.model.HotList;
import com.trustaml.dataservice.investigation.model.Investigation;
import com.trustaml.dataservice.pepentry.model.Pepentry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name="office_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class OfficeInfo {

	@Id
	@SequenceGenerator(name="adverse_media_office_info_id_seq", sequenceName= "adverse_media_office_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "adverse_media_office_info_id_seq")
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
	@JoinColumn(name="investigation_id")
	@JsonIgnore
	private Investigation investigation;
	

	@ManyToOne
	@JoinColumn(name="pepentry_id")
	@JsonIgnore
	private Pepentry pepentry;


	@JsonProperty("designation")
	private String designation;

	@JsonProperty("office_name")
	@Column(name="office_name")
	private String officeName;

	@JsonProperty("term_years")
	@Column(name="term_years")
	private long termYears;

	@JsonProperty("date_of_appointment")
	@Column(name="date_of_appointment")
	private String dateOfAppointment;

	@JsonProperty("prolongation")
	private long prolongation;

	@JsonProperty("pep_office_status")
	@Column(name="pep_office_status")
	private String pepOfficeStatus;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("elected_district")
	@Column(name="elected_district")
	private String electedDistrict;

	@JsonProperty("area_number")
	@Column(name="area_number")
	private int areaNumber;

	@JsonProperty("party_name")
	@Column(name="party_name")
	private String partyName;

	@JsonProperty("category")
	@Column(name="category")
	private String category;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "AdverseOfficeInfo [id=" + id + ", designation=" + designation + ", officeName=" + officeName
				+ ", termYears=" + termYears + ", dateOfAppointment=" + dateOfAppointment + ", prolongation="
				+ prolongation + ", pepOfficeStatus=" + pepOfficeStatus + ", notes=" + notes + ", electedDistrict="
				+ electedDistrict + ", areaNumber=" + areaNumber + ", partyName=" + partyName + ", category="
				+ category + ", change=" + change + "]";
	}

	
	
}
