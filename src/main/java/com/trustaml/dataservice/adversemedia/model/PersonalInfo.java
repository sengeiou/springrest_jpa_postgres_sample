package com.trustaml.dataservice.adversemedia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "personal_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalInfo {

	@Id
	@SequenceGenerator(name = "adverse_media_personal_info_id_seq", sequenceName = "adverse_media_personal_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adverse_media_personal_info_id_seq")
	private Long id;

	@OneToOne
	@JoinColumn(name = "adverse_media_id")
	@JsonIgnore
	private AdverseMedia adverseMedia;
	

	@OneToOne
	@JoinColumn(name = "hot_list_id")
	@JsonIgnore
	private HotList hotList;
	
	@OneToOne
	@JoinColumn(name = "investigation_id")
	@JsonIgnore
	private Investigation investigation;
	
	@OneToOne
	@JoinColumn(name = "pepentry_id")
	@JsonIgnore
	private Pepentry pepentry;

	@JsonProperty("lsl_name")
	@Column(name = "lsl_name")
	private String lslName;

	@JsonProperty("category")
	private String category;

	@JsonProperty("lsf_name")
	@Column(name = "lsf_name")
	private String lsfName;

	private String notes;

	private String gender;

	@JsonProperty("date_of_birth")
	@Column(name = "date_of_birth")
	private String dateOfBirth;

	private String jurisdiction;

	@JsonProperty("previous_name")
	@Column(name = "previous_name")
	private String previousName;

	@JsonProperty("last_name")
	@Column(name = "last_name")
	private String lastName;

	@JsonProperty("middle_name")
	@Column(name = "middle_name")
	private String middleName;

	@JsonProperty("place_of_birth")
	@Column(name = "place_of_birth")
	private String placeOfBirth;

	private String nationality;

	@JsonProperty("called_by_name")
	@Column(name = "called_by_name")
	private String calledByName;

	@JsonProperty("country_of_birth")
	@Column(name = "country_of_birth")
	private String countryOfBirth;

	@JsonProperty("second_name")
	@Column(name = "second_name")
	private String secondName;

	private String salutation;

	@JsonProperty("first_name")
	@Column(name = "first_name")
	private String firstName;

	@JsonProperty("lsm_name")
	@Column(name = "lsm_name")
	private String lsmName;

	private boolean change;

	@JsonProperty("reference_no")
	@Column(name = "reference_no")
	private String referenceNo;

	@JsonProperty("approved_by")
	@Column(name = "approved_by")
	private String approvedBy;

	private String correspondent;

	@JsonProperty("pan_number")
	@Column(name = "pan_number")
	private String panNumber;

	@JsonProperty("citizen_number")
	@Column(name = "citizen_number")
	private String citizenNumber;

	@JsonProperty("approved_date")
	@Column(name = "approved_date")
	private String approvedDate;

	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", lslName=" + lslName + ", category=" + category + ", lsfName=" + lsfName
				+ ", notes=" + notes + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", jurisdiction="
				+ jurisdiction + ", previousName=" + previousName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", placeOfBirth=" + placeOfBirth + ", nationality=" + nationality + ", calledByName="
				+ calledByName + ", countryOfBirth=" + countryOfBirth + ", secondName=" + secondName + ", salutation="
				+ salutation + ", firstName=" + firstName + ", lsmName=" + lsmName + ", change=" + change
				+ ", referenceNo=" + referenceNo + ", approvedBy=" + approvedBy + ", correspondent=" + correspondent
				+ ", panNumber=" + panNumber + ", citizenNumber=" + citizenNumber + ", approvedDate=" + approvedDate
				+ "]";
	}

	

	
}
