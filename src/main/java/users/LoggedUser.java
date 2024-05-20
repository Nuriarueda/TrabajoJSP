package users;

public class LoggedUser {
    private long id;
    private String name;
    private String surname;
    private String username;


    public LoggedUser(long id, String name, String surname, String username){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)",getName(), getSurname(), getUsername());
    }
    
}
