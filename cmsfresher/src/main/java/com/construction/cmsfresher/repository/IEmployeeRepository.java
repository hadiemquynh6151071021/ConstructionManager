package com.construction.cmsfresher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.construction.cmsfresher.model.MdEmployee;

public interface IEmployeeRepository extends JpaRepository<MdEmployee, Integer> {

	@Query(" SELECT e FROM MdEmployee e WHERE (e.firstname LIKE %:keyword% OR e.userid LIKE %:keyword% "
			+ "OR e.lastname LIKE %:keyword%) and e.mdEmployeePosition.employeepositionid = :labor")
	List<MdEmployee> findLaborPosition(@Param("keyword") String keyword, @Param("labor") Integer labor);

}
