package fr.test.numbers;

import fr.test.exceptions.IllegalNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {

    NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {29, 31, 37, 41, 43})
    public void isPrimeForPrimes(int number) throws IllegalNumberException {
        boolean isPrime = numberWorker.isPrimeNumber(number);
        assertTrue(isPrime);
    }

    @ParameterizedTest
    @ValueSource(ints = {30, 32, 36, 42, 44})
    public void isPrimeForNotPrimes(int number) throws IllegalNumberException {
        boolean isPrime = numberWorker.isPrimeNumber(number);
        assertFalse(isPrime);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -32, -42, -44})
    public void isPrimeForIncorrectNumbers(int number) {
        assertThrows(IllegalNumberException.class, () ->numberWorker.isPrimeNumber(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "data.csv")
    public void shouldReturnSumOfDigit(int number, int expectedResult) {
        int sum = numberWorker.calculateSum(number);
        assertEquals(sum, expectedResult);
    }
}