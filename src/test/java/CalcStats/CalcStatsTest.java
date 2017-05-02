package CalcStats;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yellow on 4/18/2017 AD.
 */
public class CalcStatsTest {

    CalcStats calcStats;

    @Before
    public void setup(){
        calcStats = new CalcStats();
    }

    @After
    public void teardown(){
        calcStats = null;
    }

    @Test
    public void hello(){
        String[] cal = new String[3];
        cal = calcStats.cals("2,8,10,4,6");
        assertEquals("2",cal[0]);
        assertEquals("10",cal[1]);
        assertEquals("5",cal[2]);
        assertEquals("6.00",cal[3]);
    }


    @Test
    public void hello2(){
        String[] cal = new String[3];
        cal = calcStats.cals("-2,8,4,0,2,6");
        assertEquals("-2",cal[0]);
        assertEquals("8",cal[1]);
        assertEquals("6",cal[2]);
        assertEquals("3.00",cal[3]);
    }


}
