package olena_lapa;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleResultPage {
    public GoogleResultPage open() {
        Selenide.open("http://google.com");
        return this;
    }
    public ReturnSearchHomePage search(String searchTerm) {


        String inputFieldPath = "//input[@class=' gLFyf gsfi ']";

        $x(inputFieldPath).sendKeys(searchTerm);
        $x("//button").click();
        return new ReturnSearchHomePage();
    }
}
