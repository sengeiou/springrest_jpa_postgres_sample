package com.trustaml.dataservice.adversemedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustaml.dataservice.adversemedia.model.AdverseMedia;

@Repository
public interface IAdverseMediaRepository extends JpaRepository<AdverseMedia, Long>{

}
