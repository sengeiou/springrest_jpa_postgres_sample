package com.trustaml.dataservice.screening.common;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//class for table screening_action 

@Entity
@Audited
@Table(name = "screening_action")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningAction implements Serializable{

	
	private static final long serialVersionUID = -614266981554488026L;

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "screening_n_action_id_seq", sequenceName = "screening_n_action_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_n_action_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "screeningn_id")
	@JsonIgnore
	private ScreeningNRequest screeningNRequest;
	
	@ManyToOne
	@JoinColumn(name = "screeningl_id")
	@JsonIgnore
	private ScreeningLRequest screeningLRequest;
	
	@JsonProperty("purpose_of_screening")
	@Column(name = "purpose_of_screening")
	private String purposeOfScreening;


	@JsonProperty("reason")
	@Column(name = "reason")
	private String reason;

	@JsonProperty("action_type")
	@Column(name = "action_type")
	private String action;

	@JsonProperty("reply_date")
	@Column(name = "reply_date")
	private Date action_date;

	@JsonProperty("reply_time")
	@Column(name = "reply_time")
	private Time action_time;

	@JsonProperty("replied")
	@Column(name = "replied")
	private boolean replied;

	@JsonProperty("checker")
	@Column(name = "checker")
	private String checker;

	@Override
	public String toString() {
		return "ScreeningAction [id=" + id + ", purposeOfScreening=" + purposeOfScreening + ", reason=" + reason
				+ ", action=" + action + ", action_date=" + action_date + ", action_time=" + action_time + ", replied="
				+ replied + ", checker=" + checker + "]";
	}


}