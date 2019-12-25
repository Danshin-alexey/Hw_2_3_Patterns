import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static com.codeborne.selenide.Selenide.$;

public class HelpParameters {

    private static Faker faker = new Faker(new Locale("ru"));
    private static String fullName = faker.name().fullName();
    private static String phone = faker.phoneNumber().cellPhone();
    private static String city = faker.address().cityName();

    public static String getName () {
        return fullName;
    }
    public static String getPhone () {
        return phone;
    }
    public static String getCity () {
        return city;
    }
    public static String getFutureDate (){
        LocalDate today = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return today.format(formatter);
    }
    public static void clean(){
        $("[placeholder='Дата встречи']").clear();
    }
    public static String getNewDate(){
        LocalDate todayNew = LocalDate.now().plusDays(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return todayNew.format(formatter);
    }
}
