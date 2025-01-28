package lesson16;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFaker {
    @Test
    public void test1() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String telephonyNumber = faker.phoneNumber().subscriberNumber();
        String address = faker.address().fullAddress();
        System.out.println(telephonyNumber);
        System.out.println(name);
        System.out.println(address);
        char a= faker.lorem().character();
        System.out.println(a);
    }
    @Test
    public void test2() {
        Faker faker = new Faker(new Locale("tr"));
        System.out.println(faker.name().fullName());

    }
}

