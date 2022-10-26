package com.example.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persistence.domain.MediaType;

public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {

}

