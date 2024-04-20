package com.construction.cmsfresher.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.construction.cmsfresher.model.CmsConstructionDiary;

public interface IConstructionDiaryRepository extends JpaRepository<CmsConstructionDiary, Integer> {
	@Query(value = "select * from cms_construction_diaries order by diaryid desc", nativeQuery = true)
	public List<CmsConstructionDiary> findAllCmsConstructionDiaryOrderByDesc();

	@Query(value = "select p from CmsConstructionDiary p where p.cmsPlanTask.cmsPlan.mdConstructionSite.constructionsiteid = ?1 or p.diaryid = ?2 ")
	public List<CmsConstructionDiary> findAllCmsConstructionDiaryDTOFromConstructionId(
			Optional<Integer> constructionsiteid, Optional<Integer> diaryid);

	@Query(value = "SELECT DISTINCT cd.*\r\n"
			+ "FROM cms_construction_diaries cd\r\n"
			+ "JOIN cms_plan_tasks pt ON cd.plantaskid = pt.plantaskid\r\n"
			+ "JOIN cms_plans p ON pt.planid = p.planid\r\n"
			+ "JOIN md_construction_sites cs ON p.constructionsiteid = cs.constructionsiteid\r\n"
			+ "JOIN cms_diary_histories h ON cd.diaryid = h.diaryid\r\n"
			+ "JOIN cms_diary_actions a ON h.diaryactionid = a.diaryactionid\r\n"
			+ "WHERE\r\n"
			+ "    (\r\n"
			+ "        (cs.constructionsiteid = ?1 AND cd.diarystateid = ?2)\r\n"
			+ "        OR cd.diarystateid = ?3\r\n"
			+ "        OR cd.diaryid = ?4\r\n"
			+ "    )\r\n"
			+ "ORDER BY cd.dateofdiary DESC;", nativeQuery = true)
	public List<CmsConstructionDiary> findAllCmsConstructionDiaryByDate(Optional<Integer> constructionsiteid,
			Optional<Integer> id1, Optional<Integer> id2, Optional<Integer> diaryid);

	@Modifying
	@Query(value = "CALL insert_diary(:id);", nativeQuery = true)
	public int createDiaryCode(@Param("id") Integer id);
}
