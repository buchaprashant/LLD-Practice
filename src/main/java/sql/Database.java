package sql;

import java.util.List;
import java.util.stream.Collectors;

public class Database {
    String      name;
    List<Table> tables;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public Table getTable(String tableName) {
        for (Table tempTable : this.tables) {
            if (tempTable.getName().equalsIgnoreCase(tableName)) {
                return tempTable;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Database [name=" + name
                + ", tables=["
                + tables.stream().map(e -> e.getName()).collect(Collectors.joining(",")) // for
                                                                                         // better
                                                                                         // performance
                + "]";
    }

}
