import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

/**
 * A class that represents a login window in a JavaFX application.
 */
public class Login {
    /**
     * Method to display the login window.
     */
    public static void show() {
        Stage stage = new Stage();
        stage.setTitle("Login");

        // Create text fields and buttons
        TextField textFieldN = new TextField("Enter Name");
        TextField textFieldP = new TextField("Enter Password");
        Button actionButton = new Button("Validate");
        Button closeButton = new Button("Close");

        // Action to be performed when the "Validate" button is clicked
        actionButton.setOnAction(event -> {
            if (Management.ValidUser(textFieldN.getText(), textFieldP.getText())) {
                Data.currentUser = new User(0, textFieldN.getText(), textFieldP.getText(), "");
                MainWindow.isLoggedIn.set(true);
                stage.close();
            } else if (Management.ValidUserM(textFieldN.getText(), textFieldP.getText())) {
                Data.currentUserM = new UserM(0, textFieldN.getText(), textFieldP.getText(), "", null);
                MainWindow.isLoggedIn.set(true);
                stage.close();
            }
        });

        // Action to be performed when the "Close" button is clicked
        closeButton.setOnAction(event -> stage.close());

        // Create a vertical box layout and add the elements to it
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(actionButton, textFieldN, textFieldP, closeButton);

        // Create a scene with the vertical box layout and set it to the stage
        Scene scene = new Scene(vbox, 300, 300);
        scene.getStylesheets().add(AddArt.class.getResource("/custom-theme.css").toExternalForm());
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }
}
