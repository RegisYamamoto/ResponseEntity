package com.regis.responseentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.regis.responseentity.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}