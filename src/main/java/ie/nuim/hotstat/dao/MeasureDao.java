package ie.nuim.hotstat.dao;

import java.util.List;

import ie.nuim.hotstat.entity.Measure;

public interface MeasureDao {
    
    /**
     * adds new measure in the database
     * @param measure the new measure to add
     */
    public void addMeasure(Measure measure);
    
    /**
     * retrieve all measures from database
     * @return List<Measure> list of all measures
     */
    public List<Measure> getAllMeasures();
    
    /**
     * finds a measure by its id
     * @param <Person>
     * @param id id of the measure to find
     * @return measure
     */
    public Measure findMeasureById(int id);
    
    /**
     * deletes a measure from database
     * @param id
     */
    public void deleteMeasure(int id);
}
