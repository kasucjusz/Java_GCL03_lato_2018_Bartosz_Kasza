import java.util.Scanner;

public class Main{
    public static void main(String[] args)
        {

            ExtendedConeCalculator obj=new ExtendedConeCalculator();

            ConeCalculator stozek=new ConeCalculator();
            TetrahedronCalculator czworoscian=new TetrahedronCalculator();

         System.out.println("Co chcesz policzyc? 1-obwod podstawy stozka  2-pole podstawy sotzka");
         System.out.println("3-Obwod postawy czworoscianu foremnego 4-Pole podstawy czworoscianu foremnego");
         int wybierz;
         Scanner scanner=new Scanner(System.in);
         do {
             wybierz=scanner.nextInt();


             switch(wybierz)
             {
                 case 1:
                 {
                     double wynik;
                     wynik=stozek.calculatoeBaseParimiter();
                     System.out.println(wynik);
                     break;

                 }
                 case 2:
                 {
                     double wynik;
                     wynik=stozek.calculateBaseArea();
                     System.out.println(wynik);
break;
                 }
                 case 3:
                 {
                     double wynik;
                     wynik=czworoscian.calculatoeBaseParimiter();
                     System.out.println(wynik);
                     break;

                 }
                 case 4:
                 {
                     double wynik;
                     wynik=czworoscian.calculateBaseArea();
                     System.out.println(wynik);
                     break;
                 }
                 case 5:
                 {
                     obj.calculateArea();

                 }
                 case 6:
                 {
                     obj.calculateVolume();
                 }
             }



         }while(wybierz<7);

        }
        }
