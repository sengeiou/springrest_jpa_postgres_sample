package com.trustaml.dataservice.bfi.bank.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Audited
@Table(name = "bfi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bfi {

	@Id
	@SequenceGenerator(name = "bfi_id_seq", sequenceName = "bfi_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bfi_id_seq")
	private Long id;

	@OneToOne(mappedBy = "bfi", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty("bfi_info")
	private BfiInfo bfiInfo;

	@OneToMany(mappedBy = "bfi", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty("bfi_address")
	private Set<BfiAddress> bfiAddress = new HashSet<>();

	@OneToMany(mappedBy = "bfi", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty("bfi_contact")
	private Set<BfiContact> bfiContact = new HashSet<>();

	@OneToMany(mappedBy = "bfi", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty("bfi_email")
	private Set<BfiEmail> bfiEmail = new HashSet<>();

	private boolean updated;

	@Override
	public String toString() {
		return "Bfi [id=" + id + ", bfiInfo=" + bfiInfo + ", bfiAddress=" + bfiAddress + ", bfiContact=" + bfiContact
				+ ", bfiEmail=" + bfiEmail + ", updated=" + updated + "]";
	}
	
	

}
