package hw1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.PageLoadStrategy.EAGER;



public class MosRuSearchTests {

    @BeforeAll
    static void configuration() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = String.valueOf(EAGER);
    }

    @Test
    void mosRuSearchTestChrome() {

        open("https://www.google.com");

        $("#APjFqb").setValue("mos ru").pressEnter();

        $("#search").shouldHave(text("Официальный сайт Мэра Москвы"));

    }

    @Test
    void mosRuSearchTestYandex() {

        open("https://ya.ru/");

        $("#text").setValue("mos ru").pressEnter();

        $(".main__center").shouldHave(text("Официальный сайт Мэра Москвы"));

    }

    @Test
    void successfulSearchTest2() {
        open("https://ya.ru/");
        $("[name=text]").setValue("mos ru").pressEnter();
        $("[id=search]").shouldHave(text("https://www.mos.ru"));
    }

}

