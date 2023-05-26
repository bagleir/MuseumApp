/**
 * The `AddArt` class provides a user interface for adding a new work of art.
 * It allows users to input information such as the name, description, link, and picture of the artwork.
 * The class utilizes JavaFX for creating the graphical user interface.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.image.BufferedImage;

public class AddArt {

    private static String path = "";

    /**
     * Displays the "Add Art" user interface window.
     * Allows users to input information about a new artwork and choose an image file for the artwork.
     */
    public static void show() {
        Stage stage = new Stage();
        stage.setTitle("Add Art");

        // Create text fields and buttons
        TextField textFieldN = new TextField("Enter Name of the work of art");
        TextField textFieldD = new TextField("Enter Description of the work of art");
        TextField textFieldL = new TextField("Enter Link to an information page");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(MainWindow.entries);

        Button fileChooserButton = new Button("Choose a Picture");
        fileChooserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Create a FileChooser object
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select a Picture");

                // Show the file chooser dialog and get the selected file
                File selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null) {
                    path = selectedFile.getAbsolutePath();
                }
            }
        });
        Button actionButton = new Button("Validate");
        Button closeButton = new Button("Close");

        // Action to be performed when the "Validate" button is clicked
        actionButton.setOnAction(event -> {
            BufferedImage image = Data.CreateImage(path);
            if (image != null) {
                if (Data.CanAddArt(textFieldN.getText(), textFieldD.getText(), textFieldL.getText(), comboBox.getValue())) {
                    Museum museum = Management.getRowMuseum(comboBox.getValue());
                    Art artwork = new Art(Management.FindIdentifier(), textFieldN.getText(), image, museum, textFieldD.getText(), textFieldL.getText());
                    String newPath = Management.AddArt(artwork);
                    VBox artworkPane = MainWindow.addImageToViews(newPath);
                    MainWindow.imagePane.getChildren().add(10, artworkPane);
                    stage.close();
                }
            }
        });

        // Action to be performed when the "Close" button is clicked
        closeButton.setOnAction(event -> stage.close());

        // Create a vertical box layout and add the elements to it
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(actionButton, textFieldN, textFieldD, textFieldL, comboBox, fileChooserButton, closeButton);

        // Create a scene with the vertical box layout and set it to the stage
        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add(AddArt.class.getResource("/custom-theme.css").toExternalForm());
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }
}
