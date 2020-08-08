package sql;

public class MandatoryConstraint implements IConstraint {

    public boolean validate(String value) {
        return value != null && value.length() > 0;
    }

}
