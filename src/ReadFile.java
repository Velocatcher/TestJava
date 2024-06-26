import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    public static void wordProcessing() {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            List<String> wordsList = new ArrayList<>();
            Map<String, Integer> wordCount = new HashMap<>();
            String longestWord = "";

            while (scanner.hasNext()) {
                String word = scanner.next();
                wordsList.add(word);
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
//                Подсчет количества вхождений каждого уникального слова в тексте.
//                Добавляет слово в map wordCount.
//                Если слово уже присутствует в map, то используется метод getOrDefault(), который возвращает значение слова, если оно уже
//                есть в map, иначе возвращает значение по умолчанию (в данном случае 0).
//                После этого к полученному значению добавляется единица, что позволяет увеличить количество вхождений слова на один.

                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            scanner.close();

            System.out.println("Total number of words in the file: " + wordsList.size());
            System.out.println("Longest word in the file: " + longestWord + " - " + longestWord.length() + " letters");

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
            }

        } catch (
                FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
