/*
Ильков Вениамин
Конвертер единиц (длины, массы или температуры)
 */
import java.util.Scanner;


class Converter {
    static String[][] UNITS = {{"Километры", "Метры", "сантиметры"}, {"Киллограммы", "Граммы", "Миллиграммы"}, {"Цельсия", "Фаренгейта"}};
    static float[][] UNITVALUES = {{1, 1000, 100000}, {1, 1000, 100000}, {0, 0}};

    public static String getUnitNames(int unit) {
        String unitNames = "";
        for (int i = 0; i < UNITS[unit].length; i++) {
            unitNames = unitNames + "\n[" + i + "] - " + UNITS[unit][i];
        }
        return unitNames;
    }

    public static String getUnitNames(int unit, int exception) {
        String unitNames = "";
        for (int i = 0; i < UNITS[unit].length; i++) {
            if (i != exception) unitNames = unitNames + "\n[" + i + "] - " + UNITS[unit][i];
        }
        return unitNames;
    }

    public static String getConvertResult(int value, int unit, int unitIn, int unitOut) {
        float result = value;

        result = result / UNITVALUES[unit][unitIn] * UNITVALUES[unit][unitOut];

        return Float.toString(result);
    }

    public static String getConvertResult(int value, int unitIn) {
        float result = value;

        if (unitIn == 1) result = (value - 32) * 0.555f;
        else if (unitIn == 0) result = (value * 1.8f) + 32;

        return Float.toString(result);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.print("Выберите конвертер: \n[0] - Конвертер длины\n[1] - Конвертер массы\n[2] - Конвертер температуры\n\n");
        Scanner in = new Scanner(System.in);
        int converter = in.nextInt();

        System.out.println("Выберите исходную единицу измерения:\n" + Converter.getUnitNames(converter) + "\n");
        int unitIn = in.nextInt();

        System.out.println("Введите значение:\n");
        int value = in.nextInt();

        int unitOut = 0;
        if (converter != 2) {
            System.out.println("Выберите конечную единицу измерения:\n" + Converter.getUnitNames(converter, unitIn) + "\n");
            unitOut = in.nextInt();

            System.out.println("Результат: " + Converter.getConvertResult(value, converter, unitIn, unitOut));
        } else {
            System.out.println("Результат: " + Converter.getConvertResult(value, unitIn));
        }

        in.close();
    }
}