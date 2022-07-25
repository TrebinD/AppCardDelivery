package ru.netology.delivery.data;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AppCardDeliveryTest {
    @BeforeAll
    static void setUpAll(){
        SelenideLogger.addListener("allure",new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void connect(){
        open("http://localhost:9999/");
    }

    @Test
    public void validData() {
        UserInfo userInfo = DataGenerate.Registration.generateInfo();

        String dateOne = DataGenerate.generateDate(3);
        String dateTwo = DataGenerate.generateDate(6);

        $x("// input [@placeholder = \"Город\"]").setValue(userInfo.getCity());
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(dateOne);
        $x("// input [@name = \"name\"]").val(DataGenerate.generateName());
        $x("//input [@name = \"phone\"]").val(DataGenerate.generatePhone());
        $(".checkbox__box").click();
        $x("//span [text() = \"Запланировать\"]").click();
        $x("//div [@data-test-id=\"success-notification\"]").should(visible, Duration.ofSeconds(15));
        $x("//div [@data-test-id=\"success-notification\"]").should(text("Встреча успешно запланирована на " + dateOne));
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(dateTwo);
        $x("//input [@placeholder=\"Дата встречи\"]").pressEnter();
        $x("//span [text() = \"Запланировать\"]").click();
        $x("//button[@class='button button_view_extra button_size_s button_theme_alfa-on-white']").click();
        $x("//div[@class = \"notification__content\"]").should(text(dateTwo));
    }

    @Test
    public void nonValidData() {
        UserInfo userInfo = DataGenerate.Registration.generateInfo();

        String dateOne = DataGenerate.generateDate(3);
        String dateTwo = DataGenerate.generateDate(6);

        $x("// input [@placeholder = \"Город\"]").setValue(userInfo.getCity());
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(dateOne);
        $x("// input [@name = \"name\"]").val("Vladislav");
        $x("//input [@name = \"phone\"]").val(DataGenerate.generatePhone());
        $(".checkbox__box").click();
        $x("//span [text() = \"Запланировать\"]").click();
        $x("//div [@data-test-id=\"success-notification\"]").should(visible, Duration.ofSeconds(15));
        $x("//div [@data-test-id=\"success-notification\"]").should(text("Встреча успешно запланирована на " + dateOne));
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(dateTwo);
        $x("//input [@placeholder=\"Дата встречи\"]").pressEnter();
        $x("//span [text() = \"Запланировать\"]").click();
        $x("//button[@class='button button_view_extra button_size_s button_theme_alfa-on-white']").click();
        $x("//div[@class = \"notification__content\"]").should(text(dateTwo));
    }
}
