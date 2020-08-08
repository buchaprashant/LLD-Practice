package sql;

public class TypeConstraintFactory {
    public <T> IConstraint getConstraint(Type<T> type) {
        String classType = type.getClass().getName();
        switch (classType.toLowerCase()) {
            case "integer":
                return new IntConstraint();
            case "string":
                return new StringConstraint();
            default:
                return null;
        }
    }
}
