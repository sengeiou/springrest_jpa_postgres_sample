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
import com.trustaml.dataservice.screening.natural.model.RequestRelatedEntityRequestData;
import com.trustaml.dataservice.screening.natural.model.ScreeningNRequest;
import com.trustaml.dataservice.screening.natural.model.ScreeningRelatedRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "screening_match_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningMatchInfo implements Serializable {

	
	private static final long serialVersionUID = 2963787952570166259L;

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "n_matchinfo_id", sequenceName = "n_matchinfo_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "n_matchinfo_id")
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

	@ManyToOne
	@JoinColumn(name = "screeningn_entity_related_id")
	@JsonIgnore
	private RequestRelatedEntityRequestData requestRelatedEntityRequestData;

	@JsonProperty("type")
	@Column(name = "type")
	private String type;

	@JsonProperty("risk")
	@Column(name = "risk")
	private int risk;

	@JsonProperty("match")
	@Column(name = "match")
	private boolean match;

	@Override
	public String toString() {
		return "ScreeningNMatchInfo [id=" + id + ", type=" + type + ", risk=" + risk + ", match=" + match + "]";
	}

}
