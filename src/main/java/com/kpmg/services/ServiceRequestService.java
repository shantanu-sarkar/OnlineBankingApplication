package com.kpmg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.ServiceRequest;
import com.kpmg.repositories.ServiceRequestRepository;

@Service
public class ServiceRequestService {
@Autowired
ServiceRequestRepository serviceRequestRepository;
	
	public ServiceRequest createRequest(ServiceRequest serviceRequest)
	{
		ServiceRequest request = serviceRequestRepository.save(serviceRequest);
		return request;
	}

	public List<ServiceRequest> getRequests() {
		List<ServiceRequest> requests = serviceRequestRepository.findAll();
		return requests;
	}

	public ServiceRequest getRequest(int id) {
		return serviceRequestRepository.findById(id).get();
		
	}

	public void deleteRequest(int id) {
		
		serviceRequestRepository.deleteById(id);
		
	}
}
