import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewYearCatsTest {

    @BeforeAll
    static void configuration() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void NewYearCat() {

        open("https://www.google.com");

        $("#APjFqb").setValue("новогодние котики").pressEnter();
        $(".YmvwI").click();

    }
}
