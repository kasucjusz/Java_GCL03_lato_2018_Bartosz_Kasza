public class ExtendedConeCalculator extends ConeCalculator implements ExtendedCalculator  {
    @Override
    public void calculateArea()
    {
        double r,l;
        r=scanner.nextDouble();
        l=scanner.nextDouble();

        if((r<0)&&(l<0))
        {
            final IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r and l musza byc weksze od 0");
        }
        System.out.println(Math.PI*r*r+Math.PI*r*1);


    }

    @Override
    public void calculateVolume() {
        double r,H;
        r=scanner.nextDouble();
        H=scanner.nextDouble();

        if((r<0)&&H<0)
        {
            final IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r i H musza byc weksze od 0");

        }
        System.out.println((Math.PI*r*r*H)/3);

    }

}
