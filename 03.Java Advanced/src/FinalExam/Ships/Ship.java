package FinalExam.Ships;

public class Ship {
    private String name;
    private String type;
    private int tonnage;
    private int draft;

    public Ship(String name, String type, int tonnage, int draft) {
        this.name = name;
        this.type = type;
        this.tonnage = tonnage;
        this.draft = draft;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getTonnage() {
        return tonnage;
    }

    public int getDraft() {
        return draft;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Tonnage: " + tonnage + " tons, Draft: " + draft + " meters.";
    }
}


