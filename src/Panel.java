import processing.core.PImage;
public class Panel{//defining/creating the class
    private PImage img;
    private int x;//declare instance variables
    private int y;
    private int w;
    private int h;
    public Panel(int _x, int _y, int _w, int _h){//constructor
        x=_x;//initializing instance variables
        y=_y;
        w=_w;
        h=_h;
    }
    public void setupImage(String name){
        img= Main.app.loadImage(name);//ADDED
    }
    public void display(){//instance methods
        Main.app.image(img, x, y, w, h);
    }
    public void handleMouseClicked(int mX, int mY){
        if(mX>x&&mX<(x+w)&&mY>y&&mY<(y+h)){
            System.out.println("Mouse clicked");
        }
    }
    public PImage getImage(){
        return img;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return w;
    }
    public int getHeight(){
        return h;
    }
    public void setX(int _x){
        x=_x;
    }
    public void setY(int _y){
        y=_y;
    }
}