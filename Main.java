public class Main{

    public static void main(String[] args){
        // Launch the application by calling the launch() method of MaximizedWindow class
        /*String Description = "The Latvian National Museum of Art is the richest collection of national art in Latvia. It houses more than 52,000 works of art reflecting the development of professional art in the Baltic area and in Latvia from the middle of the 18th century until the present time.";
        String Link = "https://www.lnmm.lv/latvijas-nacionalais-makslas-muzejs";
        String Email = "ekskursijas@lnmm.lv";
        Museum m = new Museum(1,"Latvian National Museum of Art","Jaņa Rozentāla laukums, Central District, Riga, Latvia",Description,Email,Link);
        
        
        String N1 = "Under the banner of Lenin for socialist construction. Poster";
        String D1 = "Title: Under the banner of Lenin for socialist construction. Poster Date: 1930/1930 Physical Dimensions: w72.3 x h99.9 cm Painter: Gustavs Klucis Type: Litograph on paper Rights: LNMA";
        String L1 = "https://commons.wikimedia.org/wiki/File:Under_the_banner_of_Lenin_for_socialist_construction_Poster_-_Gustavs_Klucis.jpg";
        Art a1 = new Art(Management.FindIdentifier(),N1,Data.CreateImage("Pictures/imageG.png"),m,D1,L1);

        //Management.AddMuseum(m);
        Management.AddArt(a1);

        */
        
        
        
        
        
        Data.currentUser = null;
        Data.currentUserM = null;
        MainWindow.launch(MainWindow.class, args);
        
        //Management.TruncateTable("Museum");
        //Management.TruncateTable("User");
        //Management.TruncateTable("UserM");
        //Management.TruncateTable("Art");
    }
}