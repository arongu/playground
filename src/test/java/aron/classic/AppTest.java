package aron.classic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Run me before everything else.");
    }

    @Test
    public void test() {
        System.out.println("Running your test.");
    }

    @Test
    public void returnInt_shouldReturnValue() {
        final App app = new App();
        assertEquals(5, app.returnInt(5));
    }
}
