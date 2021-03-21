import java.util.*;

public class NoteBook {
    private final Map<String, Set<String>> book;



    public NoteBook(Map<String, Set<String>> book) {
        this.book = new HashMap<>();
    }

    public void add(String name, String number){
        Set<String> numbers = book.getOrDefault(name, new HashSet<>());
        numbers.add(number);
        book.putIfAbsent(name, numbers);


//        if (book.containsKey(name)){
//            book.get(name).add(number);
//        } else {
//            Set<String> numbers  = new HashSet<>();
//            numbers.add(number);
//            book.put(name, numbers);
//        }
    }

    public Set<String> get (String name){
        if (book.containsKey(name)){
            return book.get(name);
        }else return Collections.emptySet();

    }
}
