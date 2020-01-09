    import com.codeborne.selenide.Condition;
	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Test;
	import static com.codeborne.selenide.Selectors.withText;
	import static com.codeborne.selenide.Selenide.$;
	import static com.codeborne.selenide.Selenide.open;

    public class DeliveryCardTest {


        @DisplayName("Should fill in all fields, safe and change only date")
        @Test
        void changeDate(){
            open("http://localhost:9999");
            $("[placeholder ='Город']").setValue(HelpParameters.getCity());
            $("[placeholder='Дата встречи']").setValue(HelpParameters.getFutureDate());
            $("[data-test-id=name] input").setValue(HelpParameters.getName());
            $("[data-test-id=phone] input").setValue(HelpParameters.getPhone());
            $("[data-test-id=agreement]").click();
            $(".button__text").click();
            $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
            HelpParameters.cleanDate();
            $("[placeholder='Дата встречи']").setValue(HelpParameters.getNewDate());
            $(".button__text").click();
            $("[data-test-id='replan-notification']").waitUntil(Condition.visible, 15000);
            $(".button__text").click();
            $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
        }
    }
