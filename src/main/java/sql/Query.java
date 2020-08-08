package sql;

public class Query {
    String      columnName; // column on which query needs to filter data via
                            // some operator
    String      value;      // value to be used along with operators like >=
                            // '5', etc
    IConstraint constraint; // constraints are operators here.. like >=, <=, =,
                            // etc

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String column) {
        this.columnName = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public IConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(IConstraint constraint) {
        this.constraint = constraint;
    }
}
