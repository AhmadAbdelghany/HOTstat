package ie.nuim.hotstat.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.entity.Result;
import ie.nuim.hotstat.entity.ScalarResult;

@Repository
public class ReportDaoImpl implements ReportDao {
    
    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sf;
    
    @Autowired
    @Qualifier("sessionFactory_project_1")
    SessionFactory projectSF;
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addReport(Report report) {
        // TODO Auto-generated method stub

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Report runQueries(Report report) {
        if (report.getProfile().getMeasures() != null) {
            int count = 0;
            for (Measure measure : report.getProfile().getMeasures()) {
                Query query = projectSF
                    .getCurrentSession()
                    .createSQLQuery(measure.getQuery())
                    .addScalar("value", new DoubleType())
                    .setResultTransformer(Transformers.aliasToBean(ScalarResult.class));
                    
                if (measure.getQuery().indexOf(":srid") != -1) {
                    query.setParameter("srid", report.getProject().getSrid());
                }
                ScalarResult sr = (ScalarResult) query.uniqueResult();
                measure.setResult(sr);
                System.out.println(measure.getName() + " : " + sr.getValue());
                
            }
        }
        
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Report findReportById(int id) {
        Criteria criteria = sf.getCurrentSession().createCriteria(Report.class)
                .add(Restrictions.eq("id", id));
        return (Report) criteria.uniqueResult();
        
    }

}
