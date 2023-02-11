import processing.core.PApplet;
import java.util.ArrayList;


public class Main extends PApplet {
    final int NUM_PANELS_HORIZONTAL = 7; //number of horizontal panels is 1, final because it's a message to the reader that the number doesn't change
    final int NUM_PANELS_VERTICAL = 7;//how many columns
    private ArrayList<Panel> panels;//array of panel objects
    public static PApplet app;//always get access to PApplet reference (to access processing application)
    public Main(){
        super();//constructor so we can assign a reference to "this" object
        app = this;
    }
    public static void main(String[] args){//entry point: starter
        PApplet.main("Main");
    }
//import processing.sound .*;
    //SoundFile beep;

    public void settings(){
        size(600,600);
    }
    public void setup() {
        //beep = new SoundFile(this, "perry.mp3");
        panels = new ArrayList<Panel>();///allocating memory for an array of one panel object- making a basket
        int index = 0;
        Panel p;// p a variable of type panel
        int w = width / NUM_PANELS_HORIZONTAL;
        int h = height / NUM_PANELS_VERTICAL;
        for (int i = 0; i < NUM_PANELS_VERTICAL; i++) {
            for (int j = 0; j < NUM_PANELS_HORIZONTAL; j++) {
                int x = j * w;
                int y = i * h;
                if (i == 0) {
                    p = new RotatingPanel(x, y, w, h);
                } else if (i == 2) {
                    p = new CustomPanel(x, y, w, h);
                } else if (i == 3) {
                    p = new RotatingPanel(x, y, w, h);
                } else if (i == 1) {
                    p = new ContrastedPanel(x, y, w, h);
                } else {
                    p = new CustomPanel(x, y, w, h);// instantiation, Panel is the constructor which has the same name as the class and assigned into p- take item off of the shelf
                }
                //} else {
                //Random r=new Random();//generate a random index into the word bank
                //int index=r.nextPanel(panels.length);
                //p=new panels[index](x, y, w, h);
                //}

                p.setupImage("data/perry.png");//invoking a method of the class Panel
                panels.add(p);//p is now an element of the panels array- putting item into the basket
                index++;
            }
        }
    }

    public void draw() {
        fancyBackground();
        for(Panel p:panels) {
            p.display();
        }
        //for (int i = 0; i < panels.size(); i++) {
            //panels.get(i).display();
        }

    public void mouseClicked() {
        for(Panel p:panels){//enhanced for loop
            p.handleMouseClicked(mouseX,mouseY);
        }
        //for (int i = 0; i < panels.size(); i++) {
            //panels.get(i).handleMouseClicked(mouseX,mouseY);
        //}
        //beep.play();
    }

    private void fancyBackground() {
        loadPixels();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixels[col + row * width] = color(140, col / 3, row / 2);
            }//implement your fancy image processing algorithm
        }
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixels[col + 100] = color(0);
            }
        }
        updatePixels();
    }
    public void keyPressed() {
        super.keyPressed();
        if (key == 's') {
            Panel hello= panels.remove(0);
            Panel goodBye= panels.remove(panels.size()-1);
            panels.add(0,goodBye);
            panels.add(hello);

        } //else if (key == 'r') {

        //}
    }
}