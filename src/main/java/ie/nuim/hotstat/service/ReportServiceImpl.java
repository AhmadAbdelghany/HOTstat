package ie.nuim.hotstat.service;

import ie.nuim.hotstat.dao.MeasureDao;
import ie.nuim.hotstat.dao.ReportDao;
import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.entity.ScalarResult;
import ie.nuim.hotstat.strategy.DefaultScoringStrategy;
import ie.nuim.hotstat.strategy.ScoringStrategy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    
    @Autowired
    private ReportDao reportDao;
    
    @Autowired
    private MeasureDao measureDao;
    
    @Autowired
    @Qualifier("linearStrategy")
    ScoringStrategy scoringStrategy;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int addReport(Report newReport) {
        return reportDao.addReport(newReport);
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public Report findReportById(int id) {
        return reportDao.findReportById(id);
    }

    @Override
    public Report populateReport(int reportId) {
        Report report = findReportById(reportId);
        reportDao.runQueries(report);
        calculateScore(report);
        saveReportToFile(report);
        return report;
    }
    
    @Override
    public void calculateScore(Report report) {
        scoringStrategy.calculateScore(report);
    }

    public void saveReportToFile(Report report) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String fileName = "E:/__tools__/coding_workspace/hotstat/reports/report_" + report.getId()+".json";
            File file = new File(fileName);
            if (file.createNewFile()) {
                mapper.writeValue(file, report);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
