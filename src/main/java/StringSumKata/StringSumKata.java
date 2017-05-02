package StringSumKata;

/**
 * Created by yellow on 4/4/2017 AD.
 */
public class StringSumKata {

    int number1;
    int number2;
    int number;

    public String sum(String num1,String num2){
        number1 = convertStringNum(num1);
        number2 = convertStringNum(num2);
        return Integer.toString(number1+number2);
    }

    public int convertStringNum(String stringNum){
        try{
            number = Integer.parseInt(stringNum);
        }
        catch (Exception e){
            number = 0;
        }
        return number;
    }
}
