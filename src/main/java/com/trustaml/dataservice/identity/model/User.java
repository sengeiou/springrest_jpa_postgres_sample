package com.trustaml.dataservice.identity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trustaml.dataservice.adversemedia.model.AdverseMedia;
import com.trustaml.dataservice.bfi.branch.model.DetailBranchInfo;
import com.trustaml.dataservice.hotlist.model.HotList;
import com.trustaml.dataservice.kyc.kycl.model.Kycl;
import com.trustaml.dataservice.kyc.kycn.model.KycnPersonalInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name="user_main")
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	@JsonProperty("id")
	@SequenceGenerator(name="kycn_user_id_seq", sequenceName= "kycn_user_id_seq", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "kycn_user_id_seq")
	private Long id;

	
	@OneToOne
	@JoinColumn(name="personal_info_id")
	@JsonIgnore
	private KycnPersonalInfo personalInfo;	
	
	@OneToOne
	@JoinColumn(name="adverse_media_id")
	@JsonIgnore
	private AdverseMedia adverseMedia;
	
	@OneToOne
	@JoinColumn(name="hot_list_id")
	@JsonIgnore
	private HotList hotList;
	
	@OneToOne
	@JoinColumn(name="detail_branch_info_id")
	@JsonIgnore
	private DetailBranchInfo detailBranchInfo;	
	
	@OneToOne
	@JoinColumn(name="kyc_id")
	@JsonIgnore
	private Kycl kycl;
	
	@JsonProperty("username")
	@Column(name="username")
	private String userName;

	@JsonProperty("password")
	@Column(name="password")
	private String password;

	@JsonProperty("sol_id")
	@Column(name="sol_id")
	private String solId;

	@JsonProperty("authenticated")
	@Column(name="authenticated")
	private boolean authenticated;

	@JsonProperty("apikey")
	@Column(name= "apikey")
	private String apikey;

	@JsonProperty("designation")
	@Column(name="designation")
	private String designation;

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", solId=" + solId
				+ ", authenticated=" + authenticated + ", apikey=" + apikey + ", designation=" + designation + "]";
	}

	

}
