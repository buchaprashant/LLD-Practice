package sql;

public class StringConstraint implements IConstraint {

    public boolean validate(String value) {
        return value.length() <= 20;
    }

}
