package ie.nuim.hotstat.service;

import ie.nuim.hotstat.dao.ReportDao;
import ie.nuim.hotstat.entity.Report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    
    @Autowired
    private ReportDao reportDao;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addReport(Report newReport) {
        reportDao.addReport(newReport);
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public Report findReportById(int id) {
        return null;
    }

    @Override
    public Report populateReport(Report report) {
        report = reportDao.findReportById(report.getId());
        return reportDao.runQueries(report);
    }

}
