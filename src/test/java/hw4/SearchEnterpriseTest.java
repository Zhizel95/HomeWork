package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.PageLoadStrategy.EAGER;

public class SearchEnterpriseTest {

    @BeforeAll
    static void beforeAll() {

//      Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = String.valueOf(EAGER);
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    @Test
    void searchEnterprise() {

        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(withText("Enterprise")).click();

        $(".application-main").shouldHave(text("The AI-powered developer platform"));

    }
}
