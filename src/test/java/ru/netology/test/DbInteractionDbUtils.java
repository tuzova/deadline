//package ru.netology;
//
//import com.github.javafaker.Faker;
//import lombok.val;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//import org.apache.commons.dbutils.handlers.ScalarHandler;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class DbInteractionDbUtils {
//    @BeforeEach
//    void setUp() throws SQLException {
//        Faker faker = new Faker();
//        QueryRunner runner = new QueryRunner(); // вставляет данные
//        String dataSQL = "INSERT INTO users(id, login, password) VALUES (?, ?, ?);";
//
//        try (
//                Connection conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/app", "app", "pass"
//                );
//
//        ) {
//            // шаблон обычная вставка данных раннером
//            runner.update(conn, dataSQL, "5", faker.name().username(), "pass");
//            runner.update(conn, dataSQL, "6", faker.name().username(), "pass");
//        }
//    }
//
//    @AfterEach
//    //// Вычистка данных это очистка таблиц базы данных.
////// Сделать это можно с помощью отдельного метода, запускаемого после выполнения всех тестов.
//    void setDown() throws SQLException {
//        QueryRunner runner = new QueryRunner();
//        String dataSQL = "DELETE FROM users;";
//
//        try (
//                Connection conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/app", "app", "pass"
//                );
//        ) {
//        }
//    }
//
//    @Test
//    void stubTest() throws SQLException {
//        String countSQL = "SELECT COUNT(*) FROM users;";
//        String usersSQL = "SELECT * FROM users;";
//        QueryRunner runner = new QueryRunner();
//
//        try (
//                Connection conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/app", "app", "pass"
//                );
//        ) {
//          Object count = runner.query(conn, countSQL, new ScalarHandler<>());
//          System.out.println(count);
//          User first = runner.query(conn, usersSQL, new BeanHandler<>(User.class));
//          System.out.println(first);
//          List<User> all = runner.query(conn, usersSQL, new BeanListHandler<>(User.class));
//          System.out.println(all);
//        }
//    }
//}
//
//// Внимательно посмотрите, как и куда сохраняются коды генерации в СУБД и напишите тест,
//// который взяв информацию из БД о сгенерированном коде позволит вам протестировать "Вход в систему" через веб-интерфейс.
////
////P.S. Неплохо бы ещё проверить, что при трёхкратном неверном вводе пароля система блокируется.
//
