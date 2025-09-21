package MidExam_Official;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> favoriteGenres = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" \\| ")).toList());

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Stop!")) {
                break;
            }


            switch (input[0]) {
                case "Join":
                    if (!favoriteGenres.contains(input[1])) {
                        favoriteGenres.add(input[1]);
                    }
                    break;
                case "Drop":
                    if (favoriteGenres.contains(input[1])) {
                        int index = favoriteGenres.indexOf(input[1]);
                        favoriteGenres.remove(index);
                    }
                    break;
                case "Replace":
                    if (favoriteGenres.contains(input[1]) && !favoriteGenres.contains(input[2])) {
                        int index = favoriteGenres.indexOf(input[1]);
                        favoriteGenres.set(index, input[2]);
                    }
                    break;
                case "Prefer":
                    int first = Integer.parseInt(input[1]);
                    int second = Integer.parseInt(input[2]);

                    if (first >= 0 && first < favoriteGenres.size() && second >= 0 && second < favoriteGenres.size()) {
                        String temp = favoriteGenres.get(first);
                        favoriteGenres.set(first, favoriteGenres.get(second));
                        favoriteGenres.set(second, temp);
                    }
                    break;
            }

        }
        for (int i = 0; i < favoriteGenres.size(); i++) {
            System.out.print(favoriteGenres.get(i));
            if (i != favoriteGenres.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
