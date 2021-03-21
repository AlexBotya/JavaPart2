import java.util.*;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class main {
    public static void main(String[] args) {
        doTask1();
    }

    static void doTask1(){
        String[] wordsArray = {"I", "love", "java", "more", "and", "more", "every", "day"};
        Set<String> wordColl = new HashSet<>(Arrays.asList(wordsArray));
        System.out.println(wordColl);

        Map<String, Integer> counter = new HashMap<>();

        for (int i = 0; i < wordsArray.length; i++) {
            if(counter.containsKey(wordsArray[i])){
                counter.put(wordsArray[i], counter.get(wordsArray[i])+1);
            }else counter.put(wordsArray[i], 1);


        }
        System.out.println(counter);
    }

}






