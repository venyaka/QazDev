/*
Ильков Вениамин
Конвертер единиц (длины, массы или температуры)
 */
import java.util.Scanner;

class Sentence {
    public static String maxWord(String string) {
        String max = "";

        String[] array = string.split(" ");

        for (int i = 0; i < array.length; i++) {
            if (max.length() < array[i].length()) max = array[i];
        }
        return max;
    }
}


public class Main2 {
    public static void main(String[] args) {
        System.out.print("Введите предложение или текстовую строку:\n");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        System.out.println("Самым длинным словом в данной строке является:\n" + Sentence.maxWord(text) + "\n");
//        int unitIn = in.nextInt();

        in.close();
    }
}