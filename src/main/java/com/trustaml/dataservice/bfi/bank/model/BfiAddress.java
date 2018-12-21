package com.trustaml.dataservice.bfi.bank.model;

import java.sql.Date;

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
@Table(name="bfi_address")
@Getter @Setter @NoArgsConstructor  @AllArgsConstructor
public class BfiAddress {
	
	@Id
	@SequenceGenerator(name ="bfi_address_id_seq",sequenceName="bfi_address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bfi_address_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="bfi_id")
	@JsonIgnore
	private Bfi bfi;
	
	@JsonProperty("address_type")
	@Column(name="address_type")
	private String addressType;

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

	@JsonProperty("town_city_village")
	@Column(name="town_city_village")
	private String townCityVillage;

	@JsonProperty("tole")
	private String tole;

	@JsonProperty("street")
	private String street;

	@JsonProperty("house_number")
	@Column(name="house_number")
	private String houseNumber;

	@JsonProperty("po_box_number")
	@Column(name="po_box_number")
	private String poBoxNumber;

	@JsonProperty("pin_zip_number")
	@Column(name="pin_zip_number")
	private String pinZipNumber;

	@JsonProperty("notes")
	private String notes;

	@Column(name="maker_id")
	@JsonProperty("maker_id")
	private int makerId;
	
	@Column(name="checker_id")
	@JsonProperty("checker_id")	
	private int checkerId;
	
	private boolean approved;
	private Date updateDate;
	private Date approvedDate;
	private String reason;
	@Override
	public String toString() {
		return "BfiAddress [id=" + id + ", addressType=" + addressType + ", country=" + country + ", state=" + state
				+ ", province=" + province + ", district=" + district + ", mnVdc=" + mnVdc + ", townCityVillage="
				+ townCityVillage + ", tole=" + tole + ", street=" + street + ", houseNumber=" + houseNumber
				+ ", poBoxNumber=" + poBoxNumber + ", pinZipNumber=" + pinZipNumber + ", notes=" + notes + ", makerId="
				+ makerId + ", checkerId=" + checkerId + ", approved=" + approved + ", updateDate=" + updateDate
				+ ", approvedDate=" + approvedDate + ", reason=" + reason + "]";
	}

	
}
