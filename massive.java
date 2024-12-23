import java.util.ArrayList;
import java.util.Scanner;

public class massive {
    private final ArrayList<String> strings = new ArrayList<>();

    public void addString(String str) {
        if (str == null || str.isEmpty()) return;
        strings.add(str);
        strings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }


    public String getMaxLengthString() {
        if (strings.isEmpty()) throw new RuntimeException("Ссписок пуст");
        return strings.get(strings.size() - 1);
    }

    public double getAverageLength() {
        if (strings.isEmpty()) throw new RuntimeException("список пуст");
        return strings.stream().mapToInt(String::length).average().orElse(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        massive stringArray = new massive();

        System.out.println("пустая строка = остановка ввода");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            stringArray.addString(input);
        } 

        try {
            System.out.println("Max строка: " + stringArray.getMaxLengthString());
            System.out.println("AVG dlina строк: " + stringArray.getAverageLength());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
