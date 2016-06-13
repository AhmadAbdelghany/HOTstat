package ie.nuim.hotstat.dao;

import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.entity.Report;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MeasureDaoImpl implements MeasureDao {
    
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sf;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int addMeasure(Measure newMeasure) {
        return (Integer) sf.getCurrentSession().save(newMeasure);
    }
    
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Measure> getAllMeasures() {
        List<Measure> measures = sf.getCurrentSession().createQuery("from Measure").list();
        return measures;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Measure findMeasureById(int id) {
        Measure measure =  (Measure) sf.getCurrentSession().load(Measure.class, new Integer(id));
        return measure;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMeasure(int id) {
        Measure measure = (Measure) sf.getCurrentSession().load(Measure.class, new Integer(id));
        if(null != measure){
            sf.getCurrentSession().delete(measure);
        }
    }

    /**
     * list of saved scaled result for this measure so far
     * @param measureId
     * @return list of scaled measures
     */
    @Override
    public List<Double> getScaledResults(int measureId) {
        @SuppressWarnings("unchecked")
        List<Double> sr= (List<Double>) sf.getCurrentSession()
            .createSQLQuery("Select scaled_result from project_measure where measure_id = :measureID ")
            .setParameter("measureID", measureId)
            .list();
        return sr;
    }
    
    /**
     * adds new scaled result in to db
     */
    @Override
    public void addScaledResult(int projectId, int measureId, double scaledResult) {
        Query query = sf.getCurrentSession().createSQLQuery("INSERT INTO project_measure (project_id, measure_id, scaled_result) VALUES (:projectId, :measureId, :scaledResult)");
        query.setParameter("projectId", projectId);
        query.setParameter("measureId", measureId);
        query.setParameter("scaledResult", scaledResult);
        query.executeUpdate();
    }
    
    @Override
    public double getWeight(int measureId, int profileId) {
        double weight=  ((Number)sf.getCurrentSession()
            .createSQLQuery("Select weight from profile_measure where measure_id = :measureID and profile_id = :profileID ")
            .setParameter("measureID", measureId)
            .setParameter("profileID", profileId)
            .uniqueResult()).doubleValue();
        return weight;
    }
}
