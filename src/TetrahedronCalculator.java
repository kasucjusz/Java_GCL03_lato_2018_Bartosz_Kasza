public class TetrahedronCalculator implements Calculator {
    @Override
    public double calculateBaseArea()
    {
        double a;
        double wynik;
        a=scanner.nextDouble();
        wynik=(a*a*Math.sqrt(3))/4;
        return wynik;
    }

    @Override
    public double calculatoeBaseParimiter() {
        double a, wynik;
        a=scanner.nextDouble();
        wynik=3*a;
        return wynik;
    }
}
