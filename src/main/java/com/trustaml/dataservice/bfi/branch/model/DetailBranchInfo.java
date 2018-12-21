package com.trustaml.dataservice.bfi.branch.model;

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
@Table(name="detail_branch_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DetailBranchInfo {
	
	@Id
	@SequenceGenerator(name="detail_branch_info_id_seq", sequenceName= "detail_branch_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "detail_branch_info_id_seq")
	private Long id;

	@JsonProperty("branch_info")
	@OneToOne(mappedBy="detailBranchInfo", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private BranchInfo branchInfo;

	@JsonProperty("list_address")
	@OneToMany(mappedBy = "detailBranchInfo", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<BranchAddress> listAddress = new HashSet<>();

	@JsonProperty("list_email")
	@OneToMany(mappedBy = "detailBranchInfo", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<BranchEmail> listEmail= new HashSet<>();

	@JsonProperty("list_contact")
	@OneToMany(mappedBy = "detailBranchInfo", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<BranchContact> listContact = new HashSet<>();

	@JsonProperty("user")
	@OneToOne(mappedBy = "detailBranchInfo", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private User user;

	@Column(name="updated")
	private boolean updated;

	@Override
	public String toString() {
		return "DetailBranchInfo [id=" + id + ", branchInfo=" + branchInfo + ", listAddress=" + listAddress
				+ ", listEmail=" + listEmail + ", listContact=" + listContact + ", user=" + user + ", updated="
				+ updated + "]";
	}

	
	
	

}
