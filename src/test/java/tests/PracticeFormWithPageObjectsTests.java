package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
        String
                firstname = "Zhizel",
                lastname = "Bunchet",
                email = "zhizel_bunchet@gmail.com",
                gender = "Other",
                phone = "7364058671",
                birthdate = "13",
                birthmonth = "September",
                birthyear = "1990",
                subject = "Biology",
                hobby1 = "Sports",
                hobby2 = "Music",
                picture = "img/1.png",
                address = "в Индии походу",
                state = "NCR",
                city = "Noida";


        registrationPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .userEmail(email)
                .setGenderWrapper(gender)
                .setPhone(phone)
                .setBirthDate(birthdate, birthmonth, birthyear)
                .setSubject(subject)
                .setHobby(hobby1, hobby2)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstname + " " + lastname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", birthdate + " " + birthmonth + "," + birthyear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby1 + "," + " " + hobby2)
                .verifyResult("Picture", "1.png")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);



    }

}
