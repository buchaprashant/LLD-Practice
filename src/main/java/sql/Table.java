package sql;

import java.util.List;
import java.util.stream.Collectors;

public class Table {
    final int       id;
    String          name;
    List<Column<?>> columns;
    List<Record>    records;

    @Override
    public String toString() {
        return "Table [id=" + id
                + ", name="
                + name
                + ", columns="
                + columns.stream().map(e -> e.getName()).collect(Collectors.joining(","))
                + "]";
    }

    public Table(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column<?>> getColumns() {
        return columns;
    }

    public void setColumns(List<Column<?>> columns) {
        this.columns = columns;
    }

    public List<Record> getRecords() {
        return records;
    }

    // inserts records after checking all the constraints of all the columns
    public void setRecords(List<Record> records) {
        for (Record currRecord : records) {
            for (Column<?> col : columns) {
                for (IConstraint constraint : col.getColumnConstraints()) {
                    if (!(constraint.validate(currRecord.getTuples().get(col.getName()))
                            && col.getTypeConstraints().validate(currRecord.getTuples().get(col.getName())))) {
                        return;
                    }
                }
            }
            records.add(currRecord);
        }
    }

    public void addRecord(Record record) {
        for (Column<?> col : columns) {
            for (IConstraint constraint : col.getColumnConstraints()) {
                if (!(constraint.validate(record.getTuples().get(col.getName()))
                        && col.getTypeConstraints().validate(record.getTuples().get(col.getName())))) {
                    return;
                }
            }
            records.add(record);
        }
    }

}
