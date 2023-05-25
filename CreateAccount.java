import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class CreateAccount{
    public static void show() {
        Stage stage = new Stage();
        stage.setTitle("Account");

        // Create text fields and buttons
        TextField textFieldN = new TextField("Enter Name");
        TextField textFieldE = new TextField("Enter Email");
        TextField textFieldP1 = new TextField("Enter Password");
        TextField textFieldP2 = new TextField("Confirm Password");
        Button actionButton = new Button("Validate");
        Button closeButton = new Button("Close");

        // Action to be performed when the "Validate" button is clicked
        actionButton.setOnAction(event -> {
            if(Data.Is_Valid(textFieldN.getText(),textFieldP1.getText(),textFieldP2.getText(),textFieldE.getText())){
                Data.currentUser = new User(Management.FindID(),textFieldN.getText(),textFieldP1.getText(),textFieldE.getText());
                Management.AddUser(Data.currentUser);
                MainWindow.isLoggedIn.set(true);
                stage.close();
            }
        });

        // Action to be performed when the "Close" button is clicked
        closeButton.setOnAction(event -> stage.close());

        // Create a vertical box layout and add the elements to it
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(actionButton,textFieldN,textFieldE,textFieldP1,textFieldP2,closeButton);

        // Create a scene with the vertical box layout and set it to the stage
        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add(AddArt.class.getResource("/custom-theme.css").toExternalForm());
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }
}