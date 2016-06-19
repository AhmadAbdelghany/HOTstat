package ie.nuim.hotstat.restcontroller;

import java.util.List;

import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.service.MeasureService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasureController {
    
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MeasureController.class);
    
    @Autowired
    private MeasureService measureService;
    
    @RequestMapping(value = "/measure", method = RequestMethod.GET)
    public List<Measure> getAllMeasures() {
        return measureService.getAllMeasures();
    }
    
    @RequestMapping(value = "/measure/{id}", method = RequestMethod.GET)
    public Measure getMeasure(@PathVariable("id") int id) {
        logger.error("retrieving measure with id="+id);
        return measureService.findMeasureById(id);
    }
}
