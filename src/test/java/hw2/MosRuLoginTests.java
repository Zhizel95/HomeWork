package hw2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MosRuLoginTests {

    String login1 = "89449440797",
            login2 = "+79449440797",
            login3 = "+7 (944) 944-07-97",
            password = "vMYp(cU86*Ek2cu";


    @BeforeAll
    static void configuration() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 15000;

    }

    @Test // позитив логин - международный формат + пароль
    void successfulLogin1Test() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue(login1);
        $("#password").setValue(password);
        $("#bind").click();

        $("#mos-dropdown-user").shouldHave(text("Жанетта Яламова"));

    }

    @Test // позитив логин - локальный формат + пароль
    void successfulLogin2Test() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue(login2);
        $("#password").setValue(password);
        $("#bind").click();

        $("#mos-dropdown-user").shouldHave(text("Жанетта Яламова"));

    }

    @Test // позитив логин международ с разделителями + пароль
    void successfulLogin3Test() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue(login3);
        $("#password").setValue(password);
        $("#bind").click();

        $("#mos-dropdown-user").shouldHave(text("Жанетта Яламова"));

    }

    @Test // позитив - вход-выход-вход
    void successfulSignInSignOutLoginTest() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue(login1);
        $("#password").setValue(password);
        $("#bind").click();

        $("#mos-dropdown-user").shouldHave(text("Жанетта Яламова"));

        $("#mos-dropdown-user").click();
        $("#mos-dropdown-popup-user").click();
        $(".User_logout__Eg_Es").click();

        $("#password").setValue(password);
        $("#bind").click();

        $("#mos-dropdown-user").shouldHave(text("Жанетта Яламова"));

    }

    @Test // негатив - пустой логин
    void negativeLoginEmptyTest() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue("");
        $("#password").setValue(password);
        $("#bind").click();

        $(".parsley-required").shouldHave(text("Введите логин"));

    }

    @Test // негатив - пустой пароль
    void negativePasswordEmptyTest() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue(login2);
        $("#password").setValue("");

        $("#bind").click();

        $(".parsley-required").shouldHave(text("Введите пароль"));

    }

    @Test // негатив - неверный логин
    void negativeLoginTest() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue("89449440799");
        $("#password").setValue(password);

        $("#bind").click();

        $(".blockquote-danger").shouldHave(text("Введен некорректный логин или пароль"));

    }

    @Test // негатив - неверный пароль
    void negativePasswordTest() {
        open("https://www.mos.ru/");

        $("#mos-header").shouldHave(text("Войти"));
        $(".User_loginLinkText__3rVLq").click();

        $("#login").setValue(login3);
        $("#password").setValue("$%&(*732рвылаа");
        $("#bind").click();

        $(".blockquote-danger").shouldHave(text("Введен некорректный логин или пароль"));


    }

}
