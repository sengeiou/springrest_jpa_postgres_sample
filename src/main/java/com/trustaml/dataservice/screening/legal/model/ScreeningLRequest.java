package com.trustaml.dataservice.screening.legal.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import com.trustaml.dataservice.screening.natural.model.RequestRelatedEntityRequestData;
import com.trustaml.dataservice.screening.natural.model.ScreeningRelatedRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "screening_l_request")
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreeningLRequest implements Serializable {

	private static final long serialVersionUID = -8607418092110776545L;

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "screening_l_id_seq", sequenceName = "screening_l_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_l_id_seq")
	private Long id;
	
	@OneToOne(mappedBy="screeningLRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("screening_l_request_data")
	private ScreeningLRequestData screeningLRequestData;
	

	@JsonProperty("screening_l_related_person")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "legal_related", joinColumns = @JoinColumn(name = "legal_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "related_id", referencedColumnName = "id"))
	private Set<ScreeningRelatedRequest> listOfRelated = new HashSet<>();

	@JsonProperty("screening_l_attachment")
	@OneToMany(mappedBy = "screeningLRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningAttachment> attachment = new HashSet<>();

	@JsonProperty("screening_match_info")
	@OneToMany(mappedBy = "screeningLRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningMatchInfo> screeningLMatchInfo = new HashSet<>();

	@JsonProperty("screening_l_related_entity")
	@OneToMany(mappedBy = "screeningLRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RequestRelatedEntityRequestData> relatedEntityRequestData = new HashSet<>();

	@JsonProperty("screening_l_action")
	@OneToMany(mappedBy = "screeningLRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ScreeningAction> screeningLAction = new HashSet<>();

	private boolean updated;

}
