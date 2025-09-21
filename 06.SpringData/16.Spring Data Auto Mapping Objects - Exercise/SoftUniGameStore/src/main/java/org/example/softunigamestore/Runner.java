package org.example.softunigamestore;

import org.example.softunigamestore.dtos.*;
import org.example.softunigamestore.services.GameService;
import org.example.softunigamestore.services.ShoppingCartService;
import org.example.softunigamestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

@Component
public class Runner implements CommandLineRunner {

    private final GameService gameService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    private UserDto currentUser;

    @Autowired
    public Runner(GameService gameService, UserService userService, ShoppingCartService shoppingCartService) {
        this.gameService = gameService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void run(String... args) throws Exception {
        ensureFirstAdmin();
        Scanner scanner = new Scanner(System.in);

        Map<String, Function<String[], String>> commands = new HashMap<>();
        commands.put("RegisterUser", this::register);
        commands.put("Login", this::login);
        commands.put("WhoAmI", this::whoAmI);
        commands.put("Logout", this::logout);
        commands.put("AddGame", this::addGame);
        commands.put("DeleteGame", this::deleteGame);
        commands.put("AllGames", this::getAllGames);
        commands.put("DetailsGame", this::getGameDetails);
        commands.put("BuyGame", this::buyGame);
        commands.put("Purchase", this::purchase);

        String input;
        while (!(input = scanner.nextLine()).equals("Logout")) {
            String[] data = input.split("\\|");

            String command = data[0];
            Function<String[], String> action = commands.get(command);

            String output = execute(action, data);
            System.out.println(output);
        }
    }

    private String purchase(String[] strings) {
        this.ensureAuthenticated();





    }

    private String buyGame(String[] strings) {
        this.ensureAuthenticated();

        ShoppingCartItemInputDto inputDto = new ShoppingCartItemInputDto(this.currentUser.getId(), Long.parseLong(strings[1]), Integer.parseInt(strings[2]));
        ShoppingCartDto createdShoppingCart = shoppingCartService.create(inputDto);

        return String.format("Game \"%s\" was added to your shopping cart! Shopping cart item ID: %d"
                , createdShoppingCart.getGame().getTitle(), createdShoppingCart.getId());
    }

    private String getGameDetails(String[] strings) {
        GameDto game = this.gameService.getGameByTitle(strings[1]);

        if (game == null) {
            System.out.println("No such game");
            return null;
        }

        return String.format(game.toString());
    }

    private String getAllGames(String[] strings) {
        ensureAuthenticated();

        List<GameDto> allGames = gameService.getAllGames();
        StringBuilder sb = new StringBuilder();

        sb.append("All games:\n");
        for (GameDto game : allGames) {
            sb.append(String.format("\t%s - $%s\n", game.getTitle(), game.getPrice()));
        }

        return sb.toString();
    }

    private String deleteGame(String[] data) {
        this.ensureAdmin();

        GameDto gameForDelete = gameService.findGameById(Long.parseLong(data[1]));

        if (gameForDelete != null) {
            return gameService.deleteGameById(Long.parseLong(data[1]));
        } else {
            return "Game with ID " + data[0] + " not found";
        }
    }

    private String addGame(String[] data) {
        this.ensureAdmin();

        GameDto gameDto = new GameDto(data[1], new BigDecimal(data[2]),
                Double.parseDouble(data[3]), data[4], data[5],
                data[6], data[7]);

        GameDto registerGame = gameService.registerGame(gameDto);
        return String.format("Game added: %s", registerGame.getTitle());
    }

    private void ensureAdmin() {
        this.ensureAuthenticated();

        if (!this.currentUser.isAdmin()) {
            throw new IllegalStateException("You are not an admin!");
        }
    }

    private static String execute(Function<String[], String> action, String[] data) {
        if (action == null) {
            return "Unrecognized command";
        }

        try {
            return action.apply(data);
        } catch (Exception e) {
            return String.format("ERROR!!! %s%n", e.getMessage());
        }
    }

    private String register(String[] data) {
        this.ensureAnonymous();

        UserRegisterDto dto = new UserRegisterDto(data[1], data[2], data[3]);
        UserDto createdUser = userService.register(dto);

        return String.format("User \"%s\" with ID %d was registered successfully!", createdUser.getEmail(), createdUser.getId());
    }

    private String login(String[] data) {
        this.ensureAnonymous();

        UserLoginDto dto = new UserLoginDto(data[1], data[2]);
        UserDto loggedInUser = userService.login(dto);

        if (loggedInUser == null) return "Invalid credentials!";

        this.currentUser = loggedInUser;
        return String.format("User \"%s\" with ID %d was logged in successfully!", loggedInUser.getEmail(), loggedInUser.getId());
    }


    private String whoAmI(String[] strings) {
        this.ensureAuthenticated();
        return String.format("You are logged in as \"%s\" with ID %d!", this.currentUser.getEmail(), this.currentUser.getId());
    }

    private String logout(String[] data) {
        this.ensureAuthenticated();

        this.currentUser = null;
        return "Logged out successfully!";
    }

    private void ensureAuthenticated() {
        if (this.currentUser == null)
            throw new IllegalStateException("You are not logged in! Please log in before using this command!");
    }

    private void ensureAnonymous() {
        if (this.currentUser != null)
            throw new IllegalStateException("You are already logged in! Please, log out before executing this command!");
    }


    private void ensureFirstAdmin() {
        UserRegisterDto userDto = new UserRegisterDto("game_store@admin.com", "admin", "First Admin");

        UserDto firstAdmin = userService.ensureAdmin(userDto);

        if (firstAdmin == null) System.out.println("Fist admin already registered");
        else System.out.printf("Fist admin successfully registered with ID %d%n", firstAdmin.getId());
    }
}