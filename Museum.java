/**
 * The `Museum` class represents a museum with its associated information.
 * It stores details such as the museum's code, name, location, description, email, and website link.
 */
public class Museum {

    private final int Code;
    private final String Name;
    private final String Location;
    public final String Description;
    private final String Email;
    private final String Link;

    /**
     * Constructs a new `Museum` object with the specified code, name, location, description, email, and link.
     *
     * @param code        the code of the museum
     * @param name        the name of the museum
     * @param location    the location of the museum
     * @param description the description of the museum
     * @param email       the email of the museum
     * @param link        the website link of the museum
     */
    public Museum(int code, String name, String location, String description, String email, String link) {
        this.Code = code;
        this.Name = name;
        this.Location = location;
        this.Description = description;
        this.Email = email;
        this.Link = link;
    }

    /**
     * Retrieves the name of the museum.
     *
     * @return the name of the museum
     */
    public String GetName() {
        return this.Name;
    }

    /**
     * Retrieves the code of the museum.
     *
     * @return the code of the museum
     */
    public int GetCode() {
        return this.Code;
    }

    /**
     * Retrieves the location of the museum.
     *
     * @return the location of the museum
     */
    public String GetLocation() {
        return this.Location;
    }

    /**
     * Retrieves the description of the museum.
     *
     * @return the description of the museum
     */
    public String GetDescription() {
        return this.Description;
    }

    /**
     * Retrieves the email of the museum.
     *
     * @return the email of the museum
     */
    public String GetEmail() {
        return this.Email;
    }

    /**
     * Retrieves the website link of the museum.
     *
     * @return the website link of the museum
     */
    public String GetLink() {
        return this.Link;
    }
}
