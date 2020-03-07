package com.sunyoung.study;

import com.sunyoung.study.util.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumptionsTest {
    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")), () -> {
            // Messages to show when assumption is false
            return "It runs only on ci servers.";
        });

        // Unless environment is CI, it never fails.
        fail();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 10, -12})
    void testOnlyPositiveNumbers(int value) {
        assumingThat(value > 0, () -> {
            // It runs only when assumption is true
            assertTrue(Calculator.multiply(value, 5) > 0);
        });

        assertTrue(Calculator.multiply(value, value) >= 0);
    }
}
