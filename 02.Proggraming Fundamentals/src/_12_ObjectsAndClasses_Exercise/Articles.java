package _12_ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles {
    static class Article {
        String title;
        String content;
        String author;

        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        void edit(String newContent) {
            this.content = newContent;
        }

        void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        void rename(String newTitle) {
            this.title = newTitle;
        }

        public String toString() {
            return String.format("%s -%s:%s", this.title, this.content, this.author);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rewrites = Integer.parseInt(scanner.nextLine());

        String[] inputArr = input.split(",");
        List<Article> articlesList = new ArrayList<>();

        Article article = new Article(inputArr[0], inputArr[1], inputArr[2]);
        articlesList.add(article);

        for (int i = 0; i < rewrites; i++) {
            String modify = scanner.nextLine();
            String[] modifyArr = modify.split(":");
            switch (modifyArr[0]) {
                case "Edit":
                    articlesList.get(0).edit(modifyArr[1]);
                    break;
                case "ChangeAuthor":
                    articlesList.get(0).changeAuthor(modifyArr[1]);
                    break;
                case "Rename":
                    articlesList.get(0).rename(modifyArr[1]);
                    break;
            }
        }

        System.out.println(articlesList.get(0).toString());
    }
}
