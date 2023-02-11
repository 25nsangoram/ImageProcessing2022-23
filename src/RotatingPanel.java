public class RotatingPanel extends Panel {//a subclass of Panel that overrides handleMouseClicked and display
    private boolean rotating;//instance variable- flag
    private float degrees;// instance variable-angle of rotation
    public RotatingPanel(int _x, int _y, int _w, int _h) {//constructor for TintedPanel
        super(_x, _y, _w, _h);//invokes Panel's version of contructor, this line is the first line in a subclass's constructor- a call to super
        rotating = false;
        degrees = 1;
    }
    public void display() {//instance methods
        if (!rotating) {
            super.display();//invoking a method of the super class
        } else {
            Main.app.push();
            Main.app.imageMode(Main.app.CENTER);
            int x = getX();
            int y = getY();
            Main.app.translate( x + getWidth()/2, y + getHeight()/2);
            Main.app.rotate(Main.app.radians(degrees));
            degrees += 10;
            setX(0);
            setY(0);
            super.display();
            setX(x);
            setY(y);
            Main.app.imageMode(Main.app.CORNER);
            Main.app.pop();
        }
        Main.app.stroke(210, 255, 156);
        Main.app.text("Click any perry in this row!", getWidth()/2, getHeight()/2);
    }
    public void handleMouseClicked(int mX, int mY) {
        if (mX>getX() && mX<(getX()+getWidth())&&
                mY>getY() && mY<(getY()+getHeight())) {
            rotating=!rotating;
        }
    }
}