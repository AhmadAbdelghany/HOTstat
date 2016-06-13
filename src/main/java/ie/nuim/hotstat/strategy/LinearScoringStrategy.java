package ie.nuim.hotstat.strategy;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ie.nuim.hotstat.dao.MeasureDao;
import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.entity.ScalarResult;

@Component("linearStrategy")
public class LinearScoringStrategy implements ScoringStrategy {
    
    @Autowired
    MeasureDao measureDao;
    
    @Override
    public void calculateScore(Report report) {
        
        double overallScore=0.0;
        double overallWeight=0.0;
        
        for(Measure measure:report.getProfile().getMeasures()) {
            // we only calculate score on scalar measures
            if(!measure.isComposite()) {
                ScalarResult result = ((ScalarResult) measure.getResult()); 
                double scaledValue = result.getValue() / report.getProject().getScale();
                result.setScaledValue(scaledValue);
                
                // save result to our database
//                measureDao.addScaledResult(report.getProject().getId(), measure.getId(), scaledValue);
                
                // calculate score
                List<Double> previousResultsList = measureDao.getScaledResults(measure.getId());
                double max = Collections.max(previousResultsList);
                
                double score = (5/max) * scaledValue;
                result.setScore(score);
                
                double weight = measureDao.getWeight(measure.getId(), report.getProfile().getId());
                overallScore += (score * weight);
                overallWeight += weight;
                System.out.println("scaled="+scaledValue);
                System.out.println("max="+max);
                System.out.println("score="+score);
            }
        }
        overallScore = overallScore / overallWeight;
        report.setOverallScore(overallScore);
    }

}
