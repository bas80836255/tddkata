package Diversion;

/**
 * Created by yellow on 4/20/2017 AD.
 */
public class Diversion {

    public int solution(String[] sequence) {
        int result = 0;
        for (String check : sequence) {
            System.out.println("check : " + check);
            if (check.contains("11")) {
                result += 1;
            }
            System.out.println("result : " + result);
        }
        
        return sequence.length - result;
    }
}
