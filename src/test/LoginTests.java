import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    @Test
    void successfulLoginTest() {
        Configuration.holdBrowserOpen = true;

        open("https://school.qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));

        $("[name=email]").setValue("sdiliara@yandex.ru");
        $("[name=password]").setValue("\\U}41L>p4JwA@y!r").pressEnter();

        $(".menu-item-profile").click();

        open("https://school.qa.guru/cms/system/login");
        $(".logined-form").shouldHave(text("Здравствуйте, Диляра"));


    }
    @Test
    void unsuccessfulLoginTest1() {
        Configuration.holdBrowserOpen = true;


        open("https://school.qa.guru/cms/system/login?required=true");
        $(".login-form").shouldHave(text("Войти"));

        $("[name=email]").setValue("");
        $("[name=password]").setValue("\\U}41L>p4JwA@y!r").pressEnter();

        $(".btn-error").shouldHave(text("Не заполнено поле E-Mail"));

    }
    @Test
    void unsuccessfulLoginTest2() {
        Configuration.holdBrowserOpen = true;

        open("https://school.qa.guru/cms/system/login?required=true");
        $(".login-form").shouldHave(text("Войти"));

        $("[name=email]").setValue("sd@yandex.ru");
        $("[name=password]").setValue("\\U}41L>p4JwA@y!r").pressEnter();

        $(".btn-error").shouldHave(text("Неверный E-Mail"));
    }

    @Test
    void unsuccessfulLoginTest3() {
        Configuration.holdBrowserOpen = true;

        open("https://school.qa.guru/cms/system/login?required=true");
        $(".login-form").shouldHave(text("Войти"));

        $("[name=email]").setValue("sdiliara@yandex.ru");
        $("[name=password]").setValue("").pressEnter();
        $(".btn-error").shouldHave(text("Не заполнено поле Пароль"));

    }
    @Test
    void unsuccessfulLoginTest4() {
        Configuration.holdBrowserOpen = true;

        open("https://school.qa.guru/cms/system/login?required=true");
        $(".login-form").shouldHave(text("Войти"));

        $("[name=email]").setValue("sdiliara@yandex.ru");
        $("[name=password]").setValue("19475809@%@$").pressEnter();

        $(".btn-error").shouldHave(text("Неверный пароль"));

    }


}
