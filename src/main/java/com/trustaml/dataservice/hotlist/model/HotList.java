package com.trustaml.dataservice.hotlist.model;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trustaml.dataservice.adversemedia.model.AddressInfo;
import com.trustaml.dataservice.adversemedia.model.Attachment;
import com.trustaml.dataservice.adversemedia.model.FamilyInfo;
import com.trustaml.dataservice.adversemedia.model.OfficeInfo;
import com.trustaml.dataservice.adversemedia.model.PersonalInfo;
import com.trustaml.dataservice.identity.model.User;
import com.trustaml.dataservice.investigation.model.InvestigationMediaInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "hot_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotList {

	@Id
	@SequenceGenerator(name = "hot_list_id_seq", sequenceName = "hot_list_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hot_list_id_seq")
	private Long id;

	@JsonProperty("personal_info")
	@OneToOne(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PersonalInfo personalInfo;

	@JsonProperty("media_info")
	@OneToMany(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Attachment> attachment = new HashSet<>();

	@JsonProperty("address_info")
	@OneToMany(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AddressInfo> hotListAddressInfo = new HashSet<>();

	@JsonProperty("office_info")
	@OneToMany(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OfficeInfo> hotListOfficeInfo = new HashSet<>();

	@JsonProperty("family_info")
	@OneToMany(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<FamilyInfo> hotListFamilyInfos = new HashSet<>();

	@JsonProperty("investigation_media_info")
	@OneToMany(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<InvestigationMediaInfo> investigationMediaInfo = new HashSet<>();

	@JsonProperty("user")
	@OneToOne(mappedBy = "hotList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	private boolean updated;

	@JsonProperty("approved_by")
	@Column(name = "approved_by")
	private String approvedBy;

	@JsonProperty("approved_date")
	@Column(name = "approved_date")
	private String approvedDate;

	@Override
	public String toString() {
		return "HotList [id=" + id + ", personalInfo=" + personalInfo + ", attachment=" + attachment
				+ ", hotListAddressInfo=" + hotListAddressInfo + ", hotListOfficeInfo=" + hotListOfficeInfo
				+ ", hotListFamilyInfos=" + hotListFamilyInfos + ", investigationMediaInfo=" + investigationMediaInfo
				+ ", user=" + user + ", updated=" + updated + ", approvedBy=" + approvedBy + ", approvedDate="
				+ approvedDate + "]";
	}

	
}
