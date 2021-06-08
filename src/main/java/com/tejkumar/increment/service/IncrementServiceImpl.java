package com.tejkumar.increment.service;


import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tejkumar.increment.entity.Number;
import com.tejkumar.increment.repository.IncrementRepository;





@Service
public class IncrementServiceImpl implements IncrementService {
	
	Logger logger = LoggerFactory.getLogger(IncrementServiceImpl.class);
	
	@Autowired(required = false)
	IncrementRepository incrementRepository;
	
	@Override
	public void incrementCounter(Long id) {
		try {
			Optional<Number> optionalNumber = incrementRepository.findById(id);
			if (optionalNumber.isPresent()) {
				Number number = optionalNumber.get();
				int updatedCount = number.getCounter() + 1;
				number.setCounter(updatedCount);
				incrementRepository.save(number);
			}
		} catch (Exception e) {
			logger.error("Exception occurred while incrementing counter", e);
			throw e;
		}

	}

	@Override
	public void setInitialValue(Long id) {
		try {
			boolean isAlreadyExist = incrementRepository.existsById(id);
			if(!isAlreadyExist) {
				Number number = new Number();
				number.setId(id);
				incrementRepository.save(number);
			} else {
				logger.info("Number already exist with the id " + id);
			}
		} catch (Exception e) {
			logger.error("Exception occurred while setting the initial value of number", e);
			throw e;
		}
		
	}
		
}
