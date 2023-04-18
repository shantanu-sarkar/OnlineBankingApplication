package com.kpmg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpmg.entities.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {

}
