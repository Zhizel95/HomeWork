package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JUNIT5CodeExampleSearch {

    @Test
    void shouldFindJUNIT5CodeExample() {
        Configuration.holdBrowserOpen = true;
        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $$("ul.UnderlineNav-body li").get(5).click();
        $(".btn-link").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".Layout-sidebar").$(byText("SoftAssertions")).click();
        //$$("ul li.wiki-more-pages a").get(2).click();
        $("#js-repo-pjax-container").shouldHave(text("Using JUnit5 extend test class"));

    }
}
