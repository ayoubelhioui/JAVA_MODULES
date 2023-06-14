package ex00;

public class Program {
    private static int result = 0;
    public static void calculateSum(int number){
        if (number == 0)
            return ;
        result += number % 10;
        calculateSum(number / 10);
    }

    public static void main(String[] args) {
        int number = 479598;
        calculateSum(number);
        System.out.println(result);
    }
}