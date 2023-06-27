/*
Ильков Вениамин
Конвертер единиц (длины, массы или температуры)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sentence {
    public static List<String> substrings(String string, int range) {

        List<String> substrings = new ArrayList<>(Arrays.asList());
        int start = 0;

        for (int i = range; i < string.length(); i = i + range) {
            substrings.add(string.substring(start, i));
            start = i;
        }

        return substrings;
    }
}


public class Main2 {
    public static void main(String[] args) {
        System.out.print("Введите предложение или текстовую строку:\n");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        System.out.print("Введите максимальную длину строки:\n");
        int range = in.nextInt();

        System.out.println("Результат:\n" + Sentence.substrings(text, range) + "\n");
//        int unitIn = in.nextInt();

        in.close();
    }
}