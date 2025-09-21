package _11_ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        String type;
        String name;
        String time;

        Song(String type, String name, String time){
            this.type = type;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return this.name;
        }

        public String getType(){
            return this.type;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i<numberOfSongs; i++){
            String line = scanner.nextLine();
            String[] songAsStr = line.split("_");
            Song song = new Song(songAsStr[0], songAsStr[1], songAsStr[2]);
            songs.add(song);
        }

        String search = scanner.nextLine();
        if (search.equals("all")){
            for (int i = 0; i < songs.size(); i++) {
                System.out.println(songs.get(i).getName());
            }
        }else {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getType().equals(search)){
                    System.out.println(songs.get(i).getName());
                }
            }
        }
    }

}
