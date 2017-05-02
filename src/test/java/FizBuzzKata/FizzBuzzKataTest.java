package FizBuzzKata;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yellow on 4/10/2017 AD.
 */
public class FizzBuzzKataTest {

    FizzBuzzKata fizzBuzzKata;

    int Fizz;
    int Buzz;
    int FizzBuzz;

    @Before
    public void setup(){
        fizzBuzzKata = new FizzBuzzKata();
    }

    @After
    public void teardown(){
        fizzBuzzKata = null;
    }

    @Test
    public void print_fizzbuzz_have_Fizz_twentyseven(){
        Fizz = fizzBuzzKata.print("Fizz");
        assertEquals(27,Fizz);
    }

    @Test
    public void print_buzz_have_Buzz_fourteen(){
        Buzz = fizzBuzzKata.print("Buzz");
        assertEquals(14,Buzz);
    }

    @Test
    public void print_fizzbuzz_have_FizzBuzz_six(){
        FizzBuzz = fizzBuzzKata.print("FizzBuzz");
        assertEquals(6,FizzBuzz);
    }
}
