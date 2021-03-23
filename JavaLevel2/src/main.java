import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 1. Создать коллекцию типа List. Наполнить ее значениями и вывести значения в консолько при помощи ее метода forEach.
 * 2.Создать утилитарный метод forItem. Метод принимает два параметра:
 * Коллекция Set<String> и консьюмер типа Consumer<String>.
 * Внутри метода проитерироваться по коллекции
 * и для каждого элемента выполнить метод консьюмера accept,
 * который выводит значение элемента в консоль.
 * 3. Создать утилитарный метод doubleUp.
 * Метод принимает два параметра: значение типа int и
 * консьюмер типа Supplier<Integer>.
 * Внутри метода выполнить метод саплаера get,
 * который возвращает множитель и затем переданное значение на него умножается.
 * Фукнция возращает результат произведения.
 * 4. Создать метод findAllChars. Метод принимает два параметра:
 * String target и char toFind. Первый параметр является входной строкой,
 * а второй - символ, который необходимо найти в входящей строке.
 * Учесть что искомый символ может повторяется (напр.: 'ccch').
 * Необходимо найти все повторения и вернуть в виде конкатенированной строки обвернутый в Optional.
 * Если ни одного совпадения не найдено, тогда необходимо вернуть пустой Optional.
 * Пример выполнения: Optional<String> opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".
 */

public class main {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();


    }


    public static void doTask1() {
        List<String> stringList = new ArrayList<>();
        stringList.add("I");
        stringList.add("Love");
        stringList.add("Java");
        stringList.add("and");
        stringList.add("Java");
        stringList.add("Loves");
        stringList.add("Me");

        stringList.forEach(s -> System.out.println(s));

    }

    public static void doTask2() {
        Set<String> words = Set.of("I", "Love", "Java");
        forItem(words, string -> System.out.println(string));
    }

    public static void forItem(Set<String> set, Consumer<String> action) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            action.accept(str);
        }
    }

    public static void doTask3() {
        System.out.println(doubleUp(15, getMultiplier()));
    }

    private static Supplier<Integer> getMultiplier() {
        return () -> 2;
    }


    public static int doubleUp(int value, Supplier<Integer> multiplier) {
        return value * multiplier.get();
    }

    public static void doTask4() {
        System.out.println(findAllChars("USSR", 'S').get());

    }

    static Optional<String> findAllChars(String target, char toFind) {
        char[] chars = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == toFind) {
                sb.append(chars[i]);
            }
        }
        if (sb.length() != 0) {
            return Optional.of(sb.toString());
        }
        return Optional.empty();
    }

}
