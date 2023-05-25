public class User {

    private final String Name;              
    private final int ID;    
    private final String Password;             
    private final String Email;            

    public User(int ID, String name, String password, String email){
        this.ID = ID;
        this.Name = name;
        this.Password = password;
        this.Email = email;
    }

    public String GetName(){
        return this.Name;
    }

    public int GetID(){
        return this.ID;
    }

    public String GetPassword(){
        return this.Password;
    }

    public String GetEmail(){
        return this.Email;
    }
}