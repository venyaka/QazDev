/*
Ильков Вениамин
Принимает строку, сохраняет ее в БД как документ с помощью HTTP-запроса без использования библиотек, выполняет поиск строк в БД по заданной последовательности символов
 */

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "venyaka";

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            createTable(connection);
            System.out.println("Commands:\n\n[0] - add record\n[1] - search record\n\nclick any keys for exit");
            Scanner in = new Scanner(System.in);

            int mode = in.nextInt();
            if (mode == 0) {
//                System.out.println("mode 0");
                System.out.println("Write your record:");
                String title = in.next();

//                    if (title != null && ! title.equals("")) {
                addRecord(connection, title);
                System.out.println("Done!");
//                    }
            }else if (mode == 1) {
                System.out.println("mode 1");

                System.out.println("\nWrite your search record:");
                String title = in.next();

                System.out.println(searchRecord(connection, title));
            } else {
                System.out.println("exit");
            }
            in.close();

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
