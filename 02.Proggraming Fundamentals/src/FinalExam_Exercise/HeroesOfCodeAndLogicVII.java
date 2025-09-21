package FinalExam_Exercise;

import java.util.*;

public class HeroesOfCodeAndLogicVII {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, List<Integer>> heroes = new LinkedHashMap<>();
        FillHeroes(heroes);

        boolean playing = true;
        while (playing) {
            String[] input = scanner.nextLine().split(" - ");

            switch (input[0]) {
                case "CastSpell" -> CastSpell(heroes, input[1], Integer.parseInt(input[2]), input[3]);
                case "TakeDamage" -> TakeDamage(heroes, input[1], Integer.parseInt(input[2]), input[3]);
                case "Recharge" -> Recharge(heroes, input[1], Integer.parseInt(input[2]));
                case "Heal" -> Heal(heroes, input[1], Integer.parseInt(input[2]));
                case "End" -> playing = false;
            }
        }

        printHeroes(heroes);
    }

    public static void FillHeroes(Map<String, List<Integer>> heroes) {
        int heroesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < heroesCount; i++) {
            String[] hero = scanner.nextLine().split(" ");

            int currentHp = Integer.parseInt(hero[1]);
            int currentMp = Integer.parseInt(hero[2]);

            if (currentHp > 100) {
                currentHp = 100;
            }
            if (currentMp > 200) {
                currentMp = 200;
            }

            List<Integer> currentHeroStats = new ArrayList<>();
            currentHeroStats.add(currentHp);
            currentHeroStats.add(currentMp);

            heroes.put(hero[0], currentHeroStats);
        }
    }

    public static void CastSpell(Map<String, List<Integer>> heroes, String hero, int mpNeeded, String spell) {

        int currentMp = heroes.get(hero).get(1);

        if (currentMp >= mpNeeded) {
            currentMp -= mpNeeded;
            heroes.get(hero).set(1, currentMp);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero, spell, currentMp);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", hero, spell);
        }
    }

    public static void TakeDamage(Map<String, List<Integer>> heroes, String hero, int damage, String attacker) {

        int currentHp = heroes.get(hero).getFirst();

        if ((currentHp - damage) > 0) {
            currentHp -= damage;
            heroes.get(hero).set(0, currentHp);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, currentHp);
        } else {
            System.out.printf("%s has been killed by %s!%n", hero, attacker);
            heroes.remove(hero);
        }
    }

    public static void Recharge(Map<String, List<Integer>> heroes, String hero, int mp) {

        int current = heroes.get(hero).get(1) + mp;

        if (current > 200) {
            int amount = 200 - heroes.get(hero).getLast();
            current = 200;
            System.out.printf("%s recharged for %d MP!%n", hero, amount);
        } else {
            System.out.printf("%s recharged for %d MP!%n", hero, mp);
        }

        heroes.get(hero).set(1, current);
    }

    public static void Heal(Map<String, List<Integer>> heroes, String hero, int hp) {

        int current = heroes.get(hero).getFirst() + hp;

        if (current > 100) {
             int amount = 100 - heroes.get(hero).getFirst();
            current = 100;
            System.out.printf("%s healed for %d HP!%n", hero, amount);
        } else {
            System.out.printf("%s healed for %d HP!%n", hero, hp);
        }

        heroes.get(hero).set(0, current);
    }

    public static void printHeroes(Map<String, List<Integer>> heroes) {

        heroes.forEach((key, value) -> {
            System.out.println(key);
            System.out.println("  HP: " + value.get(0));
            System.out.println("  MP: " + value.get(1));
        });
    }
}