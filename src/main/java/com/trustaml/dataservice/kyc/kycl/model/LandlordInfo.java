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
@Table(name="kycl_landlord_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LandlordInfo {

	
	@Id
	@SequenceGenerator(name = "kycl_landlord_info_id_seq",sequenceName = "kycl_landlord_info_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycl_landlord_info_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="kycl_id")
	@JsonIgnore
	private Kycl kycl;
	
	@JsonProperty("land_lord_first_name")
	@Column(name="land_lord_first_name")
	private String landLordFirstName;

	@JsonProperty("land_lord_middle_name")
	@Column(name="land_lord_middle_name")
	private String landLordMiddleName;

	@JsonProperty("land_lord_last_name")
	@Column(name="land_lord_last_name")
	private String landLordLastName;

	@JsonProperty("country")
	private String country;

	@JsonProperty("province")
	private String province;

	@JsonProperty("district")
	private String district;

	@JsonProperty("mn_vdc")
	@Column(name="mn_vdc")
	private String mnVdc;

	@JsonProperty("ward_no")
	@Column(name="ward_no")
	private String wardNo;

	@JsonProperty("town_city")
	@Column(name="town_city")
	private String townCity;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("phone_no_country_code")
	@Column(name="phone_no_country_code")
	private String phoneNoCountryCode;

	@JsonProperty("phone_no_area_code")
	@Column(name= "phone_no_area_code")
	private String phoneNoAreaCode;

	@JsonProperty("phone_no")
	@Column(name="phone_no")
	private String phoneNo;

	@JsonProperty("telex_no_country_code")
	@Column(name="telex_no_country_code")
	private String telexNoCountryCode;

	@JsonProperty("telex_no_area_code")
	@Column(name="telex_no_area_code")
	private String telexNoAreaCode;

	@JsonProperty("telex_no")
	@Column(name="telex_no")
	private String telexNo;

	@JsonProperty("pager_no_country_code")
	@Column(name="pager_no_country_code")
	private String pagerNoCountryCode;

	@JsonProperty("pager_no_area_code")
	@Column(name= "pager_no_area_code")
	private String pagerNoAreaCode;

	@JsonProperty("pager_no")
	@Column(name="pager_no")
	private String pagerNo;

	@JsonProperty("email_id")
	@Column(name="email_id")
	private String emailId;
	
	@JsonProperty("zone")
	private String zone;

	@JsonProperty("change")
	boolean change;

	@Override
	public String toString() {
		return "LandlordInfo [id=" + id + ", landLordFirstName=" + landLordFirstName + ", landLordMiddleName="
				+ landLordMiddleName + ", landLordLastName=" + landLordLastName + ", country=" + country + ", province="
				+ province + ", district=" + district + ", mnVdc=" + mnVdc + ", wardNo=" + wardNo + ", townCity="
				+ townCity + ", notes=" + notes + ", phoneNoCountryCode=" + phoneNoCountryCode + ", phoneNoAreaCode="
				+ phoneNoAreaCode + ", phoneNo=" + phoneNo + ", telexNoCountryCode=" + telexNoCountryCode
				+ ", telexNoAreaCode=" + telexNoAreaCode + ", telexNo=" + telexNo + ", pagerNoCountryCode="
				+ pagerNoCountryCode + ", pagerNoAreaCode=" + pagerNoAreaCode + ", pagerNo=" + pagerNo + ", emailId="
				+ emailId + ", zone=" + zone + ", change=" + change + "]";
	}

	
	

}
