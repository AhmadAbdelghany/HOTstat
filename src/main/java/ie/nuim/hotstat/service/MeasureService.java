package ie.nuim.hotstat.service;

import java.util.List;

import ie.nuim.hotstat.entity.Measure;

public interface MeasureService {
    
    /**
     * creates a new measure 
     * @param newMeasure
     */
    public void addMeasure(Measure newMeasure);
    
    /**
     * retrieve all measures
     * @return List<Measure> list of all measures
     */
    public List<Measure> getAllMeasures();
    
    /**
     * finds a measure by its id
     * @param int id of the measure to find
     * @return measure
     */
    public Measure findMeasureById(int id);
    
    /**
     * deletes a measure
     * @param id
     */
    public void deleteMeasure(int id); 
}
