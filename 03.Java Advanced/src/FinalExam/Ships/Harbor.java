package FinalExam.Ships;


import java.util.ArrayList;
import java.util.List;

public class Harbor {

    private String location;
    private int minDepth;
    private List<Ship> ships;

    public Harbor(String location, int minDepth) {
        this.location = location;
        this.minDepth = minDepth;
        this.ships = new ArrayList<>();
    }

    public String addShip(Ship ship) {
        for (Ship s : ships) {
            if (s.getName().equals(ship.getName())) {
                return "Ship with this name already exists!";
            }
        }
        if (ship.getDraft() > minDepth) {
            return "The ship " + ship.getName() + " cannot dock due to draft limitations!";
        }
        ships.add(ship);
        return "Ship " + ship.getName() + " added to the harbor.";
    }

    public boolean removeShip(String name) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getName().equals(name)) {
                ships.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getShipsByType(String type) {
        List<String> filteredShips = new ArrayList<>();
        for (Ship ship : ships) {
            if (ship.getType().equals(type)) {
                filteredShips.add(ship.getName());
            }
        }

        if (!filteredShips.isEmpty()) {
            return "Ships of type " + type + ": " + String.join(", ", filteredShips);
        }else {
            return "There are no ships of the requested type.";
        }
    }

    public Ship getShipByName(String name) {
        for (Ship ship : ships) {
            if (ship.getName().equals(name)) {
                return ship;
            }
        }
        return null;
    }

    public String getLargestShip() {
        if (ships.isEmpty()) {
            return "No ships in the harbor.";
        }
        Ship largest = ships.get(0);
        for (Ship ship : ships) {
            if (ship.getTonnage() > largest.getTonnage()) {
                largest = ship;
            }
        }
        return largest.getName() + " is the largest ship with a tonnage of " + largest.getTonnage() + " tons.";
    }

    public int getCount() {
        return ships.size();
    }

    public String getStatistics() {
        if (ships.isEmpty()) {
            return "No ships docked in " + location + ".";
        }
        StringBuilder sb = new StringBuilder("Ships docked in " + location + ":\n");
        for (Ship ship : ships) {
            sb.append("* ").append(ship.getName()).append("\n");
        }
        return sb.toString().trim();
    }
}


