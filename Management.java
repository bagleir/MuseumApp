import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.sql.ResultSetMetaData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import java.io.File;
import java.net.MalformedURLException;

public class Management {

    private static final String Url = "jdbc:mysql://localhost:3306/Museum";

    // Find the next available ID in the User table
    public static int FindID() {
        boolean test = false;
        int i =1;
        try (Connection conn = getConnection()) {
            String userQuery = "SELECT ID FROM User WHERE ID = ?";
            String userMQuery = "SELECT ID FROM UserM WHERE ID = ?";
            PreparedStatement userStmt = conn.prepareStatement(userQuery);
            PreparedStatement userMStmt = conn.prepareStatement(userMQuery);
            for(i =1;!test;i++){
                userStmt.setInt(1, i);
                userMStmt.setInt(1, i);
                ResultSet userResult = userStmt.executeQuery();
                ResultSet userMResult = userMStmt.executeQuery();
                if(!userResult.next()){
                    if(!userMResult.next()){
                        test = true;
                    }
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return i-1;
    }

    // Find the next available Code in the Museum table
    public static int FindCode() {
        boolean test = false;
        int i =1;
        try (Connection conn = getConnection()) {
            String userQuery = "SELECT Code FROM Museum WHERE Code = ?";
            PreparedStatement userStmt = conn.prepareStatement(userQuery);
            for(i =1;!test;i++){
                userStmt.setInt(1, i);
                ResultSet userResult = userStmt.executeQuery();
                if(!userResult.next()){
                    test = true;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return i-1;
    }

    // Find the next available Identifier in the Art table
    public static int FindIdentifier() {
        boolean test = false;
        int i =1;
        try (Connection conn = getConnection()) {
            String userQuery = "SELECT Identifier FROM Art WHERE Identifier = ?";
            PreparedStatement userStmt = conn.prepareStatement(userQuery);
            for(i =1;!test;i++){
                userStmt.setInt(1, i);
                ResultSet userResult = userStmt.executeQuery();
                if(!userResult.next()){
                    test = true;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return i-1;
    }

    // Add a User to the User table
    public static void AddUser(User user) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO User (ID, Name, Password, Email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, FindID());
                statement.setString(2, user.GetName());
                statement.setString(3, user.GetPassword());
                statement.setString(4, user.GetEmail());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Element inserted into User successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddUserM(UserM userM) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO UserM (ID, Name, Password, Email, Museum) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, FindID());
                statement.setString(2, userM.GetName());
                statement.setString(3, userM.GetPassword());
                statement.setString(4, userM.GetEmail());
                statement.setInt(5, userM.GetMuseum().GetCode());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Element inserted into UserM successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddMuseum(Museum museum) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO Museum (Code, Name, Location, Description, Email, Link) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, museum.GetCode());
                statement.setString(2, museum.GetName());
                statement.setString(3, museum.GetLocation());
                statement.setString(4, museum.GetDescription());
                statement.setString(5, museum.GetEmail());
                statement.setString(6, museum.GetLink());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Element inserted into Museum successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String AddArt(Art art) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO Art (Identifier, Name, Description, Link, Picture, Museum) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, FindIdentifier());
                statement.setString(2, art.GetName());
                statement.setString(3, art.GetDescription());
                statement.setString(4, art.GetLink());
                String path = Data.saveImage(art.GetPicture(),"Picture");
                statement.setString(5, path);
                if(art.GetMuseum() != null){
                    statement.setInt(6, art.GetMuseum().GetCode());
                }
                else{
                    statement.setInt(6, 0);
                }

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Element inserted into Art successfully.");
                }
                return path;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void TruncateTable(String tableName) {
        try (Connection connection = getConnection()) {
            String query = "TRUNCATE TABLE " + tableName;

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
                System.out.println("Table " + tableName + " truncated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(Url, Main.Username, Main.Password);
    }
    
    public static boolean ValidUser(String Name, String Password){
        try (Connection connection = getConnection()) {
            String query = "Select Name From User Where Name = ? and Password = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, Name);
                statement.setString(2, Password);
                ResultSet userResult = statement.executeQuery();
                if(userResult.next()){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean ValidUserM(String Name, String Password){
        try (Connection connection = getConnection()) {
            String query = "Select Name From UserM Where Name = ? and Password = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, Name);
                statement.setString(2, Password);
                ResultSet userResult = statement.executeQuery();
                if(userResult.next()){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public BufferedImage convertBytesToImage(byte[] imageBytes) {
        BufferedImage image = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            image = ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static Museum getRowMuseum(String name) {
        List<String> rowData = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Museum WHERE Name = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            String data = resultSet.getString(i);
                            rowData.add(data);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Museum m = new Museum(Integer.parseInt(rowData.get(0)),rowData.get(1),rowData.get(2),rowData.get(3),rowData.get(4),rowData.get(5));
        return m;
    }

    public static Museum getRowCodeM(int code) {
        List<String> rowData = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Museum WHERE Code = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, code);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            String data = resultSet.getString(i);
                            rowData.add(data);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Museum m = new Museum(Integer.parseInt(rowData.get(0)),rowData.get(1),rowData.get(2),rowData.get(3),rowData.get(4),rowData.get(5));
        return m;
    }

    public static Art getRowArt(String name) {
        List<String> rowData = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Art WHERE Name = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            String data = resultSet.getString(i);
                            rowData.add(data);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Art a = new Art(Integer.parseInt(rowData.get(0)),rowData.get(1),Data.CreateImage(rowData.get(4)),getRowCodeM(Integer.parseInt(rowData.get(5))),rowData.get(2),rowData.get(3));
        return a;
    }

    public static void retrieveFilePathsFromDatabase(){
        String query = "SELECT Picture FROM Art";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String filePath = resultSet.getString("Picture");
                MainWindow.addImageToViews(filePath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void retrieveNameMuseum(){
        String query = "SELECT Name FROM Museum";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                MainWindow.entries.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String StoreName(String filepath) {
        String name = "";
        String query = "SELECT Name FROM Art where Picture = '" + filepath+"';";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if(resultSet.next()) {
                name = resultSet.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}