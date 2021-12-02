package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.openqa.selenium.Keys;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.codeborne.selenide.Selenide.$;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    // валидный пользователь
    public static AuthInfo getValidAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    // невалидный пользователь
    public static AuthInfo getInvalidAuthInfo() {
        Faker faker = new Faker();
        return new AuthInfo(faker.name().username(), faker.internet().password());
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    // валидный сгенерированный код из СУБД
    public static VerificationCode getValidVerificationCode(AuthInfo authInfo) {
        QueryRunner runner = new QueryRunner();
        String authCode = "SELECT code FROM auth_codes";

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
        ) {
            authCode = runner.query(connection, authCode, new ScalarHandler<>());
        } catch (java.sql.SQLException ignored) {
        }
        return new VerificationCode(authCode);
    }

    // невалидный код
    public static VerificationCode getInvalidVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    // очистка всех данных из таблиц
    public static void dropTables() {
        QueryRunner runner = new QueryRunner();
        String Users = "DELETE FROM users;";
        String Cards = "DELETE FROM cards;";
        String CardTransactions = "DELETE FROM card_transactions;";
        String AuthCodes = "DELETE FROM auth_codes;";

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
        ) {
            runner.update(connection, Users);
            runner.update(connection, Cards);
            runner.update(connection, CardTransactions);
            runner.update(connection, AuthCodes);

        } catch (java.sql.SQLException ignored) {
        }
    }

    // очистка поля ввода кода
    public static void clearCodeField() {
        $("[data-test-id='code'] input").click();
        $("[data-test-id='code'] input").sendKeys(Keys.CONTROL + "A");
        $("[data-test-id='code'] input").sendKeys(Keys.BACK_SPACE);
    }
}



