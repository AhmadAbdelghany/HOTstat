package ie.nuim.hotstat.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeResult implements Result {
    
    private List<ResultEntry> resultEntries = new ArrayList<>();

    public CompositeResult(List<ResultEntry> list) {
        this.resultEntries = list;
    }

    public List<ResultEntry> getResultEntries() {
        return resultEntries;
    }

    public void setResultEntries(List<ResultEntry> resultEntries) {
        this.resultEntries = resultEntries;
    }
    
    
}
