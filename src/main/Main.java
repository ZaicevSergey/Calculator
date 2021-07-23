package main;

import static main.Calculator.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String firstNum = null;
        String secondNum = null;
        String operation = null;

        String[] buffer = readConsole().split(" ");    // читаем с консоли и заносим в массив по частям
        try {
            firstNum = buffer[0];                            // дергаем первое число
            secondNum = buffer[2];                           // дергаем второе число
            operation = buffer[1];                           // дергаем арифм операцию
        }
        catch (ArrayIndexOutOfBoundsException aiooBE) {      // ловим эксепшн на случай неправильного ввода строки  с задачей
            throw new ArrayIndexOutOfBoundsException         // да, выглядит тупо, но так красивее выглядит в консоли)
                    ("Вы забыли ввести пробелы после введенного числа и арифметического символа");
        }
        a = checkNumber(firstNum);                           // инициализируем статик пременную a калькулятора
        b = checkNumber(secondNum);                          // инициализируем статик пременную b калькулятора
        checkСompatibility(isArabic, isRomain);              // проверяем совместимость введенных данных

        if (isRomain == true) {                              // проверка на тип чисел, через флаг
            operationsRomain(operation);                     // отправляем на операцию
        } else {
            operationsArabic(operation);                     // отправляем на операцию
        }
    }
}
