package com.trustaml.dataservice.screening.natural.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trustaml.dataservice.screening.common.ScreeningAction;
import com.trustaml.dataservice.screening.common.ScreeningAttachment;
import com.trustaml.dataservice.screening.common.ScreeningMatchInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "screening_n_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningNRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "screening_n_id_seq", sequenceName = "screening_n_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_n_id_seq")
	private Long id;
	
	@JsonProperty("screening_n_request_data")
	@OneToOne(mappedBy= "screeningNRequest", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private ScreeningNRequestData screeningNRequestData;

	@JsonProperty("screening_n_related_person")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "natural_related", joinColumns = @JoinColumn(name = "natural_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "related_id", referencedColumnName = "id"))
	private Set<ScreeningRelatedRequest> listOfRelated = new HashSet<>();

	@JsonProperty("screening_n_attachment")
	@OneToMany(mappedBy = "screeningNRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningAttachment> attachment = new HashSet<>();

	@JsonProperty("screening_match_info")
	@OneToMany(mappedBy = "screeningNRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningMatchInfo> screeningNMatchInfo = new HashSet<>();

	@JsonProperty("screening_n_related_entity")
	@OneToMany(mappedBy = "screeningNRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RequestRelatedEntityRequestData> relatedEntityRequestData = new HashSet<>();

	@JsonProperty("screening_n_action")
	@OneToMany(mappedBy = "screeningNRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningAction> screeningNAction = new HashSet<>();

	@Column(name = "is_updated")
	@JsonProperty("is_updated")
	private boolean isUpdated;

	@Column(name = "maker")
	private String maker;

	@Column(name = "checker")
	private String checker;

	@Column(name = "approved")
	private boolean approved;

	

}