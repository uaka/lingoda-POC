package helper;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

//Based on Faker lib https://github.com/DiUS/java-faker
public class RandomDataHelper {
    private static String locale = "en-GB";

    private static Faker faker = new Faker(new Locale(locale));

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail(String firstName) {
        return faker.bothify(firstName + "_????") + "@lingoda.com";
    }

    public static String getCompanyName() {
        return faker.company().name();
    }

    public static String getRandomFact() {
        return faker.chuckNorris().fact();
    }

    public static String getRandomCountry() { return faker.address().country();
    }

    public static String getRandomStreet() {
        return faker.address().streetAddress();
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomSecondaryAddress() {
        return faker.address().secondaryAddress();
    }

    public static String getRandomState() {
        return faker.address().state();
    }

    public static String getRandomSentence() {
        return faker.lorem().sentence();
    }

    public static long getRandomBirthDate() {
        LocalDate fromDate = LocalDate.of(1940, Month.JANUARY, 1);
        ZonedDateTime fromDateTime = fromDate.atStartOfDay(ZoneOffset.UTC);

        LocalDate toDate = LocalDate.of(2000, Month.JANUARY, 1);
        ZonedDateTime toDateTime = toDate.atStartOfDay(ZoneOffset.UTC);

        return faker.date().between(Date.from(fromDateTime.toInstant()), Date.from(toDateTime.toInstant())).getTime();
    }

    public static String getRandomMobile() {
        return "+4179" + faker.number().digits(7);
    }

    public static int getRandomSalutation() {
        return faker.number().numberBetween(1, 2);
    }

    public static String getRandomZip() {
        return faker.address().zipCode();
    }
}
