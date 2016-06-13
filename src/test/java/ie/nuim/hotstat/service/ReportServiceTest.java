package ie.nuim.hotstat.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import ie.nuim.hotstat.dao.ReportDao;
import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.strategy.LinearScoringStrategy;
import ie.nuim.hotstat.strategy.ScoringStrategy;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:test-mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReportServiceTest {
    
    
    @InjectMocks
    ReportService reportService = new ReportServiceImpl();
    
    @Mock
    ReportDao reportDao;
    
    @Mock
    ScoringStrategy scoringStrategy;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    /**
     * Tests ReportService->addReport works OK
     */
    @Test
    public void testAddReport() {
        Report report= new Report();
        // Tell Mockito what to expect
        Mockito.when(reportDao.addReport(report))
            .thenReturn(new Integer(1));
        // call the method under test
        int generatedId = reportService.addReport(report);
        // verify behavior as expected
        verify(reportDao, times(1)).addReport(report);
        assertThat(generatedId, is(1));
    }

}
