package Server;

import java.util.Optional;

public class AuthenticationService {
    //private List<Entry> entries = new EntryDDProcessing().findAll();

    public Optional<Entry> findEntryCredentials(String login, String password){
        return new EntryDDProcessing().findByLoginAndPassword(login, password);

    }



}
