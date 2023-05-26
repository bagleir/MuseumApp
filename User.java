/**
 * The `User` class represents a general user with their associated information.
 * It provides methods to access and retrieve user details such as name, ID, password, and email.
 */
public class User {

    private final String Name;
    private final int ID;
    private final String Password;
    private final String Email;

    /**
     * Constructs a new `User` object with the specified ID, name, password, and email.
     *
     * @param ID       the ID of the user
     * @param name     the name of the user
     * @param password the password of the user
     * @param email    the email of the user
     */
    public User(int ID, String name, String password, String email) {
        this.ID = ID;
        this.Name = name;
        this.Password = password;
        this.Email = email;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    public String GetName() {
        return this.Name;
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return the ID of the user
     */
    public int GetID() {
        return this.ID;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user
     */
    public String GetPassword() {
        return this.Password;
    }

    /**
     * Retrieves the email of the user.
     *
     * @return the email of the user
     */
    public String GetEmail() {
        return this.Email;
    }
}
