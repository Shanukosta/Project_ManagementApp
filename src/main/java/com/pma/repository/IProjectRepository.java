package com.pma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pma.dto.ProjectStage;
import com.pma.entity.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true, value="SELECT stage as label, count(*) as StageCount "
			+ "FROM project "
			+ "GROUP BY stage")
	List<ProjectStage> getProjectStage();
}

//
//SELECT stage as label, count(*) as value 
//FROM project GROUP BY stage