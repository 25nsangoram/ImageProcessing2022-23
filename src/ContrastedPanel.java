import processing.core.PImage;
public class ContrastedPanel extends Panel {//a subclass of Panel
    public ContrastedPanel(int _x, int _y, int _w, int _h) {//constructor for TintedPanel
        super(_x, _y, _w, _h);//invokes the Panel constructor
    }
    public void display() {//Overrides Panel's version of display-invokes Panel's version of display with Tint
        PImage newImg= getImage().copy();//ADDED
        newImg.loadPixels();
        for(int y=0;y<newImg.height;y++){
            for(int x=0;x<newImg.width;x++){
                int loc= x+(y*newImg.width);
                if(Main.app.brightness(newImg.pixels[loc])>190){
                    newImg.pixels[loc]=Main.app.color(225);
                } else{
                    newImg.pixels[loc]=Main.app.color(0,0);
                }
            }
        }
       newImg.updatePixels();//ADDED
        Main.app.image(newImg, getX(),getY(),getWidth(),getHeight());//ADDED
    }
}
