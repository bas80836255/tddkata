package FizBuzzKata;

/**
 * Created by yellow on 4/10/2017 AD.
 */
public class FizzBuzzKata {

    public int print(String choice) {

        int Fizz = 0;
        int Buzz = 0;
        int FizzBuzz = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 & i%5 !=0) {
                Fizz +=1;
                System.out.println("Fizz");
            }
            else if (i % 5 == 0 & i%3 !=0) {
                Buzz +=1;
                System.out.println("Buzz");
            }
            else if (i % 3 == 0 & i % 5 == 0) {
                FizzBuzz +=1;
                System.out.println("FizzBuzz");
            }
            else {
                System.out.println(i);
            }
        }

        System.out.println("Fizz == "+Fizz);
        System.out.println("Buzz == "+Buzz);
        System.out.println("FizzBuzz == "+FizzBuzz);

        if (choice.equals("Fizz")){
            return Fizz;
        }
        if (choice.equals("Buzz")){
            return Buzz;
        }
        if (choice.equals("FizzBuzz")){
            return FizzBuzz;
        }
        return 0;
    }
}
