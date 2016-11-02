package andrey019.interview.top10tasks;


public class PrimeNumber {

    public static void main(String[] args) {
        int max = 100;
        for (int i = 0; i < max; i++) {
            if (isPrime(i)) {
                System.out.print(Integer.toString(i) + ", ");
            }
            //System.out.print(Integer.toString(i) + " " + isPrime(i) + "; ");
            StringBuilder stringBuilder = new StringBuilder().reverse();
        }
    }

    private static boolean isPrime(int number) {
        if (number < 1) {
            return false;
        }
        if (number == 1 || number == 2) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
