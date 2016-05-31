package ie.nuim.hotstat.entity;

public class ScalarResult implements Result {
    
    double value;
    
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
    
}
