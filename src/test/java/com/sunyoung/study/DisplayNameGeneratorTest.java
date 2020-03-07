package com.sunyoung.study;

import com.sunyoung.study.util.LeapYear;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DisplayNameGeneratorTest {
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported {
        @Test
        void if_it_is_zero() {
            boolean isLeapYear = LeapYear.isLeapYear(0);

            assertFalse(isLeapYear);
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported")
        @ValueSource(ints = {-1, -4})
        void if_it_is_negative(int year) {
            boolean isLeapYear = LeapYear.isLeapYear(year);

            assertFalse(isLeapYear);
        }
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class A_year_is_leap_year {
        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {
            boolean isLeapYear = LeapYear.isLeapYear(year);

            assertTrue(isLeapYear);
        }
    }

    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {
        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + ' ' + testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }
}
