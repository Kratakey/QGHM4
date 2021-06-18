import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HM4test {
    @Test
    void checkSoftAssertionsWiki() {
        Configuration.startMaximized = true;
        open("https://github.com/selenide/selenide");
        $(byText("Wiki")).click();
        $(byClassName("wiki-rightbar")).$(byText("SoftAssertions")).should(exist);
        $(byClassName("wiki-rightbar")).$("button").click();
        $(byClassName("wiki-rightbar")).$(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
    @Test
    void drag_n_drop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(element("#column-a")).dragAndDropTo($(element("#column-b")));
        $$("header").shouldHave(texts("B", "A"));
    }

}
