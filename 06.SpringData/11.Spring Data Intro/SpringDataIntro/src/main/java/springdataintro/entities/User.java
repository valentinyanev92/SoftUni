package springdataintro.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id")
    private List<Account> account;

    public User() {
        this.account = new ArrayList<>();
    }

    public User(String username, int i) {
        this();
        this.username = username;
        this.age = i;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public void addAccount(Account account) {
        this.account.add(account);
    }
}
