package my.experiments.math;

public class ExponentialExperiment {

    public static void main(String[] args) {

        System.out.println("4: " + calculatePowerTo2AndAdd(4));
    }


    private static int calculatePowerTo2AndAdd(int powerNumber) {
        if (powerNumber == 0) {
            return 1;
        }

        return getExponentValueFor2(powerNumber) + calculatePowerTo2AndAdd(powerNumber - 1);
    }

    private static int getExponentValueFor2(int exp) {
        if (exp == 0) {
            return 1;
        }
        return 2 * getExponentValueFor2(exp - 1);
    }

}
