package demo.qa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestConfig{
    @Test
    void formTest(){

            open("automation-practice-form");

            //main information
            $("#firstName").setValue("ephim");
            $("#lastName").setValue("sh");
            $("#userEmail").setValue("abatukam@mail.com");
            $("#genterWrapper").find(byText("Male")).click();
            $("#userNumber").setValue("1010101010");

            //date of birth -start-
            $("#dateOfBirthInput").click();
            SelenideElement dateOfBirthController = $("#dateOfBirth-wrapper");
            dateOfBirthController.$("div[class*='month'] [value='1']").click();
            dateOfBirthController.$("div[class*='year'] [value='1992']").click();
            dateOfBirthController.$("div[class*='day--016']").click();


            //major and hobbies
            $("#subjectsContainer").click();
            $("#subjectsInput").setValue("Computer Science").pressEnter();

            SelenideElement hobbyCheckBox = $("#hobbiesWrapper");
            hobbyCheckBox.$(byText("Sports")).click();
            hobbyCheckBox.$(byText("Reading")).click();
            hobbyCheckBox.$(byText("Music")).click();

            //upload file
            $("#uploadPicture").uploadFile(new File("src/test/resources/images/bingchilling.jpg"));

            //address
            $("#currentAddress").setValue("Russia, Saint-Petersburg");

            //state and city
            SelenideElement stateDropDown = $("#state");
            stateDropDown.click();
            $(byText("Rajasthan")).click();
            $("#city").click();
            $(byText("Jaipur")).click();

            $("#submit").click();

            //assertions
            SelenideElement modalWindow = $(".modal-content .table-responsive");
            modalWindow.shouldBe(visible);

            modalWindow.$(byText("Student Name")).closest("tr").shouldHave(text("ephim sh"));
            modalWindow.$(byText("Student Email")).closest("tr").shouldHave(text("abatukam@mail.com"));
            modalWindow.$(byText("Gender")).closest("tr").shouldHave(text("Male"));
            modalWindow.$(byText("Mobile")).closest("tr").shouldHave(text("1010101010"));
            modalWindow.$(byText("Date of Birth")).closest("tr").shouldHave(text("16 February,1992"));
            modalWindow.$(byText("Subjects")).closest("tr").shouldHave(text("Computer Science"));
            modalWindow.$(byText("Hobbies")).closest("tr").lastChild().shouldHave(text("Sports, Reading, Music"));
            modalWindow.$(byText("Picture")).closest("tr").shouldHave(text("bingchilling.jpg"));
            modalWindow.$(byText("Address")).closest("tr").lastChild().shouldHave(text("Russia, Saint-Petersburg"));
            modalWindow.$(byText("State and City")).closest("tr").shouldHave(text("Rajasthan Jaipur"));

    }
}
