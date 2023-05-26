public class Main{

    public static void main(String[] args){
        if (args.length < 2) {
            System.err.println("Two obligatory string parameters are required.");
            System.exit(1);
        }
        Data.currentUser = null;
        Data.currentUserM = null;
        MainWindow.launch(MainWindow.class, args);
        
        //Management.TruncateTable("Museum");
        //Management.TruncateTable("User");
        //Management.TruncateTable("UserM");
        //Management.TruncateTable("Art");
    }
}