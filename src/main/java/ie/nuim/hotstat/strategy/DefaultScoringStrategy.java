package ie.nuim.hotstat.strategy;

import ie.nuim.hotstat.dao.MeasureDao;
import ie.nuim.hotstat.entity.Measure;
import ie.nuim.hotstat.entity.Report;
import ie.nuim.hotstat.entity.ScalarResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("iqrStrategy")
public class DefaultScoringStrategy implements ScoringStrategy {
    
    @Autowired
    MeasureDao measureDao;
    
    @Override
    public void calculateScore(Report report) {
        for(Measure measure:report.getProfile().getMeasures()) {
            // we only calculate score on scalar measures
            if(!measure.isComposite()) {
                ScalarResult result = ((ScalarResult) measure.getResult()); 
                double scaledValue = result.getValue() / report.getProject().getScale();
                result.setScaledValue(scaledValue);
                
                // save result to our database
//              measureDao.addScaledResult(report.getProject().getId(), measure.getId(), scaledValue);
                
                // calculate score
                List<Double> previousResultsList = measureDao.getScaledResults(measure.getId());
                double[] previousResults = previousResultsList.stream().mapToDouble(i->i).toArray();
                
                double score = calculateIQR(scaledValue, previousResults);
                result.setScore(score);
            }
        }
    }
    
    public double calculateIQR(double targetValue, double[] refrenceValues) {
        targetValue*=10000;
        System.out.println("calling calculator with val="+targetValue);
        for(int i=0;i<refrenceValues.length;i++) {
            refrenceValues[i] = refrenceValues[i] * 10000;
            System.out.println(refrenceValues[i]);
        }
        //Getting IQR
//        DescriptiveStatistics da = new DescriptiveStatistics(refrenceValues);
//        double IQR = da.getPercentile(75) - da.getPercentile(25);
//        //Detecting Upper outliers
//        double upperOutlierThreshold= da.getPercentile(75)+ 1.5 * IQR ;
//        //Detecting Lower outliers
//        double loweOutlierThreshold=da.getPercentile(75)- 1.5 * IQR ;
//        
//        //Removing outliers and Getting good the enhanced Array
//        ArrayList<Double> goodRefValues=new ArrayList<Double>();
//        
//        for (int i = 0; i < refrenceValues.length; i++) {
//            if ((refrenceValues[i]>upperOutlierThreshold)||(refrenceValues[i]<loweOutlierThreshold))
//                continue;
//            else
//                goodRefValues.add(refrenceValues[i]);
//        }
//        
//        double scaledDownNumber=(MAX_SCORE-MIN_SCORE)*(targetValue-Collections.min(goodRefValues))
//                /(Collections.max(goodRefValues) - Collections.min(goodRefValues)) + MIN_SCORE;
//
//        DecimalFormat df=new DecimalFormat("##.##");
//        System.out.println("core is: "+df.format(scaledDownNumber));
//        return scaledDownNumber;
        return 0.0;
    }

}
