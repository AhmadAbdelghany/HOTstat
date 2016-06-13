package ie.nuim.hotstat.controller;

import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {
    
    @Autowired
    ReportService reportService;
    
    @RequestMapping(value = "/report/{id}/generate", method=RequestMethod.GET)
    public String generateReport(@PathVariable("id") int id, Model model) {
        Report report = reportService.populateReport(id);
        model.addAttribute("report", report);
        System.out.println("rep profile id: "+report.getProfile().getId());
//        report.getProfile().getMeasures().get(0).getName();
        return "top-nav";
    }
}
