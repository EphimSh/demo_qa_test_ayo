package demo.qa;


import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestConfig{
    @Test
    void formTest(){
        open("automation-practice-form");

        $("#firstName").setValue("ephim");
        $("#lastName").setValue("sh");
        $("#userEmail").setValue("abatukam@mail.com");
        $("#genterWrapper [for='gender-radio-1']").click();
        $("#userNumber").setValue("1010101010");

        //date of birth -start-
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper div[class*='month'] [value='1']").click();
        $("#dateOfBirth-wrapper div[class*='year'] [value='1992']").click();
        $("#dateOfBirth-wrapper div[class*='day--016']").click();



        //date of birth -end-

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper label[for='hobbies-checkbox-1']").click();
        $("#hobbiesWrapper label[for='hobbies-checkbox-2']").click();
        $("#hobbiesWrapper label[for='hobbies-checkbox-3']").click();


        $("#uploadPicture").uploadFile(new File("src/test/java/demo/qa/data/bingchilling.jpg"));
        $("#currentAddress").setValue("Russia, Saint-Petersburg");

        $("#state .css-1hwfws3").click();


        $("#state [class*='menu'] [id*='option-3']").click();
        $("#city").click();
        $("#city [class*='menu'] [id*='option-0']").click();

        $("#submit").click();

        $(".modal-content .table-responsive").shouldBe(visible);

        $(" tr:nth-child(1) td:nth-child(2)").shouldHave(text("ephim sh"));
        $(" tr:nth-child(2) td:nth-child(2)").shouldHave(text("abatukam@mail.com"));
        $(" tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(" tr:nth-child(4) td:nth-child(2)").shouldHave(text("1010101010"));
        $(" tr:nth-child(5) td:nth-child(2)").shouldHave(text("16 February,1992"));
        $(" tr:nth-child(6) td:nth-child(2)").shouldHave(text("Computer Science"));
        $(" tr:nth-child(8) td:nth-child(2)").shouldHave(text("bingchilling.jpg"));
        $(" tr:nth-child(9) td:nth-child(2)").shouldHave(text("Russia, Saint-Petersburg"));
        $(" tr:nth-child(10) td:nth-child(2)").shouldHave(text("Rajasthan Jaipur"));















    }
}
