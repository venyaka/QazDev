package restfulpostgre.restfulpostgre;
public class DatabaseNotFoundException extends RuntimeException {

    public DatabaseNotFoundException(String exception) {
        super(exception);
    }

}