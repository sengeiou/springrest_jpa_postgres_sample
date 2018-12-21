package com.trustaml.dataservice.adversemedia.model;

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
import com.trustaml.dataservice.hotlist.model.HotList;
import com.trustaml.dataservice.investigation.model.Investigation;
import com.trustaml.dataservice.pepentry.model.Pepentry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name="address_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AddressInfo {



	@Id
	@SequenceGenerator(name="adverse_media_address_info_id_seq", sequenceName= "adverse_media_address_info_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "adverse_media_address_info_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="adverse_media_id")
	@JsonIgnore
	private AdverseMedia adverseMedia;
	
	@ManyToOne
	@JoinColumn(name="hot_list_id")
	@JsonIgnore
	private HotList hotList;
	
	@ManyToOne
	@JoinColumn(name="investigation_id")
	@JsonIgnore
	private Investigation investigation;
	

	@ManyToOne
	@JoinColumn(name="pepentry_id")
	@JsonIgnore
	private Pepentry pepentry;

	@JsonProperty("country")
	private String country;

	@JsonProperty("state")
	private String state;

	@JsonProperty("province")
	private String province;

	@JsonProperty("district")
	private String district;

	@JsonProperty("mn_vdc")
	@Column(name="mn_vdc")
	private String mnVdc;

	@JsonProperty("town_city")
	@Column(name="town_city")
	private String townCityVillage;

	@JsonProperty("tole")
	private String tole;

	@JsonProperty("street")
	private String street;

	@JsonProperty("house_number")
	@Column(name="house_number")
	private String houseNumber;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("pager_no")
	@Column(name="pager_no")
	private String pagerNo;

	@JsonProperty("phone_no_country_code")
	@Column(name = "phone_no_country_code")
	private String phoneNoCountryCode;

	@JsonProperty("telex_no_country_code")
	@Column(name="telex_no_country_code")
	private String telexNoCountryCode;

	@JsonProperty("pager_no_area_code")
	@Column(name="pager_no_area_code")
	private String pagerNoAreaCode;

	@JsonProperty("telex_no_area_code")
	@Column(name="telex_no_area_code")
	private String telexNoAreaCode;

	@JsonProperty("pager_no_country_code")
	@Column(name="pager_no_country_code")
	private String pagerNoCountryCode;

	@JsonProperty("phone_no")
	@Column(name="phone_no")
	private String phoneNo;

	@JsonProperty("telex_no")
	@Column(name="telex_no")
	private String telexNo;

	@JsonProperty("phone_no_area_code")
	@Column(name="phone_no_area_code")
	private String phoneNoAreaCode;

	@JsonProperty("contact_type")
	@Column(name="contact_type")
	private String communicationType;

	@JsonProperty("change")
	private boolean change;

	@Override
	public String toString() {
		return "AdverseAddressInfo [id=" + id + ", country=" + country + ", state=" + state + ", province=" + province
				+ ", district=" + district + ", mnVdc=" + mnVdc + ", townCityVillage=" + townCityVillage + ", tole="
				+ tole + ", street=" + street + ", houseNumber=" + houseNumber + ", notes=" + notes + ", pagerNo="
				+ pagerNo + ", phoneNoCountryCode=" + phoneNoCountryCode + ", telexNoCountryCode=" + telexNoCountryCode
				+ ", pagerNoAreaCode=" + pagerNoAreaCode + ", telexNoAreaCode=" + telexNoAreaCode
				+ ", pagerNoCountryCode=" + pagerNoCountryCode + ", phoneNo=" + phoneNo + ", telexNo=" + telexNo
				+ ", phoneNoAreaCode=" + phoneNoAreaCode + ", communicationType=" + communicationType + ", change="
				+ change + "]";
	}

}
