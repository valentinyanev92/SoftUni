package bookshopsystem.dtos;

public class AuthorInputDto {
    private final String fist_name;
    private final String last_name;

    public AuthorInputDto(String name) {
        String[] names = name.split(" ");
        this.fist_name = names[0];
        this.last_name = names[names.length - 1];
    }

    public String getFist_name() {
        return fist_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
