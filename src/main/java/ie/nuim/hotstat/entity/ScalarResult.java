package ie.nuim.hotstat.entity;

public class ScalarResult implements Result {
    
    double value;
    double scaledValue;
    double score;
    
    public ScalarResult() {
    }
    
    public ScalarResult(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getScaledValue() {
        return scaledValue;
    }

    public void setScaledValue(double scaledValue) {
        this.scaledValue = scaledValue;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    
}
