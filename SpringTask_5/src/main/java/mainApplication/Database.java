package mainApplication;

import java.sql.*;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "venyaka";
    private static String text;
//    public static int mode;
    public Database(String text) {
        this.text = text;
//        this.mode = mode;
    }

//    public static void main(String[] args) {
    public void run(int mode) {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            createTable(connection);

            if (mode == 0) {
                System.out.println("mode 0");

//                    if (title != null && ! title.equals("")) {
                addRecord(connection, text);
                System.out.println("Done!");
            }else if (mode == 1) {
                System.out.println("mode 1");

                System.out.println(searchRecord(connection, text));

            } else {
                System.out.println("exit");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS items (TITLE TEXT)";
        try (Statement statement = connection.createStatement();) {
            statement.execute(query);
        }
    }

    public static void addRecord(Connection connection, String title) throws SQLException {
        String query = "INSERT INTO items (title) VALUES (?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
        }
    }

    public static String searchRecord(Connection connection, String title) throws SQLException {
//        String query = "INSERT INTO items (title) VALUES (?);";
        String query = "SELECT * FROM items WHERE title LIKE ?";
        if (title != null && ! title.equals("")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + title + "%");

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        return resultSet.getString("title");
                    }
                }
            }
        }
        return "Записи с такким текстом не найдены";
    }
}
