import java.util.Scanner;


public class ConeCalculator implements Calculator {
    @Override
    public double calculateBaseArea() {
        double r;
        double wynik;
        r=scanner.nextDouble();
        wynik=3.14*r*r;
        return wynik;


    }

    @Override
    public double calculatoeBaseParimiter() {
        double r;
        double wynik;
        r=scanner.nextDouble();
        wynik=2*3.14*r;
        return wynik;
    }


}
