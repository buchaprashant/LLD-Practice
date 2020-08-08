package sql;

import java.util.Map;

public class Record {
    Map<String, String> tuples;

    public Map<String, String> getTuples() {
        return tuples;
    }

    public void setTuples(Map<String, String> tuples) {
        this.tuples = tuples;
    }

    public void addTuple(String column, String value) {
        tuples.put(column, value);
    }
}
