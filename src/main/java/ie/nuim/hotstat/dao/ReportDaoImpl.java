package ie.nuim.hotstat.dao;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ie.nuim.hotstat.entity.CompositeResult;
import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.entity.Result;
import ie.nuim.hotstat.entity.ResultEntry;
import ie.nuim.hotstat.entity.ScalarResult;
import ie.nuim.hotstat.strategy.ScoringStrategy;

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
    public int addReport(Report report) {
        return (Integer) sf.getCurrentSession().save(report);

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Report runQueries(Report report) {
        if (report.getProfile().getMeasures() != null) {
            int count = 0;
            Result r = null;
            for (Measure measure : report.getProfile().getMeasures()) {
                if (measure.isComposite()) {
                    r = runCompositeQuery(report, measure);
                } else {
                    r = runScalarQuery(report, measure);
                }
                measure.setResult(r);
            }
        }
        return report;
    }

    @SuppressWarnings("unchecked")
    private CompositeResult runCompositeQuery(Report report, Measure measure) {
        Query query = projectSF
            .getCurrentSession()
            .createSQLQuery(measure.getQuery())
            .addScalar("category", new StringType())
            .addScalar("value", new DoubleType())
            .setResultTransformer(Transformers.aliasToBean(ResultEntry.class));
            
        if (measure.getQuery().indexOf(":srid") != -1) {
            query.setParameter("srid", report.getProject().getSrid());
        }
        return new CompositeResult(query.list());
    }
    
    private ScalarResult runScalarQuery(Report report, Measure measure) {
        Query query = projectSF
            .getCurrentSession()
            .createSQLQuery(measure.getQuery())
            .addScalar("value", new DoubleType())
            .setResultTransformer(Transformers.aliasToBean(ScalarResult.class));
            
        if (measure.getQuery().indexOf(":srid") != -1) {
            query.setParameter("srid", report.getProject().getSrid());
        }
        return (ScalarResult) query.uniqueResult();
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
