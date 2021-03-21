import java.util.ArrayList;
import java.util.List;

/**
 1. Создать коллекцию типа List. Наполнить ее значениями и вывести значения в консолько при помощи ее метода forEach.
 2.Создать утилитарный метод forItem. Метод принимает два параметра:
 Коллекция Set<String> и консьюмер типа Consumer<String>.
 Внутри метода проитерироваться по коллекции
 и для каждого элемента выполнить метод консьюмера accept,
 который выводит значение элемента в консоль.
 Создать утилитарный метод doubleUp.
 Метод принимает два параметра: значение типа int и
 консьюмер типа Supplier<Integer>.
 Внутри метода выполнить метод саплаера get,
 который возвращает множитель и затем переданное значение на него умножается.
 Фукнция возращает результат произведения.
 Создать метод findAllChars. Метод принимает два параметра:
 String target и char toFind. Первый параметр является входной строкой,
 а второй - символ, который необходимо найти в входящей строке.
 Учесть что искомый символ может повторяется (напр.: 'ccch').
 Необходимо найти все повторения и вернуть в виде конкатенированной строки обвернутый в Optional.
 Если ни одного совпадения не найдено, тогда необходимо вернуть пустой Optional.
 Пример выполнения: Optional<String> opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".*/

public class main {
    public static void main(String[] args) {
        doTask1();
    }
    public static void doTask1(){
        List<String> stringList = new ArrayList<>();
        stringList.add("I");
        stringList.add("Love");
        stringList.add("Java");
        stringList.add("and");
        stringList.add("Java");
        stringList.add("Loves");
        stringList.add("Me");
        stringList.forEach(s -> System.out.println(stringList.));
    }
}
