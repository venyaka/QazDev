package mainApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "venyaka";
    private static String text;
//    public Database(String text) {
//        this.text = text;
//    }

//    public void run(String text, int mode) {
//        try(Connection connection = DriverManager.getConnection(url, user, password)) {
//            createTable(connection);
//            if (mode == 0) {
//                System.out.println("mode 0");
//                addRecord(connection, text);
//                System.out.println("Done!");
//            }else if (mode == 1) {
//                System.out.println(searchRecord(connection, text));
//            } else {
//                System.out.println("exit");
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void run(String text, File file) {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            createTable(connection);
            addRecord(connection, text, file);
            System.out.println("Done!");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String text) {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            createTable(connection);
            System.out.println(searchRecord(connection, text));
            System.out.println("Done!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS items2 (title TEXT, filename TEXT, file BYTEA)";
        try (Statement statement = connection.createStatement();) {
            statement.execute(query);
        }
        System.out.println("Table is created");
    }

    public static void addRecord(Connection connection, String title, File file) throws SQLException {
        String query = "INSERT INTO items2 (title, filename, file) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            FileInputStream fis = new FileInputStream(file);

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, file.getName());
            preparedStatement.setBinaryStream(3, fis, (int) file.length());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            fis.close();


//            preparedStatement.setString(1, title);
//            preparedStatement.setBlob(2, file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void addRecord(Connection connection, File file) throws SQLException {
//        String query = "INSERT INTO items (file) VALUES (?);";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setBlob(2, (Blob) file);
//            preparedStatement.executeUpdate();
//        }
//    }

    public static String searchRecord(Connection connection, String title) throws SQLException {
        String query = "SELECT * FROM items2 WHERE title LIKE ?";
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
