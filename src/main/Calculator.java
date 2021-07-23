package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class Calculator {

    static String[] romainNumerals = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] arabicNumerals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static boolean isArabic;
    static boolean isRomain;
    static int a;
    static int b;
    static StringBuilder sb = new StringBuilder();

    //  Запрос  с консоли
    public static String readConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите арифметическую операцию в одну строку. Не забудте ввести пробелы после введенного числа и арифметического символа!\n" +
                "Так же калькулятор поддерживает римские числа\n" +
                "(только целые числа от 1 до 10, например 10 * 10 или IX + VIII):\n");
        String line = reader.readLine();
        return line;
    }

    // проверка на числа и парсинг
    public static int checkNumber(String s) throws Exception {

        int number = 0;
        boolean numberIsNull = true;

        for (int i = 1; i < 11; i++) {
            if (s.equals(arabicNumerals[i])) {
                isArabic = true;
                return number = i;
            }
            else if (s.equals(romainNumerals[i])) {
                isRomain = true;
                return number = i;
            }
        }
        if (numberIsNull == true) {
            throw new Exception("Вы ввели неподходящие числа, введите числа от 1 до 10");
        }
        return number;
    }

    // проверка на совместимость символов
    public static void checkСompatibility(boolean a, boolean b) throws Exception {
        if (a == b) {
            throw new Exception("Числа не совместимы.");
        }
    }

    // арифметические операции для арабских чисел с выводом результата
    public static void operationsArabic(String s) throws Exception {
        int result;
        switch (s) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Упс! Вы ввели неверный арифметический символ");
        }
        System.out.println("Ответ : " + result);
    }

    // арифметические операции для римских чисел с выводом результата
    public static void operationsRomain(String s) throws Exception {

        int result;
        int i = 0;
        List<RomanNumeral> romanNumerals = Arrays.asList(RomanNumeral.values());

        switch (s) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Упс! Вы ввели неверный арифметический символ");
        }

        while ((result > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.value <= result) {
                sb.append(currentSymbol.name());
                result -= currentSymbol.value;
            } else {
                i++;
            }
        }

        System.out.println("Ответ : " + sb);
    }

}
