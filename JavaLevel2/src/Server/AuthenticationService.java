package Server;

import java.util.List;
import java.util.Optional;

public class AuthenticationService {
    private static final List<Entry> entries = new EntryDDProcessing().findAll();

    public Optional<Entry> findEntryCredentials(String login, String password){

        return entries.stream()
                .filter(entry -> entry.getLogin().equals(login) && entry.getPassword().equals(password))
                .findFirst();
    }



}
