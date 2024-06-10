package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

import static org.openqa.selenium.PageLoadStrategy.EAGER;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = String.valueOf(EAGER);
    }
}
