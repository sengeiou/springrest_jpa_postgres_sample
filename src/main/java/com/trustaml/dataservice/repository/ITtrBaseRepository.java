package com.trustaml.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustaml.dataservice.ttr.model.TtrBase;

public interface ITtrBaseRepository extends JpaRepository<TtrBase, Long>{

}
