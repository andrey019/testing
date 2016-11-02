package andrey019.interview.top10tasks;


import java.util.ArrayList;

public class Fibonacci {

    public static void main(String[] args) {
        //fibonacci(100);
        int amount = 10000;
        long time = System.currentTimeMillis();
        fibonacci2(amount);
        System.out.println("my method: " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        fibonacci3(amount);
        System.out.println("not my method: " + (System.currentTimeMillis() - time));
    }

    private static void fibonacci(int max) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        if (max == 1) {
            return;
        }
        array.add(1);
        if (max == 2) {
            return;
        }
        int number = 1;
        do {
            array.add(number);
            number = array.get(array.size() - 1) + array.get(array.size() - 2);
        } while (number < max);
        System.out.println(array.toString());
    }

    private static void fibonacci2(int max) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        if (max == 1) {
            return;
        }
        array.add(1);
        if (max == 2) {
            return;
        }
        while (array.size() <= max) {
            array.add(array.get(array.size() - 1) + array.get(array.size() - 2));
        }
        //System.out.println(array.toString());
    }

    private static void fibonacci3(int max) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=1; i<=max; i++){
            //System.out.print(fibonacci3Inner(i) +" ");
            array.add(fibonacci3Inner(i));
        }
    }

    public static int fibonacci3Inner(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){

            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;

        }
        return fibonacci; //Fibonacci number

    }
}
