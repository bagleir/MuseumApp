import java.awt.image.BufferedImage;


public class Art {

    private final int Identifier;
    private final String Name;
    private final BufferedImage Picture;
    private final Museum Museum;
    public final String Description;
    private final String Link;

    public Art(int identifier,String name,BufferedImage picture,Museum museum,String description, String link){
        this.Identifier = identifier;
        this.Name = name;
        this.Picture = picture;
        this.Museum = museum;
        this.Description = description;
        this.Link = link;
    }

    public int GetIdentifier(){
        return this.Identifier;
    }

    public String GetName(){
        return this.Name;
    }

    public BufferedImage GetPicture(){
        return this.Picture;
    }

    public Museum GetMuseum(){
        return this.Museum;
    }

    public String GetDescription(){
        return this.Description;
    }

    public String GetLink(){
        return this.Link;
    }
}