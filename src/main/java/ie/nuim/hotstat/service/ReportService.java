package ie.nuim.hotstat.service;

import ie.nuim.hotstat.entity.Report;

public interface ReportService {
    
    /**
     * Creates a new Report 
     * @param report new report to be added
     */
    public void addReport(Report report);
    
    /**
     * finds a Report by its id
     * @param int id of the Report to find
     * @return Report
     */
    public Report findReportById(int id);
    
    /**
     * 
     * @param report
     * @return populated report
     */
    public Report populateReport(Report report);
}
