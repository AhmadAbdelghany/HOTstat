package ie.nuim.hotstat.dao;

import static org.junit.Assert.*;
import ie.nuim.hotstat.entity.Profile;
import ie.nuim.hotstat.entity.Project;
import ie.nuim.hotstat.entity.Report;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Ignore
@ContextConfiguration(locations = "classpath:test-mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReportDaoTest {
    
    @Autowired
    ReportDao reportDao;
    
    static Project project;
    static Profile profile;
    
    @BeforeClass
    public static void setUp() throws Exception {
        profile = new Profile();
        profile.setId(1);
        project = new Project();
        project.setId(1);
        
    }
    

    
    @Test
    @Transactional
    @Rollback(true)
    public void testAddReport() {
        
        Report report = new Report();
        report.setProfile(profile);
        report.setProject(project);
        reportDao.addReport(report);
    }

    @Test
    public void testRunQueries() {
        
    }

    @Test
    public void testFindReportById() {
//        fail("Not yet implemented");
    }

}
