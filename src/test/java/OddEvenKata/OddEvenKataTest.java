package OddEvenKata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddEvenKataTest {

    OddEvenKata oddEvenKata;
    int result;

    @Test
    public void test_even_should_be_49(){
        oddEvenKata = new OddEvenKata();
        result = oddEvenKata.print("Even");
        assertEquals(9,result);
    }
}
