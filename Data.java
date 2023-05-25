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

public class Data{

    public static User currentUser;
    public static UserM currentUserM;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);


    public static boolean Is_Valid(String Name, String Password1, String Password2, String Email){
        if (Name.length() <2 || Email.length() <2 || Password1.length() <2 || Password2.length() <2 || !EMAIL_PATTERN.matcher(Email).matches() || !Password1.equals(Password2)){
            return false;
        }
        return true;
    }

    public static boolean Is_ValidM(String Name, String Password1, String Password2, String Email,String museum){
        if (Name.length() <2 || Email.length() <2 || Password1.length() <2 || Password2.length() <2 || !EMAIL_PATTERN.matcher(Email).matches() || !Password1.equals(Password2) || museum == null || museum.length() <2){
            return false;
        }
        return true;
    }

    public static boolean CanAddMuseum(String Name, String Description, String Link,String Location, String Email){
        if (Name.length() <2 || Email.length() <2 || Description.length() <2 || Link.length() <2 || !EMAIL_PATTERN.matcher(Email).matches() || Location.length() <2){
            return false;
        }
        return true;
    }

    public static boolean CanAddArt(String Name, String Description, String Link,String museum){
        if (Name.length() <2 || Description.length() <2 || Link.length() <2 || museum == null || museum.length() <2){
            return false;
        }
        return true;
    }

    public static BufferedImage CreateImage(String filePath) {
        try {
            File file = new File(filePath);
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        }
    }

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

    public static String Createfile(Art a) {
        // Create a file path based on the student's name with spaces replaced by underscores
        String filename = "file/Raport_" + a.GetName().replaceAll(" ", "_") + ".txt";
        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
        return filename;
    }

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