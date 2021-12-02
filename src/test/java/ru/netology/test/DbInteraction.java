//package ru.netology;
//
//import com.github.javafaker.Faker;
//import lombok.val;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.*;
//
//public class DbInteraction {
//  @BeforeEach
//  void setUp() throws SQLException {
//    Faker faker = new Faker();
//    String dataSQL = "INSERT INTO users(login, password) VALUES (?, ?);";
//
//    try (
//            Connection connection = DriverManager.getConnection(
//            "jdbc:mysql://localhost:3306/app", "app", "pass"
//        );
//            PreparedStatement preparedStatement = connection.prepareStatement(dataSQL);
//    ) {
//      preparedStatement.setString(1, faker.name().username());
//      preparedStatement.setString(2, "password");
//      preparedStatement.executeUpdate();
//      preparedStatement.setString(1, faker.name().username());
//      preparedStatement.setString(2, "password");
//      preparedStatement.executeUpdate();
//    }
//  }
//
//  @Test
//  void stubTest() throws SQLException {
//    String countSQL = "SELECT COUNT(*) FROM users;";
//    String cardsSQL = "SELECT id, number, balance_in_kopecks FROM cards WHERE user_id = ?;";
//
//    try (
//        Connection conn = DriverManager.getConnection(
//            "jdbc:mysql://localhost:3306/app", "app", "pass"
//        );
//        Statement statement = conn.createStatement();
//        PreparedStatement preparedStatement = conn.prepareStatement(cardsSQL);
//    ) {
//      try (ResultSet resultSet = statement.executeQuery(countSQL)) {
//        if (resultSet.next()) {
//          // выборка значения по индексу столбца (нумерация с 1)
//          int count = resultSet.getInt(1);
//          // TODO: использовать
//          System.out.println(count);
//        }
//      }
//
//      preparedStatement.setInt(1, 1);
//      try (ResultSet resultSet = preparedStatement.executeQuery()) {
//        while (resultSet.next()) {
//          int id = resultSet.getInt("id");
//          String number = resultSet.getString("number");
//          int balanceInKopecks = resultSet.getInt("balance_in_kopecks");
//          // TODO: сложить всё в список
//          System.out.println(id + " " + number + " " + balanceInKopecks);
//        }
//      }
//    }
//  }
//}
//
