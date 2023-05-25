public class UserM {

    private final String Name;              
    private final int ID;    
    private final String Password;             
    private final String Email;
    private final Museum Museum;

    public UserM(int ID, String name, String password, String email,Museum museum){
        this.ID = ID;
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.Museum = museum;
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
    
    public Museum GetMuseum(){
        return this.Museum;
    }
}