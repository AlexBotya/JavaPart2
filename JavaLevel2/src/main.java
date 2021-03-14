/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
 * и просуммировать. Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException,
 * с детализацией в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод,
 * обработать возможные исключения MySizeArrayException
 * и MyArrayDataException, и вывести результат расчета.
 */

public class main {
    public static void main(String[] args) {
        int sum = 0;
        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                //{"17", "18","19", "20"}
        };
        sum = arraySum(array, sum);
        System.out.println("Sum = " + sum);
        System.out.println();
    }

    private static int arraySum(String[][] array, int sum) {
        int temp = 0;
        if (array.length != 4) throw new MyArraySizeException("Array [i][]length wrong");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("Array [][i] length wrong");
            for (int j = 0; j < array[i].length; j++) {
                try {
                    temp = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    System.out.printf("%s [%s][%s]\n" ,new MyArrayDataException("Array Data incorrect: element"), i, j);
                    System.out.println(e);
                } finally {
                    sum += temp;
                    temp = 0;
                }
            }
        }
        return sum;
    }
}




