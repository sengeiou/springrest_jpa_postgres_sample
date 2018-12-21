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
@Table(name = "bfi_contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BfiContact {

	@Id
	@SequenceGenerator(name = "bfi_contact_id_seq", sequenceName = "bfi_contact_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bfi_contact_id_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "bfi_id")
	@JsonIgnore
	private Bfi bfi;

	@JsonProperty("contact_number")
	@Column(name = "contact_number")
	private String contactNumber;

	@JsonProperty("contact_country_prefix")
	@Column(name = "contact_country_prefix")
	private String contactCountryPrefix;

	@JsonProperty("contact_extension")
	@Column(name = "contact_extension")
	private String contactExtension;

	@JsonProperty("contact_communication_type")
	@Column(name = "contact_communication_type")
	private String contactCommunicationType;

	@JsonProperty("notes")
	private String notes;

	@Column(name = "maker_id")
	@JsonProperty("maker_id")
	private int makerId;

	@Column(name = "checker_id")
	@JsonProperty("checker_id")
	private int checkerId;

	private boolean approved;
	private Date updateDate;
	private Date approvedDate;
	private String reason;
	@Override
	public String toString() {
		return "BfiContact [id=" + id + ", contactNumber=" + contactNumber + ", contactCountryPrefix="
				+ contactCountryPrefix + ", contactExtension=" + contactExtension + ", contactCommunicationType="
				+ contactCommunicationType + ", notes=" + notes + ", makerId=" + makerId + ", checkerId=" + checkerId
				+ ", approved=" + approved + ", updateDate=" + updateDate + ", approvedDate=" + approvedDate
				+ ", reason=" + reason + "]";
	}

	
}
