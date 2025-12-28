package com.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {}
