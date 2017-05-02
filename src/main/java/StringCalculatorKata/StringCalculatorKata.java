package StringCalculatorKata;

/**
 * Created by yellow on 4/5/2017 AD.
 */
public class StringCalculatorKata {

    public int add(String numbers) {
        int result = 0;
        if (numbers == "") {
            result = 0;
        } else {
            String newNumbers = numbers.replace(("\n"),",");
            String[] number = newNumbers.split(",");
            for (int i = 0; i < number.length; i++) {
                result += Integer.parseInt(number[i]);
            }
        }
        return result;
    }
}
