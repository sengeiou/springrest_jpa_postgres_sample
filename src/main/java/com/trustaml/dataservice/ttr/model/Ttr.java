package com.trustaml.dataservice.ttr.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ttr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ttr {

	@Id
	@SequenceGenerator(name = "ttr_id_seq", sequenceName = "ttr_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ttr_id_seq")
	private Long id;

	private String datatype;

	@ManyToOne
	@JoinColumn(name="ttr_base_id")
	@JsonIgnore
	private TtrBase ttrBase;
	
	@OneToOne(mappedBy= "ttr", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private TtrNatural natural;

	@OneToOne(mappedBy= "ttr", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private TtrLegal legal;

	@Override
	public String toString() {
		return "Ttr [id=" + id + ", datatype=" + datatype + ", natural=" + natural + ", legal=" + legal + "]";
	}
	
	
}
