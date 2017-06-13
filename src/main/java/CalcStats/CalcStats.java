package CalcStats;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by yellow on 4/18/2017 AD.
 */
public class CalcStats {

    public String[] cals(String sequence) {
        String[] result = new String[4];
        String newNumbers = sequence.replace(("\n"), ",");
        String[] numbers = newNumbers.split(",");
        int y = numbers.length;
        double sum = 0;
        int cal[] = new int[y];
        for (int i = 0; i < y; i++) {
            cal[i] = convertStringNum(numbers[i]);
            sum += cal[i];
        }
        Arrays.sort(cal);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("0.00");
        result[0] = String.valueOf(cal[0]);
        result[1] = String.valueOf(cal[y - 1]);
        result[2] = String.valueOf(y);
        result[3] = String.valueOf(df.format(sum / y));
        for (String output : result) {
            System.out.println(output);
        }
        return result;
    }

    public int convertStringNum(String stringNum) {
        int intNumber;
        try {
            intNumber = Integer.parseInt(stringNum);
        } catch (Exception e) {
            intNumber = 0;
        }
        return intNumber;
    }
}
