import java.util.*;

public class ChatEngine {

private Map<Long, User> uzytkownik=new LinkedHashMap<>();
Set<String> banned=new HashSet<String>();


public void addUser(User user) throws UserAddException {

    if (uzytkownik.containsKey((int)user.getId())) {

        if(banned.contains(user.getName()))
        {
            throw new UserAddException("Obiejt znajduje sie na liscie banow, nie mozna go dodac");
        }

        throw new UserAddException("Podana nazwa uzytkownika juz istnieje");

    }


    else
        {
        uzytkownik.put((long)user.getId(),user);
    }
}
public void removeUser(long userid) throws UserRemoveException
{
    if(uzytkownik.containsKey(userid))
 uzytkownik.remove(userid);
    else{
        throw new UserRemoveException("Podany uzytkownik nie istnieje");
    }
}

int getNumberOfUsers()
    {
    return uzytkownik.size();
}

void createBan(String userName)
{
    if(uzytkownik.containsValue(userName))
    {
        uzytkownik.remove(userName);
    }
    else
    {
        banned.add(userName);
    }

}
void removeBan(String username)
{
    banned.remove(username);
}
boolean hasUser(long userid)
{
    if(uzytkownik.containsKey(userid))
    {
        return true;
    }
    else
    {
        return false;
    }
}

boolean hasUser(String userName)
{
    if(uzytkownik.containsValue(userName))
    {
        return true;
    }
    else
    {
        return false;
    }
}









}
