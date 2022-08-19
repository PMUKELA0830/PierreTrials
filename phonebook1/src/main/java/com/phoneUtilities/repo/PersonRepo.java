package com.phoneUtilities.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phoneUtilities.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, String> {
	
	@Query(value="select * from person where phone_number = ?1", nativeQuery=true)
	Person findByPhoneNumber(String phoneNumber);
	
	@Query(value="select * from person where first_name = ?1", nativeQuery=true)
	List<Person> findByFirstName(String firstName);
	
	@Query(value="select * from person where last_name = ?1", nativeQuery=true)
	Optional<Person> findByLastName(String lastName);
	
	@Query(value="select * from person where middle_name = ?1", nativeQuery=true)
	Optional<Person> findByMiddleName(String middleName);
	
	@Query(value="select * from person where first_name = ?1 AND last_name = ?2", nativeQuery=true)
	List<Person> findByFullName(String firstName, String lastName);
	
	@Query(value="select * from person where city = ?1 OR state = ?1", nativeQuery=true)
	List<Person> findByCityOrState(String keyword);
	
	@Query(value="select * from person where first_name = ?1 OR last_name = ?1 OR"
			+ " middle_name = ?1 OR phone_number = ?1 or city = ?1 OR state = ?1", nativeQuery=true)
	List<Person> findPersonContact(String keyword);
	
	@Query(value="select first_name from person where phone_number = ?1", nativeQuery=true)
	String getFirstName(String phoneNumber);
	
	@Query(value="select middle_name from person where phone_number = ?1", nativeQuery=true)
	String getMiddleName(String phoneNumber);
	
	@Query(value="select last_name from person where phone_number = ?1", nativeQuery=true)
	String getLastName(String phoneNumber);
	
	@Query(value="select phone_number from person where phone_number = ?1", nativeQuery=true)
	String getPhoneNumber(String phoneNumber);
	
	@Query(value="select address from person where phone_number = ?1", nativeQuery=true)
	String getAddress(String phoneNumber);
	
	// The method below does not work because no SQL that change data works in Spring boot, read only is what works.
	@Query(value="UPDATE person SET  first_name = ?, middle_name = ?, last_name = ?,  phone_number = ? where phone_number = ?", nativeQuery=true)
	Optional<Person> updateContact(String firstName, 
								   String middleName, 
								   String lastName,
								   String phoneNumber,
								   String phoneNum);
	
	
	// UPDATE table_name  SET column1 = value1, column2 = value2... 	WHERE first_name = ?1;
}
