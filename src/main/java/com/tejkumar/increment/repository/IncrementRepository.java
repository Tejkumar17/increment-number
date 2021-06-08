package com.tejkumar.increment.repository;


import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.tejkumar.increment.entity.Number;




@Repository
public interface IncrementRepository extends CrudRepository<Number, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Number> findById(Long id);

	@Modifying
	@Query("update Number n set n.counter =:counter where n.id =:id")
	void updateCounter(int counter, Long id);

}
