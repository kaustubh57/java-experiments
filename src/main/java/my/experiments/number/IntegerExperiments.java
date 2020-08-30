package my.experiments.number;

public class IntegerExperiments {

    public static void main(String args[]) {
        try {
            System.out.println("Integer.valueOf(\"\") >>> " + Integer.valueOf("abc"));
        } catch (NumberFormatException nfe) {
            System.out.println("Throws number format exception for Integer.valueOf(\"abc\")");
        }
        System.out.println("Integer.valueOf(\"\") >>> " + Integer.valueOf("100"));

        System.out.println("5 % 7 is >>> " + (5 % 7));
        System.out.println("7 % 5 is >>> " + (7 % 5));
        System.out.println("0 % 5 is >>> " + (0 % 5));
        System.out.println("1 % 14 is >>> " + (1 % 14));
    }
}
