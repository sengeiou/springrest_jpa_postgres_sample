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
@Table(name="family_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FamilyInfo {


	@Id
	@SequenceGenerator(name="adverse_media_family_info_id_seq", sequenceName= "adverse_media_family_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "adverse_media_family_info_id_seq")
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

	
	@JsonProperty("first_name")
	@Column(name="first_name")
	private String firstName;

	@JsonProperty("middle_name")
	@Column(name="middle_name")
	private String middleName;

	@JsonProperty("last_name")
	@Column(name="last_name")
	private String lastName;

	@JsonProperty("lsf_name")
	@Column(name="lsf_name")
	private String lsfName;

	@JsonProperty("lsm_name")
	@Column(name="lsm_name")
	private String lsmName;

	@JsonProperty("lsl_name")
	@Column(name="lsl_name")
	private String lslName;

	@JsonProperty("second_name")
	@Column(name="second_name")
	private String secondName;

	@JsonProperty("called_by_name")
	@Column(name="called_by_name")
	private String calledByName;

	@JsonProperty("relationship")
	private String relationshipTo;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("primary_identification_document_no")
	@Column(name="primary_identification_document_no")
	private String primaryIdentificationDocumentNo;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "AdverseFamilyInfo [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", lsfName=" + lsfName + ", lsmName=" + lsmName + ", lslName=" + lslName + ", secondName="
				+ secondName + ", calledByName=" + calledByName + ", relationshipTo=" + relationshipTo + ", notes="
				+ notes + ", primaryIdentificationDocumentNo=" + primaryIdentificationDocumentNo + ", change=" + change
				+ "]";
	}

	

}
