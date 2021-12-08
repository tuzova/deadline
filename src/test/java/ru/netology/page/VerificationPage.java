package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public void validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
    }

    public void warningMessageInvalidCode() { // comment: доработать локаторы
        $(withText("Ошибка")).shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='error-notification'] div.notification__content").shouldBe(visible);
        $(withText("Неверно указан код! Попробуйте ещё раз.")).shouldBe(visible);
    }

//    public void warningMessageLimit() {
//        $(withText("Ошибка")).shouldBe(visible, Duration.ofSeconds(15));
//        $("[data-test-id='error-notification'] div.notification__content").shouldBe(visible);
//        $(withText("Ошибка! Превышено количество попыток ввода кода!")).shouldBe(visible);
//    }

//    // очистка поля ввода кода / comment: Это метод page объекта, размещайте его в классе page объекта
//    public static void clearCodeField() {
//        $("[data-test-id='code'] input").click();
//        $("[data-test-id='code'] input").sendKeys(Keys.CONTROL + "A");
//        $("[data-test-id='code'] input").sendKeys(Keys.BACK_SPACE);
//    }

}

