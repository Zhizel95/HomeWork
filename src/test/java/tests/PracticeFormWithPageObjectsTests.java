package tests;

import org.junit.jupiter.api.Test;
import tests.TestData;


public class PracticeFormWithPageObjectsTests extends TestBase {

    @Test

    void fillFormTest() {

        TestData random = new TestData ();

        registrationPage.openPage()
                .setFirstName(random.firstname)
                .setLastName(random.lastname)
                .userEmail(random.email)
                .setGenderWrapper(random.gender)
                .setPhone(random.phone)
                .setBirthDate(random.birthday, random.birthmonth, random.birthyear)
                .setSubject(random.subject)
                .setHobby(random.hobby)
                .uploadPicture(random.picture)
                .setAddress(random.address)
                .setState(random.state)
                .setCity(random.city)
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", random.firstname + " " + random.lastname)
                .verifyResult("Student Email", random.email)
                .verifyResult("Gender", random.gender)
                .verifyResult("Mobile", random.phone)
                .verifyResult("Date of Birth", random.birthday + " " + random.birthmonth + "," + random.birthyear)
                .verifyResult("Subjects", random.subject)
                .verifyResult("Hobbies", random.hobby)
                .verifyResult("Picture", "1.png")
                .verifyResult("Address", random.address)
                .verifyResult("State and City", random.state + " " + random.city);

    }


}
