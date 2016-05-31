package ie.nuim.hotstat.dao;

import ie.nuim.hotstat.entity.Measure;

import java.util.List;

import org.hibernate.SessionFactory;
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
    public void addMeasure(Measure newMeasure) {
        sf.getCurrentSession().save(newMeasure);
        
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


}
