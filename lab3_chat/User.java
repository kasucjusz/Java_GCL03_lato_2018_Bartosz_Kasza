import java.util.*;
public class User {

    Scanner wpisz=new Scanner(System.in);
     long  id;
     String name;
    long createdAt;
     int numberOfSentMessages;

     User(String name, long id)
     {
         this.name=name;
         this.id=id;
     }
    long getId()
    {
        return id;
    }
    String getName()
    {
        return name;
    }
    int getNumberOfSentMessages()
    {
        return numberOfSentMessages;
    }

    long setId()
    {
        id=wpisz.nextLong();
        return  id;

    }
    String setName()
    {
        name=wpisz.nextLine();
        return name;
    }

    void setNumberOfSentMessages()
    {
        numberOfSentMessages=wpisz.nextInt();
    }


}
