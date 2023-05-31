package demo.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {


    @BeforeAll
    static void init(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void successTest(){
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Oushea");
        $("#userEmail").setValue("abatu@mail.com");
        $("#currentAddress").setValue("usa");
        $("#permanentAddress").setValue("another usa 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Oushea"));
        $("#output #email").shouldHave(text("abatu@mail.com"));
        $("#output #currentAddress").shouldHave(text("usa"));
        $("#output #permanentAddress").shouldHave(text("another usa 1"));
    }
}
