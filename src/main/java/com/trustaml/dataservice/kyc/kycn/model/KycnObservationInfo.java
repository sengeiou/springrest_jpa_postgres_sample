package com.trustaml.dataservice.kyc.kycn.model;

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
@Table(name="kycn_observation_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnObservationInfo {

	@Id
	@SequenceGenerator(name="kycn_observation_info_id_seq", sequenceName = "kycn_observation_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "kycn_observation_info_id_seq")
	private Long id;
	

	@ManyToOne
	@JoinColumn(name="kycn_base_id")
	@JsonIgnore
	private KycnBase kycnBase;
	
	@JsonProperty("observation_type")
	@Column(name="observation_type")
	private String observationType;

	@JsonProperty("internal_observation_physical")
	@Column(name="internal_observation_physical")
	private String internalObservationPhysical;

	@JsonProperty("internal_observation_financial")
	@Column(name="internal_observation_financial")
	private String internalObservationFinancial;

	@JsonProperty("internal_observation_behavioural")
	@Column(name="internal_observation_behavioural")
	private String internalObservationBehavioral;

	@JsonProperty("connected_person")
	@Column(name="connected_person")
	private String internalObservationConnectedPerson;

	@JsonProperty("connected_person_id")
	@Column(name="connected_person_id")
	private String connectedPersonId;

	@JsonProperty("intended_objective_of_business_relation")
	@Column(name="intended_objective_of_business_relation")
	private String internalObservationIntendedObjectiveOfBusinessRelation;

	@JsonProperty("observation_media_source")
	@Column(name="observation_media_source")
	private String observationMediaSource;

	@JsonProperty("observation_date")
	@Column(name="observation_date")
	private java.sql.Date observationDate;

	@JsonProperty("hour_of_day")
	@Column(name="hour_of_day")
	private String observationTime;

	@JsonProperty("notes")
	@Column(name="notes")
	private String notes;

	@JsonProperty("change")
	@Column(name="change")
	private boolean change;

	@Override
	public String toString() {
		return "KycnObservationInfo [id=" + id + ", observationType=" + observationType
				+ ", internalObservationPhysical=" + internalObservationPhysical + ", internalObservationFinancial="
				+ internalObservationFinancial + ", internalObservationBehavioral=" + internalObservationBehavioral
				+ ", internalObservationConnectedPerson=" + internalObservationConnectedPerson + ", connectedPersonId="
				+ connectedPersonId + ", internalObservationIntendedObjectiveOfBusinessRelation="
				+ internalObservationIntendedObjectiveOfBusinessRelation + ", observationMediaSource="
				+ observationMediaSource + ", observationDate=" + observationDate + ", observationTime="
				+ observationTime + ", notes=" + notes + ", change=" + change + "]";
	}
	
	

	
}
