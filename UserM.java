/**
 * The `UserM` class represents a museum user with their associated information.
 * It provides methods to access and retrieve user details such as name, ID, password, email, and museum.
 */
public class UserM {

    private final String Name;
    private final int ID;
    private final String Password;
    private final String Email;
    private final Museum Museum;

    /**
     * Constructs a new `UserM` object with the specified ID, name, password, email, and museum.
     *
     * @param ID       the ID of the user
     * @param name     the name of the user
     * @param password the password of the user
     * @param email    the email of the user
     * @param museum   the associated museum of the user
     */
    public UserM(int ID, String name, String password, String email, Museum museum) {
        this.ID = ID;
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.Museum = museum;
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

    /**
     * Retrieves the associated museum of the user.
     *
     * @return the associated museum of the user
     */
    public Museum GetMuseum() {
        return this.Museum;
    }
}
