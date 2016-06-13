package ie.nuim.hotstat.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import ie.nuim.hotstat.entity.Measure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:test-mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MeasureDaoTest {
    
    @Autowired
    MeasureDao measureDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testAddMeasure() {
        Measure measure = new Measure();
        measure.setName("test measure");
        measure.setQuery("SELECT count(*) FROM planet_osm_point");
        int generatedId = measureDao.addMeasure(measure);
        Measure addedMeasure = measureDao.findMeasureById(generatedId);
        assertThat(addedMeasure.getName(), is("test measure"));
    }

    @Test
    @Transactional
    public void testGetAllMeasures() {
        assertThat(measureDao.getAllMeasures().size(), is(28));
    }

    @Test
    @Transactional
    public void testFindMeasureById() {
        Measure measure = measureDao.findMeasureById(1);
        assertNotNull(measure);
        assertThat(measure, instanceOf(Measure.class));
        assertThat(measure.getId(), is(1));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteMeasure() {
        measureDao.deleteMeasure(1);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testAddScaledResult() {
        measureDao.addScaledResult(1, 1, 1);
    }
    
    @Test
    @Transactional
    public void testGetScaledResults() {
        assertThat(measureDao.getScaledResults(24).size(), is(5));
    }
    
    @Test
    @Transactional
    public void testGetWeight() {
        assertThat(measureDao.getWeight(24, 1), is(3.0));
    }

}