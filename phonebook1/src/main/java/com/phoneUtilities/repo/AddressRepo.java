package com.phoneUtilities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.phoneUtilities.entity.Address;
import com.phoneUtilities.entity.Person;

@Repository
public interface AddressRepo extends JpaRepository<Address, String>{
	
	@Query(value="select * from user where name = ?1", nativeQuery=true)
	List<Address> findByStreetName(String name);
	List<Address> findByCity(String name);
}
