package _08_InterfacesAndAbstraction_Exercises.P06_Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : urls) {
            if (url.matches(".*\\d.*")) {
                result.append("Invalid URL!\n");
            } else {
                result.append("Browsing: ").append(url).append("!\n");
            }
        }
        return result.toString();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                result.append("Invalid number!\n");
            } else {
                result.append("Calling... ").append(number).append("\n");
            }
        }
        return result.toString();
    }
}
