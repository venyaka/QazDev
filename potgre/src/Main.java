import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        CRUD.createTable();
        System.out.println("Write your title:");
        String title = in.nextLine();

        if (title != null && ! title.equals("")) {
            CRUD.addRecord(title);
        }
        in.close();
    }
}

class CRUD {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "venyaka";

    private static final String createTableSQL = "CREATE TABLE IF NOT EXISTS items (TITLE TEXT)";
    private static final String INSERT_TITLE = "INSERT INTO items (title) VALUES (?);";

    public static void createTable() {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);

             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);
            System.out.println("Table is created.");
        } catch (SQLException e) {

            // print SQL exception information
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }

    public static void addRecord(String Title) {
        System.out.println(INSERT_TITLE);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TITLE)) {
            preparedStatement.setString(1, Title);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }
}