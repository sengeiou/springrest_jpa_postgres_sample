package com.trustaml.dataservice.adversemedia.model;

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
import com.trustaml.dataservice.identity.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name="adverse_media")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AdverseMedia {

	@Id
	@SequenceGenerator(name="adverse_media_id_seq", sequenceName= "adverse_media_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "adverse_media_id_seq")
	private Long id;
	
	@JsonProperty("personal_info")
	@OneToOne(mappedBy= "adverseMedia", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private PersonalInfo personalInfo;

	@JsonProperty("media_info")
	@OneToMany(mappedBy = "adverseMedia", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<Attachment> attachment = new HashSet<>() ;

	@JsonProperty("address_info")
	@OneToMany(mappedBy = "adverseMedia", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<AddressInfo> adverseAddressInfo = new HashSet<>();

	@JsonProperty("office_info")
	@OneToMany(mappedBy = "adverseMedia", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<OfficeInfo> adverseOfficeInfo = new HashSet<>();

	@JsonProperty("family_info")
	@OneToMany(mappedBy = "adverseMedia", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private Set<FamilyInfo> adverseFamilyInfo = new HashSet<>();

	@JsonProperty("user")
	@OneToOne(mappedBy = "adverseMedia", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private User user;
	
	private boolean updated;
	
	@JsonProperty("approved_by")
	@Column(name="approved_by")
	private String approvedBy;
	
	
	@JsonProperty("approved_date")
	@Column(name="approved_date")
	private String approvedDate;


	@Override
	public String toString() {
		return "AdverseMedia [id=" + id + ", personalInfo=" + personalInfo + ", attachment=" + attachment
				+ ", adverseAddressInfo=" + adverseAddressInfo + ", adverseOfficeInfo=" + adverseOfficeInfo
				+ ", adverseFamilyInfo=" + adverseFamilyInfo + ", user=" + user + ", updated=" + updated
				+ ", approvedBy=" + approvedBy + ", approvedDate=" + approvedDate + "]";
	}
	
	
	

}
