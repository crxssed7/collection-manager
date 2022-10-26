package com.example.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persistence.domain.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
