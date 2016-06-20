package ie.nuim.hotstat.controller;

import ie.nuim.hotstat.service.MeasureService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class MeasureController {
    
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MeasureController.class);
    
    @Autowired
    private MeasureService measureService;
    
    @RequestMapping(value = "/measure", method = RequestMethod.GET)
    public String getAllMeasures(Model model) {
        model.addAttribute("measures", measureService.getAllMeasures());
        return "measure/measure-list";
    }
    
    public String addMeasure() {
        return "measure/measure-list";
    }
}
