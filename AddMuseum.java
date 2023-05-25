import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class AddMuseum{
    public static void show() {
        Stage stage = new Stage();
        stage.setTitle("Add Museum");

        // Create text fields and buttons
        TextField textFieldN = new TextField("Enter Name of the Museum");
        TextField textFieldD = new TextField("Enter Description of the museum");
        TextField textFieldL = new TextField("Enter Link to the webside of the museum");
        TextField textFieldW = new TextField("Enter the location of the museum");
        TextField textFieldE = new TextField("Enter the email to contact the museum");
        Button actionButton = new Button("Validate");
        Button closeButton = new Button("Close");

        // Action to be performed when the "Validate" button is clicked
        actionButton.setOnAction(event -> {
            if(Data.CanAddMuseum(textFieldN.getText(),textFieldD.getText(),textFieldL.getText(),textFieldW.getText(),textFieldE.getText())){
                Museum m = new Museum(Management.FindCode(),textFieldN.getText(),textFieldW.getText(),textFieldD.getText(),textFieldE.getText(),textFieldL.getText());
                Management.AddMuseum(m);
                MainWindow.entries.add(textFieldN.getText());
                stage.close();
            }
        });

        // Action to be performed when the "Close" button is clicked
        closeButton.setOnAction(event -> stage.close());

        // Create a vertical box layout and add the elements to it
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(actionButton,textFieldN,textFieldD,textFieldL,textFieldW,textFieldE,closeButton);

        // Create a scene with the vertical box layout and set it to the stage
        Scene scene = new Scene(vbox, 400, 400);
        scene.getStylesheets().add(AddArt.class.getResource("/custom-theme.css").toExternalForm());
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }
}