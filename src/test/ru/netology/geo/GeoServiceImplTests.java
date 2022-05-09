package ru.netology.geo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class GeoServiceImplTests {

    GeoServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new GeoServiceImpl();
    }

    @BeforeAll
    public static void started() {
        System.out.println("GeoServiceImplTests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("GeoServiceImplTests completed");
    }


    @ParameterizedTest
    @MethodSource("source")
    public void byIpTest(String ip, Location expected) {
        Location result = sut.byIp(ip);

        Assertions.assertEquals(result.getCountry(), expected.getCountry());
    }
    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("172.0.32.11", new Location(null, Country.RUSSIA, null, 0)),
                Arguments.of("96.0.32.11", new Location(null, Country.USA, null, 0)));
    }

    @Test
    void byCoordinatesThrowTest() {
        Assertions.assertThrows(RuntimeException.class, () -> sut.byCoordinates(123, 32.2));
    }
}
