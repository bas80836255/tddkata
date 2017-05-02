package OddEvenKata;

/**
 * Created by yellow on 4/11/2017 AD.
 */
public class OddEvenKata {

    public int print(String choice) {
        int Odd = 0;
        int Even = 0;
        int Prime = 0;

        for (int i = 1; i <= 20; i++) {
            if (i == 2|| i%2 !=0) {
                Prime += 1;
                System.out.println(i + " : Prime");
            } else if (i % 2 == 0 & i != 2) {
                Even += 1;
                System.out.println(i + " : Even");
            } else if (i % 2 != 0) {
                Odd += 1;
                System.out.println(i + " : Odd");
            } else {
                System.out.println(i);
            }
        }

        System.out.println("Odd == " + Odd);
        System.out.println("Even == " + Even);
        System.out.println("Prime == " + Prime);

        if (choice.equals("Odd")) {
            return Odd;
        }
        if (choice.equals("Even")) {
            return Even;
        }
        if (choice.equals("Prime")) {
            return Prime;
        }
        return 0;
    }
}
