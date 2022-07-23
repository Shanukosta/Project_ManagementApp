package com.pma.repository;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pma.entity.Project;

//@ContextConfiguration(classes=ProjectManagementApplication.class)
@SpringBootTest
@RunWith(SpringRunner.class)
//@DataJpaTest
//@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
//			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"})})
public class ProjectRepositoryIntegrationTest {

	@Autowired
	IProjectRepository proRepo;
	
	@Test
	public void ifProjectSaved_thenSuccess() {
		Project newProject = new Project("Walmart", "COMPLETE", "Sell Products over the world");
		proRepo.save(newProject);
		
		assertEquals(1, proRepo.findAll().size());
	}
}
