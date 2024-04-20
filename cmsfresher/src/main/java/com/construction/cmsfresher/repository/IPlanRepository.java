package com.construction.cmsfresher.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.construction.cmsfresher.model.CmsPlan;

public interface IPlanRepository extends JpaRepository<CmsPlan, Integer> {

	@Query(value = "select * from cms_plans order by planid desc", nativeQuery = true)
	public List<CmsPlan> findAllCmsPlanOrderByDesc();

	@Query(value = "select c.* from cms_plans c, cms_plan_history h, cms_plan_actions a, md_construction_sites s\r\n"
			+ "where c.planid = h.planid and h.planactionid = a.planactionid and c.constructionsiteid = s.constructionsiteid\r\n"
			+ "and ((a.planactionid = ?1 and s.constructionsiteid = ?2) or a.planactionid = ?3 or c.planid = ?4) order by c.createddate desc", nativeQuery = true)
	public List<CmsPlan> findAllCmsPlanOrderByState(Optional<Integer> id, Optional<Integer> constructionsiteid,
			Optional<Integer> id2, Optional<Integer> planid);

	@Query(value = "with re as (select distinct cpt.*, ta.taskid, ta.taskcode, ta.taskname, qu.quantityunitname, qu.quantityunitid, wt.workitemid, wt.workitemcode, wt.workitemname, cpt.orderindex,cpw.orderindex as orderindexofworkitem , ee.lastname,ee.employeeid,ee.firstname,ee.idcard,ee.userid from cms_plan_tasks cpt, md_tasks ta, md_quantity_units qu,\r\n"
			+ "			cms_plan_workitem cpw, md_work_items wt, cms_plans pl,cms_role_employees_planworkitems emp, md_employees ee\r\n"
			+ "			where cpt.taskid = ta.taskid and qu.quantityunitid = ta.quantityunitid and cpt.workitemid = cpw.workitemid\r\n"
			+ "			and cpw.workitemid = wt.workitemid and pl.planid = cpt.planid \r\n"
			+ "			and cpw.planworkitemid = emp.planworkitemid\r\n"
			+ "			and emp.employeeid = ee.employeeid\r\n" + "			and pl.planid = ?1 )\r\n"
			+ "			select  array_to_json(array_agg(re.*)) as tasks from re", nativeQuery = true)
	public String findAllPlanTaskByPlanId(Integer id);

	@Modifying
	@Query(value = "CALL insert_plan(:id);", nativeQuery = true)
	public int createPlan(@Param("id") Integer id);
	
	@Query(value = "select count(*) as plantaskdone from cms_plans p,\r\n"
			+ "cms_plan_tasks pt, cms_construction_diaries d, cms_progresses pr, md_work_items w\r\n"
			+ "where p.planid=pt.planid and pt.plantaskid=d.plantaskid\r\n"
			+ "and d.diaryid = pr.diaryid and pt.amountofwork = pr.totalamountofworkdone\r\n"
			+ "and w.workitemid = pt.workitemid\r\n"
			+ "and p.planid = ?1",nativeQuery = true)
	public int countPlanTaskDone(Integer id);

}
