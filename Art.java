import java.awt.image.BufferedImage;

/**
 * The `Art` class represents an art object in the application.
 * It encapsulates the information related to the art, including its identifier, name, picture, museum, description, and link.
 */
public class Art {
    private final int Identifier;     // The unique identifier of the art
    private final String Name;        // The name of the art
    private final BufferedImage Picture;   // The picture/image of the art
    private final Museum Museum;      // The museum associated with the art
    public final String Description;  // The description of the art
    private final String Link;        // The link/reference to the art

    /**
     * Constructs an `Art` object with the specified information.
     *
     * @param identifier  The identifier of the art
     * @param name        The name of the art
     * @param picture     The picture/image of the art
     * @param museum      The museum associated with the art
     * @param description The description of the art
     * @param link        The link/reference to the art
     */
    public Art(int identifier, String name, BufferedImage picture, Museum museum, String description, String link) {
        this.Identifier = identifier;
        this.Name = name;
        this.Picture = picture;
        this.Museum = museum;
        this.Description = description;
        this.Link = link;
    }

    /**
     * Returns the identifier of the art.
     *
     * @return The identifier of the art
     */
    public int GetIdentifier() {
        return this.Identifier;
    }

    /**
     * Returns the name of the art.
     *
     * @return The name of the art
     */
    public String GetName() {
        return this.Name;
    }

    /**
     * Returns the picture/image of the art.
     *
     * @return The picture/image of the art
     */
    public BufferedImage GetPicture() {
        return this.Picture;
    }

    /**
     * Returns the museum associated with the art.
     *
     * @return The museum associated with the art
     */
    public Museum GetMuseum() {
        return this.Museum;
    }

    /**
     * Returns the description of the art.
     *
     * @return The description of the art
     */
    public String GetDescription() {
        return this.Description;
    }

    /**
     * Returns the link/reference to the art.
     *
     * @return The link/reference to the art
     */
    public String GetLink() {
        return this.Link;
    }
}
