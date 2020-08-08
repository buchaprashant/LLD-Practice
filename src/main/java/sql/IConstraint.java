package sql;

public interface IConstraint {
    boolean validate(String value);
}
