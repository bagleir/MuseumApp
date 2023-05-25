public class Museum {

    private final int Code;
    private final String Name;
    private final String Location;
    public final String Description;
    private final String Email;
    private final String Link;

    public Museum(int code,String name,String location,String description,String email, String link){
        this.Code = code;
        this.Name = name;
        this.Location = location;
        this.Description = description;
        this.Email = email;
        this.Link = link;
    }
    
    public String GetName(){
        return this.Name;
    }

    public int GetCode(){
        return this.Code;
    }

    public String GetLocation(){
        return this.Location;
    }

    public String GetDescription(){
        return this.Description;
    }
    
    public String GetEmail(){
        return this.Email;
    }

    public String GetLink(){
        return this.Link;
    }


}