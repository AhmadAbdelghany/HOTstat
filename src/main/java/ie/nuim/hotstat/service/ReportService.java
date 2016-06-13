package ie.nuim.hotstat.service;

import ie.nuim.hotstat.entity.Report;

public interface ReportService {
    
    /**
     * Creates a new Report 
     * @param report new report to be added
     */
    public int addReport(Report report);
    
    /**
     * finds a Report by its id
     * @param int id of the Report to find
     * @return Report
     */
    public Report findReportById(int id);
    
    /**
     * 
     * @param reportId
     * @return populated report
     */
    public Report populateReport(int reportId);
    
    /**
     * calculate the score for measures in this report
     * @param report The report to calculate the scores
     */
    public void calculateScore(Report report);
}
