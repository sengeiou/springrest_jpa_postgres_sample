package com.trustaml.dataservice.kyc.kycn.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "kycn_base")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycnBase {
	@Id
	@SequenceGenerator(name = "kycn_base_id_seq", sequenceName = "kycn_base_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycn_base_id_seq")
	private Long id;

	@OneToOne(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("personal_info")
	private KycnPersonalInfo kycnPersonalInfo;

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("accounts_info")
	private Set<KycnAccountsInfo> kycnAccountsInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("address_info")
	private Set<KycnAddressInfo> kycnAddressInfo = new HashSet<>();

	@JsonProperty("education_info")
	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<KycnEducationInfo> kycnEducationInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("financial_info")
	private Set<KycnFinancialInfo> kycnFinancialInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("identification_info")
	private Set<KycnIdentificationInfo> kycnIdentificationInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("involvement_info")
	private Set<KycnInvolvementInfo> kycnInvolvementInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("internal_observation_info")
	private Set<KycnObservationInfo> kycnObservationInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("related_entity_info")
	private Set<KycnRelatedEntityInfo> kycnRelatedEntityInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("related_person_info")
	private Set<KycnRelatedPersonInfo> kycnRelatedPersonInfo = new HashSet<>();

	@OneToMany(mappedBy = "kycnBase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonProperty("relation_info")
	private Set<KycnRelationInfo> kycnRelationInfo = new HashSet<>();

	@Column(name = "is_updated")
	@JsonProperty("is_updated")
	private boolean isUpdated;

	@Column(name = "maker")
	private String maker;

	@Column(name = "checker")
	private String checker;

	@Column(name = "approved")
	private boolean approved;

	@Column(name = "update_Date")
	@JsonProperty("update_Date")
	private Date updateDate;

	@Column(name = "approved_Date")
	@JsonProperty("approved_Date")
	private Date approvedDate;

	@Column(name = "reason")
	private String reason;

	@JsonProperty("search_text")
	@Column(name = "search_text")
	private String searchText;

	@Override
	public String toString() {
		return "KycnBase [id=" + id + ", kycnPersonalInfo=" + kycnPersonalInfo + ", kycnAccountsInfo="
				+ kycnAccountsInfo + ", kycnAddressInfo=" + kycnAddressInfo + ", kycnEducationInfo=" + kycnEducationInfo
				+ ", kycnFinancialInfo=" + kycnFinancialInfo + ", kycnIdentificationInfo=" + kycnIdentificationInfo
				+ ", kycnInvolvementInfo=" + kycnInvolvementInfo + ", kycnObservationInfo=" + kycnObservationInfo
				+ ", kycnRelatedEntityInfo=" + kycnRelatedEntityInfo + ", kycnRelatedPersonInfo="
				+ kycnRelatedPersonInfo + ", kycnRelationInfo=" + kycnRelationInfo + ", isUpdated=" + isUpdated
				+ ", maker=" + maker + ", checker=" + checker + ", approved=" + approved + ", updateDate=" + updateDate
				+ ", approvedDate=" + approvedDate + ", reason=" + reason + ", searchText=" + searchText + "]";
	}

}
