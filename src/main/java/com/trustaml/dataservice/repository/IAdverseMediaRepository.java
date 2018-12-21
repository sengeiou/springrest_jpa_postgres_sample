package com.trustaml.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustaml.dataservice.adversemedia.model.AdverseMedia;

public interface IAdverseMediaRepository extends JpaRepository<AdverseMedia, Long>{

}
