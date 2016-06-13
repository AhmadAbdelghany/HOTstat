package ie.nuim.hotstat.strategy;

import ie.nuim.hotstat.entity.Report;

public interface ScoringStrategy {
    
    public static final double MIN_SCORE = 0;
    public static final double MAX_SCORE = 5;
    
    public void calculateScore(Report report);
    
}
