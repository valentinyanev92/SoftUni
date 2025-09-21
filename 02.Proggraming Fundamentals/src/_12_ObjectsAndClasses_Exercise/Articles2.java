package _12_ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    static class Article {
        String title;
        String content;
        String author;

        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int articles = Integer.parseInt(scanner.nextLine());
        List<Article> articlesList = new ArrayList<>();

        for (int i = 0; i < articles; i++) {
            input = scanner.nextLine();
            String[] inputArr = input.split(", ");
            Article article = new Article(inputArr[0], inputArr[1], inputArr[2]);
            articlesList.add(article);
        }

        input = scanner.nextLine();
        for (int i = 0; i < articlesList.size(); i++) {
            System.out.println(articlesList.get(i).toString());
        }
    }
}
