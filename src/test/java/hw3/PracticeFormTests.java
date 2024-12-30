package hw3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.PageLoadStrategy.EAGER;


public class PracticeFormTests {

    @Test
    void fillFormTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = String.valueOf(EAGER);

        open("https://demoqa.com/automation-practice-form/");
        $(".text-center").shouldHave(text("Practice Form"));
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Zhizel");
        $("#lastName").setValue("Bunchet");
        $("#userEmail").setValue("zhizel_bunchet@gmail.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("7364058671");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--013:not(react-datepicker__day--outside-month").click();
        $("#subjectsInput").setValue("biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").click();
        $("#currentAddress").setValue("в Индии походу");
        $(byText("State and City")).scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Zhizel Bunchet"));
        $(".table-responsive").shouldHave(text("zhizel_bunchet@gmail.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("7364058671"));
        $(".table-responsive").shouldHave(text("13 September,1990"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("в Индии походу"));
        $(".table-responsive").shouldHave(text("NCR Noida"));



    }

}
