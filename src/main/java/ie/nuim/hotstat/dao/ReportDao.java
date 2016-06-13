package ie.nuim.hotstat.dao;

import ie.nuim.hotstat.entity.Report;

public interface ReportDao {
    /**
     * adds a new report to the database
     * @param report the report to be added
     */
    public int addReport(Report report);
    
    /**
     * runs the queries inside that report and populate the results
     * @param report
     * @return populated report
     */
    public Report runQueries(Report report);
    
    /**
     * 
     * @param id id of the report to find
     * @return report of given id
     */
    public Report findReportById(int id);
}
