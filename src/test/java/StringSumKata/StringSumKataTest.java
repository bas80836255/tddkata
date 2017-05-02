package StringSumKata;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yellow on 4/4/2017 AD.
 */
public class StringSumKataTest {

    StringSumKata stringSumKata;

    private String num1;
    private String num2;
    private String result;

    @Before
    public void setup() {
        stringSumKata = new StringSumKata();
    }

    @After
    public void teardown() {
        stringSumKata = null;
        num1 = "";
        num2 = "";
    }

    @Test
    public void sum_insert_one_plus_two_should_be_three() {
        num1 = "1";
        num2 = "2";
        result = stringSumKata.sum(num1, num2);
        assertEquals("3", result);
    }

    @Test
    public void sum_one_plus_afabet_should_be_one() {
        num1 = "1";
        num2 = "a";
        result = stringSumKata.sum(num1,num2);
        assertEquals("1",result);
    }

    @Test
    public void sum_one_plus_afet_should_be_one() {
        num1 = "";
        num2 = "";
        result = stringSumKata.sum(num1,num2);
        assertEquals("0",result);
    }

}
