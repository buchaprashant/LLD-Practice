package sql;

import java.util.List;

public class Column<T> {
    // String type;
    Type<T>           type;
    String            name;
    List<IConstraint> columnConstraints;
    IConstraint       typeConstraint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IConstraint> getColumnConstraints() {
        return columnConstraints;
    }

    public void setColumnConstraints(List<IConstraint> columnConstraints) {
        this.columnConstraints = columnConstraints;
    }

    public Type<T> getType() {
        return type;
    }

    public void setType(Type<T> type) {
        this.type = type;
    }

    public IConstraint getTypeConstraints() {
        return typeConstraint;
    }

    public void setTypeConstraints(Type<T> type) {
        typeConstraint = new TypeConstraintFactory().getConstraint(type);
    }

    public Column(Type<T> type, String name, List<IConstraint> columnConstraints) {
        super();
        this.type = type;
        this.name = name;
        this.columnConstraints = columnConstraints;
        setTypeConstraints(type);
    }
}
