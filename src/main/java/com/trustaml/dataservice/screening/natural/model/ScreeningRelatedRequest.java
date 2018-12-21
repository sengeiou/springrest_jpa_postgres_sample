package com.trustaml.dataservice.screening.natural.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trustaml.dataservice.screening.common.ScreeningAttachment;
import com.trustaml.dataservice.screening.common.ScreeningMatchInfo;
import com.trustaml.dataservice.screening.legal.model.ScreeningLRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "screening_natural_related")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningRelatedRequest implements Serializable{


	private static final long serialVersionUID = -4889007682493532773L;

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "screening_nrelated_id_seq", sequenceName = "screening_nrelated_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_nrelated_id_seq")
	private Long id;
	
	@JsonProperty("screening_request_data")
	@OneToOne(mappedBy= "screeningRelatedRequest", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private ScreeningNRequestData screeningNRequestData;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = ScreeningNRequest.class, mappedBy = "listOfRelated")
	private Set<ScreeningNRequest> listOfNaturalRequest = new HashSet<>();

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = ScreeningLRequest.class, mappedBy = "listOfRelated")
	private Set<ScreeningLRequest> listOfLegalRequest = new HashSet<>();

	@JsonProperty("screening_attachment")
	@OneToMany(mappedBy = "screeningNRelated", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningAttachment> attachment = new HashSet<>();

	@JsonProperty("screening_match_info")
	@OneToMany(mappedBy = "screeningNRelated", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningMatchInfo> screeningNMatchInfo = new HashSet<>();

	

	
}
