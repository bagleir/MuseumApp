public class Main{

    // Declare and initialize static variables to store the username and password
    public static String Username = "";
    public static String Password = "";

    public static void main(String[] args){
        // Check if the command-line arguments contain at least two parameters
        if (args.length < 2) {
            System.err.println("Two obligatory string parameters are required.");
            System.exit(1);
        }
        
        // Set the current user and current userM to null
        Data.currentUser = null;
        Data.currentUserM = null;
        
        // Assign the first command-line argument to the Username variable
        Username = args[0];
        
        // Assign the second command-line argument to the Password variable
        Password = args[1];
        
        // Launch the MainWindow class with the given command-line arguments
        MainWindow.launch(MainWindow.class, args);
    }
}