package com.trustaml.dataservice.kyc.kycl.model;

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
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name="kycl_registration_address_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegistrationAddress {

	@Id
	@SequenceGenerator(name = "kycl_registration_address_id_seq",sequenceName = "kycl_registration_address_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_registration_address_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="kycl_id")
	@JsonIgnore
	private Kycl kycl;
	
	@JsonProperty("country")
	String country;

	@JsonProperty("state")
	String state;

	@JsonProperty("province")
	String province;

	@JsonProperty("district")
	String district;

	@JsonProperty("mn_vdc")
	@Column(name="mn_vdc")
	String mnVdc;

	@JsonProperty("ward_no")
	@Column(name="ward_no")
	String wardNo;

	@JsonProperty("town_city")
	@Column(name="town_city")
	String townCity;

	@JsonProperty("notes")
	String notes;

	@JsonProperty("phone_no_country_code")
	@Column(name="phone_no_country_code")
	String phoneNoCountryCode;

	@JsonProperty("phone_no_area_code")
	@Column(name="phone_no_area_code")
	String phoneNoAreaCode;

	@JsonProperty("phone_no")
	@Column(name = "phone_no")
	String phoneNo;

	@JsonProperty("telex_no_country_code")
	@Column(name="telex_no_country_code")
	String telexNoCountryCode;

	@JsonProperty("telex_no_area_code")
	@Column(name="telex_no_area_code")
	String telexNoAreaCode;

	@JsonProperty("telex_no")
	@Column(name="telex_no")
	String telexNo;

	@JsonProperty("pager_no_country_code")
	@Column(name= "pager_no_country_code")
	String pagerNoCountryCode;

	@JsonProperty("pager_no_area_code")
	@Column(name = "pager_no_area_code")
	String pagerNoAreaCode;

	@JsonProperty("pager_no")
	@Column(name="pager_no")
	String pagerNo;

	@JsonProperty("email_id")
	@Column(name="email_id")
	String emailId;


	@JsonProperty("change")
	boolean change;


	@Override
	public String toString() {
		return "RegistrationAddress [id=" + id + ", country=" + country + ", state=" + state + ", province=" + province
				+ ", district=" + district + ", mnVdc=" + mnVdc + ", wardNo=" + wardNo + ", townCity=" + townCity
				+ ", notes=" + notes + ", phoneNoCountryCode=" + phoneNoCountryCode + ", phoneNoAreaCode="
				+ phoneNoAreaCode + ", phoneNo=" + phoneNo + ", telexNoCountryCode=" + telexNoCountryCode
				+ ", telexNoAreaCode=" + telexNoAreaCode + ", telexNo=" + telexNo + ", pagerNoCountryCode="
				+ pagerNoCountryCode + ", pagerNoAreaCode=" + pagerNoAreaCode + ", pagerNo=" + pagerNo + ", emailId="
				+ emailId + ", change=" + change + "]";
	}
	
	
	


}
