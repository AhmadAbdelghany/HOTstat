package ie.nuim.hotstat.service;

import ie.nuim.hotstat.dao.MeasureDao;
import ie.nuim.hotstat.entity.Measure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MeasureServiceImpl implements MeasureService {
    
    @Autowired
    private MeasureDao measureDao;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addMeasure(Measure newMeasure) {
        measureDao.addMeasure(newMeasure);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Measure> getAllMeasures() {
        return measureDao.getAllMeasures();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Measure findMeasureById(int id) {
        return measureDao.findMeasureById(id);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMeasure(int id) {
        measureDao.deleteMeasure(id);
    }

}
