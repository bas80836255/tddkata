package StringCalculatorKata;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yellow on 4/5/2017 AD.
 */
public class StringCalculatorKataTest {

    private StringCalculatorKata stringCalculatorKata;

    @Before
    public void setup(){
        stringCalculatorKata = new StringCalculatorKata();
    }

    @After
    public void teardown(){
        stringCalculatorKata = null;
    }

    @Test
    public void sum_empty_string_should_be_zeo(){
        int result = stringCalculatorKata.add("");
        assertEquals(0,result);
    }

    @Test
    public void sum_one_string_number_should_be_it_value(){
        int result = stringCalculatorKata.add("1,2");
        assertEquals(3,result);
    }

    @Test
    public void sum_two_string_number_one_and_two_should_be_three(){
        int result = stringCalculatorKata.add("1,2");
        assertEquals(3,result);
    }

    @Test
    public void sum_string_should_be_six(){
        int result = stringCalculatorKata.add("1\n2,3");
        assertEquals(6,result);
    }
}
