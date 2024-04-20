package com.construction.cmsfresher.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.CmsPlanTask;

public interface IPlanTaskRepository extends JpaRepository<CmsPlanTask, Integer> {

	@Query(value = "select pt.*, ep.employeeid from cms_plan_tasks pt, cms_plans p, cms_plan_workitem w,\r\n"
			+ "cms_role_employees_planworkitems ep\r\n"
			+ "where pt.planid = p.planid and pt.workitemid = w.workitemid and w.planworkitemid = ep.planworkitemid\r\n"
			+ "       		and (p.constructionsiteid = ?1 or pt.plantaskid = ?2)", nativeQuery = true)
	public List<CmsPlanTask> findAllCmsPlanTaskFromConstructionSiteId(Optional<Integer> constructionid,
			Optional<Integer> plantaskid);

	// tìm giám sát trong hạng mục từ bảng role workitem
	@Query(value = "select e.employeeid from cms_plan_tasks pt, cms_plans p, cms_plan_workitem w,\r\n"
			+ "       cms_role_employees_planworkitems ep, md_employees e\r\n"
			+ "       where pt.planid = p.planid and pt.workitemid = w.workitemid and w.planworkitemid = ep.planworkitemid\r\n"
			+ "       and ep.employeeid = e.employeeid and (p.constructionsiteid = ?1 or pt.plantaskid = ?2)\r\n"
			+ "", nativeQuery = true)
	public List<Integer> findEmployee(Optional<Integer> constructionid, Optional<Integer> plantaskid);

	
	// lấy ra công việc đã hoàn thành 
//	public int countPlanTaskSuccess();
	
}
