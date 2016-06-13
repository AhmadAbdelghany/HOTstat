package ie.nuim.hotstat.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

class CalculateRange {

    

    public static void main(String[] args) {
        double[] data= new double[]{1,15,25,53,54,66,80,90,300};
        
        System.out.println("Score ="+GetRangeScore(50, data, 0, 5));

    }

    public static String GetRangeScore(double targetValue,double[] refrenceValues, double minAllowed, double maxAllowed)
    {
        
        
        //Getting IQR
        DescriptiveStatistics da = new DescriptiveStatistics(refrenceValues);
        double IQR = da.getPercentile(75) - da.getPercentile(25);
        //we can reference statistics book in this formulas
        //Detecting Upper outliers
        double upperOutlierThreshold= da.getPercentile(75)+ 1.5 * IQR ;
        //Detecting Lower outliers
        double loweOutlierThreshold=da.getPercentile(75)- 1.5 * IQR ;
        
    
        
        //Removing outliers and Getting good the enhanced Array
        ArrayList<Double> goodRefValues=new ArrayList<Double>();
        
        for (int i = 0; i < refrenceValues.length; i++) {
            if ((refrenceValues[i]>upperOutlierThreshold)||(refrenceValues[i]<loweOutlierThreshold))
                continue;
            else
                goodRefValues.add(refrenceValues[i]);
        }
        
        double scaledDownNumber=(maxAllowed-minAllowed)*(targetValue-Collections.min(goodRefValues))
                /(Collections.max(goodRefValues) - Collections.min(goodRefValues)) + minAllowed;

        DecimalFormat df=new DecimalFormat("##.##");
        return df.format(scaledDownNumber);
        
    }
}
