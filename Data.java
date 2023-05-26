import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * A class that contains utility methods and data for managing user information and file operations.
 */
public class Data {

    public static User currentUser;
    public static UserM currentUserM;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates user information for registration.
     *
     * @param Name      the user's name
     * @param Password1 the user's password
     * @param Password2 the confirmation of the user's password
     * @param Email     the user's email
     * @return true if the user information is valid, false otherwise
     */
    public static boolean Is_Valid(String Name, String Password1, String Password2, String Email) {
        if (Name.length() < 2 || Email.length() < 2 || Password1.length() < 2 || Password2.length() < 2 ||
                !EMAIL_PATTERN.matcher(Email).matches() || !Password1.equals(Password2)) {
            return false;
        }
        return true;
    }

    /**
     * Validates museum user information for registration.
     *
     * @param Name      the user's name
     * @param Password1 the user's password
     * @param Password2 the confirmation of the user's password
     * @param Email     the user's email
     * @param museum    the museum name
     * @return true if the user information is valid, false otherwise
     */
    public static boolean Is_ValidM(String Name, String Password1, String Password2, String Email, String museum) {
        if (Name.length() < 2 || Email.length() < 2 || Password1.length() < 2 || Password2.length() < 2 ||
                !EMAIL_PATTERN.matcher(Email).matches() || !Password1.equals(Password2) ||
                museum == null || museum.length() < 2) {
            return false;
        }
        return true;
    }

    /**
     * Validates museum information for adding a new museum.
     *
     * @param Name        the museum name
     * @param Description the museum description
     * @param Link        the museum website link
     * @param Location    the museum location
     * @param Email       the museum email
     * @return true if the museum information is valid, false otherwise
     */
    public static boolean CanAddMuseum(String Name, String Description, String Link, String Location, String Email) {
        if (Name.length() < 2 || Email.length() < 2 || Description.length() < 2 || Link.length() < 2 ||
                !EMAIL_PATTERN.matcher(Email).matches() || Location.length() < 2) {
            return false;
        }
        return true;
    }

    /**
     * Validates art information for adding a new art piece.
     *
     * @param Name     the art name
     * @param Description the art description
     * @param Link     the art image link
     * @param museum   the museum name
     * @return true if the art information is valid, false otherwise
     */
    public static boolean CanAddArt(String Name, String Description, String Link, String museum) {
        if (Name.length() < 2 || Description.length() < 2 || Link.length() < 2 ||
                museum == null || museum.length() < 2) {
            return false;
        }
        return true;
    }

    /**
     * Creates a BufferedImage from an image file.
     *
     * @param filePath the path to the image file
     * @return the BufferedImage object, or null if an error occurs
     */
    public static BufferedImage CreateImage(String filePath) {
        try {
            File file = new File(filePath);
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Saves an image to a specified directory.
     *
     * @param image     the BufferedImage object to save
     * @param directory the directory to save the image in
     * @return the file path of the saved image, or null if an error occurs
     */
    public static String saveImage(BufferedImage image, String directory) {
        try {
            // Create a unique file name based on the current timestamp
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = "image_" + timeStamp + ".png";

            // Create the directory if it doesn't exist
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Construct the file path
            Path filePath = dir.toPath().resolve(fileName);

            // Save the image to the file
            ImageIO.write(image, "png", filePath.toFile());

            // Return the new file path as a string
            return filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if an exception occurs
        }
    }

    /**
     * Creates a text file for storing art information.
     *
     * @param a the art object
     * @return the file path of the created text file
     */
    public static String Createfile(Art a) {
        // Create a file path based on the art's name with spaces replaced by underscores
        String filename = "file/Raport_" + a.GetName().replaceAll(" ", "_") + ".txt";
        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
        return filename;
    }

    /**
     * Writes art information to a text file.
     *
     * @param art      the art object
     * @param filePath the file path of the text file
     */
    public static void writeArtToFile(Art art, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Art Information
            writer.write("Art Information");
            writer.newLine();
            writer.write("----------------------------------------------");
            writer.newLine();
            writer.newLine();

            // Name
            writer.write("Name: " + art.GetName());
            writer.newLine();
            writer.newLine();

            // Description
            writer.write("Description:");
            writer.newLine();
            writer.write(art.GetDescription());
            writer.newLine();
            writer.newLine();

            // Link
            writer.write("Link: " + art.GetLink());
            writer.newLine();
            writer.newLine();

            // Museum Information
            writer.write("Museum Information");
            writer.newLine();
            writer.write("----------------------------------------------");
            writer.newLine();
            writer.newLine();

            // Museum Name
            writer.write("Name: " + art.GetMuseum().GetName());
            writer.newLine();
            writer.newLine();

            // Location
            writer.write("Location: " + art.GetMuseum().GetLocation());
            writer.newLine();
            writer.newLine();

            // Email
            writer.write("Email: " + art.GetMuseum().GetEmail());
            writer.newLine();
            writer.newLine();

            // Museum Link
            writer.write("Link: " + art.GetMuseum().GetLink());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing art information to the file: " + e.getMessage());
        }
    }
}
