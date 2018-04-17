import java.lang.Math;

public class BasicCalculator {

   public boolean isSumPositive=true;



    float calculateSum(float a, float b) {

        return a + b;
    }



    float calculateDifference(float a, float b) {
        return a - b;
    }

    float calculateMultiplication(float a, float b) {
        return a * b;
    }

    float calculateDivision(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("second argument can not be zero");
        } else {


            return a / b;
        }
    }

    float calculatePow(float a, float b) {
        return (float) Math.pow(a, b);
    }

    float calculateSqlr(float a) {
        if (a < 0) {
            throw new IllegalArgumentException("Argument is negative");
        } else {
            return (float) Math.sqrt(a);
        }
    }

}
