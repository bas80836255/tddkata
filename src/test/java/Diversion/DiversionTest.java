package Diversion;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiversionTest {

    private Diversion diversion;

    @Before
    public void setup(){
        diversion = new Diversion();
    }

    @After
    public void teardown(){
        diversion = null;
    }

    @Test
    public void solution_eight_sequence_should_be_five(){
        String[] sequence = {"000", "001", "010", "011", "100", "101", "110", "111"};
        int result = diversion.solution(sequence);
        assertEquals(5,result);
    }

    @Test
    public void solution_sixteen_sequence_should_be_eight(){
        String[] sequence = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        int result = diversion.solution(sequence);
        assertEquals(8,result);
    }
}