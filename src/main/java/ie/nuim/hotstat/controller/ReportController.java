package ie.nuim.hotstat.controller;

import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {
    
    @Autowired
    ReportService reportService;
    
    @RequestMapping(value = "/report/generate", method=RequestMethod.GET)
    public String generateReport(Model model) {
        Report report = new Report();
        report.setId(1);
        reportService.populateReport(report);
        return "index";
    }
}
