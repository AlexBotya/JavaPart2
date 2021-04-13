package Server;

import java.util.List;
import java.util.Optional;
import Server.DBConnection;

public class AuthenticationService {
    private List<Entry> entries = new EntryDDProcessing().findAll();

    public Optional<Entry> findEntryCredentials(String login, String password){

       //Optional<Entry> entry= new EntryDDProcessing().findByLogin(login);
        return entries.stream() // если подставить entry вместо  entries то user не может пройти авторизацию..
                .filter(e -> e.getLogin().equals(login) && e.getPassword().equals(password))
                .findFirst();
    }



}
