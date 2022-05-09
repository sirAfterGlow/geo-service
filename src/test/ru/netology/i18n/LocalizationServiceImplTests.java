package ru.netology.i18n;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

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


    @ParameterizedTest
    @MethodSource("source")
    public void localTest(Country country, String expected) {
        String result = sut.locale(country);

        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> source() {
        return Stream.of((Arguments.of(Country.RUSSIA, "Добро пожаловать")),
            Arguments.of(Country.USA, "Welcome"));
    }


}
