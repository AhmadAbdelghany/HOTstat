package ie.nuim.hotstat.service;

import ie.nuim.hotstat.dao.ReportDao;
import ie.nuim.hotstat.entity.Report;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
        return reportDao.findReportById(id);
    }

    @Override
    public Report populateReport(Report report) {
        report = findReportById(report.getId());
        report = reportDao.runQueries(report);
        saveReportToFile(report);
        return report;
    }
    
    private void saveReportToFile(Report report) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            File file = new File("E:/__tools__/coding_workspace/hotstat/reports/report.json");
            if (file.createNewFile()) {
                mapper.writeValue(file, report);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
