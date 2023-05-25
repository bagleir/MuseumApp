import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.property.SimpleBooleanProperty;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class MainWindow extends Application {

    private static final int MAX_IMAGES = 11;
    private static final int IMAGES_PER_ROW = 3;
    public static SimpleBooleanProperty isLoggedIn = new SimpleBooleanProperty(false);
    public static List<VBox> imageViews = new ArrayList<>();
    private static Stage primaryStage;
    private static Stage secondaryStage;
    public static final List<String> entries = new ArrayList<>();
    public static FlowPane imagePane = new FlowPane(Orientation.HORIZONTAL, 10, 10);

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Create buttons
        this.primaryStage = primaryStage;
        Management.retrieveFilePathsFromDatabase();
        Button button1 = new Button("Login to the application");
        Button button2 = new Button("Create a User account");
        Button button3 = new Button("Create a proffessional account");
        Button closeButton = new Button("Close");

        // Create HBox for buttons
        HBox buttonBox = new HBox(button1, button2, button3);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);

        // Create FlowPane for images
        imagePane.setAlignment(Pos.TOP_CENTER);
        imagePane.setPrefWrapLength(700);

        button2.setOnAction(event -> {
            CreateAccount.show();
        });

        button3.setOnAction(event -> {
            CreateAccountM.show();
        });

        button1.setOnAction(event -> {
            Login.show();
        });


        imagePane.getChildren().addAll(imageViews);
        Management.retrieveNameMuseum();

        // Create ScrollPane for image pane
        ScrollPane scrollPane = new ScrollPane(imagePane);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Create VBox for the layout
        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Create the scene
        Scene scene = new Scene(root);
    
        // Bind the visibility of buttonBox and scrollPane to isLoggedIn property
        buttonBox.visibleProperty().bind(isLoggedIn.not());
        scrollPane.visibleProperty().bind(isLoggedIn);

        closeButton.setOnAction(event -> {
            primaryStage.close(); // Close the primary stage
        });

        TextField searchField = new TextField("Search...");
        //searchField.setPromptText("Search...");

        // Add a listener to the search field to filter the FlowPane when the text changes
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Filter the buttons in the FlowPane based on the search text
            for (VBox vbox : imageViews) {
                Button button = (Button) vbox.getChildren().get(1);
                if (button.getText().toLowerCase().contains(newValue.toLowerCase())) {
                    vbox.setVisible(true);
                    if (!imagePane.getChildren().contains(vbox)) {
                        imagePane.getChildren().remove(vbox);
                        imagePane.getChildren().add(0, vbox);
                    }
                } else {
                    vbox.setVisible(false);
                    imagePane.getChildren().remove(vbox);
                }
            }
        });


        // Create HBox for search field
        HBox searchBox = new HBox(searchField);
        searchBox.setSpacing(10);
        searchBox.setAlignment(Pos.CENTER);

        searchBox.visibleProperty().bind(isLoggedIn);

        // Add the buttonBox and scrollPane to the root VBox
        root.getChildren().addAll(buttonBox,searchBox, scrollPane,closeButton);

        // Set the scene to the stage and maximize the window
        scene.getStylesheets().add(getClass().getResource("/custom-theme.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static VBox addImageToViews(String filePath) {
        File file = new File(filePath);
        try {
            String fileUrl = file.toURI().toURL().toString();
            Image image = new Image(fileUrl);

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);
            String name = Management.StoreName(filePath);

            Button titleButton = new Button(name); // Replace with your desired title

            VBox imageBox = new VBox(imageView, titleButton);
            imageBox.setAlignment(Pos.CENTER);
            imageBox.setSpacing(10);

            imageViews.add(imageBox);
            titleButton.setOnAction(event -> openNewWindow(name,filePath));
            return imageBox;
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return null;
    }

    private static void openNewWindow(String windowTitle,String filePath) {
        secondaryStage = new Stage();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Text nameText = new Text(windowTitle);
        nameText.setStyle("-fx-fill: red;-fx-font-size: 19px; -fx-font-weight: bold;");

        Button RepportButton = new Button("Generate a rapport");
        Button closeButton = new Button("Close");
        Art a = Management.getRowArt(windowTitle);

        // Add image view to display the picture of the art
        ImageView imageView = new ImageView(filePath);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(600);
        imageView.setFitHeight(450);


        // Add text view to display the description of the art
        Text descriptionText = new Text("Description : "+a.GetDescription()+"\n\n\nThis work of art is currently in the museum : "+a.GetMuseum().GetName() +" \n\nWich is located at : "+a.GetMuseum().GetLocation() + "\n\n\nFeel free to generate a report to have more information like contact Email or link to more data.");
        descriptionText.setWrappingWidth(400);
        descriptionText.setTextAlignment(TextAlignment.JUSTIFY);
        descriptionText.setStyle("-fx-fill: red;-fx-font-size: 14px");

        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(10);

        RepportButton.setOnAction(event -> {
            String FilePath = Data.Createfile(a);
            Data.writeArtToFile(a,FilePath);
        });
        if (Data.currentUser == null) {
            Button AddM = new Button("Add a Museum");
            AddM.setOnAction(event -> {
                AddMuseum.show();
            });
            Button AddA = new Button("Add a work of Art");
            buttonsBox.getChildren().add(AddA);
            buttonsBox.getChildren().add(AddM);
            AddA.setOnAction(event -> {
                AddArt.show();
            });
        }
        // Add hyperlink to display the link of the art

        vbox.getChildren().addAll(nameText, imageView, descriptionText, RepportButton, buttonsBox,closeButton);
        closeButton.setOnAction(event -> {
            primaryStage.show(); // Show the primary stage
            secondaryStage.close();
        });
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(AddArt.class.getResource("/custom-theme.css").toExternalForm());
        secondaryStage.setScene(scene);
        secondaryStage.setTitle(windowTitle);
        secondaryStage.setOnCloseRequest(event -> primaryStage.show()); // Show the primary stage on close

        primaryStage.hide(); // Hide the primary stage
        secondaryStage.show(); // Show the secondary stage


        secondaryStage.setMaximized(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}