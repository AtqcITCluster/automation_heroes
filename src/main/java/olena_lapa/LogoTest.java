package olena_lapa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class LogoTest {


    public boolean open() {
        Selenide
                .open("http://www.google.com");
        $x("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
                .setValue("test automation")
                .sendKeys(Keys.ENTER);
        return this.open();
        String string;
        final var s = string= "searchTerm";
        {
            String inputFieldPath = "//tbody/tr[1]/td[6]/a[1]";
            $x(inputFieldPath).sendKeys("searchTerm");
            $x("//Page 5").click();
            final var open = new LogoTest().open();
            return open;
            boolean isGoogleLogoVisible;
            {
                try {
                    $x("//body/div[1]/div[2]/div[1]/img[1]").shouldBe(Condition.visible);
                    return true;

                } catch (AssertionError ex) {
                    return false;
                }

            }
        }
    }
}