package sql;

public class IntConstraint implements IConstraint {

    public boolean validate(String value) {
        try {
            int val = Integer.parseInt(value);
            return val >= -1024 && val <= 1024;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

}
