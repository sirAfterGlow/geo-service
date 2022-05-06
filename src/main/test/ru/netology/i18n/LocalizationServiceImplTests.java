package ru.netology.i18n;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;

public class LocalizationServiceImplTests {

    LocalizationServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new LocalizationServiceImpl();
    }

    @BeforeAll
    public static void started() {
        System.out.println("LocalizationServiceImplTests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("LocalizationServiceImplTests completed");
    }


    @Test
    public void test_get_rus_local_for_russian() {
        Country country = Country.RUSSIA;
        String expected = "Добро пожаловать";

        String result = sut.locale(country);

        Assertions.assertEquals(expected, result);

    }


}
