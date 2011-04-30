import com.sun.tools.javac.comp.Todo;

import javax.transaction.xa.Xid;
import java.applet.Applet;
import java.awt.*;

public class Frogs extends Applet implements Runnable {
    //TODO figure out what all of these variables are and what they do
    int cnt;
    int speed = 35;
    int f;
    int c;
    int flyo = 1;
    int flyd = 1;
    int frogx = 1;
    int frogy = 1;
    int frogcnt = 0;
    int blink = 0;
    boolean jumpup = true;

    //class data definitions
    Image buffer;
    Graphics bufferG;

    //class method definitions
    //applet is initialized
    public void init() {
        buffer = createImage(this.getSize().width,this.getSize().height);
        bufferG = buffer.getGraphics();

        this.setBackground(Color.white);  //Background of applet
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        //TODO refactor this logic
        while(true) {
            repaint();
            try {
                Thread.sleep(speed);
                if(f > this.getSize().width) {
                    f = 0;
                    c = -700;
                }
                else {
                    f++;
                    c++;
                    flyo++;
                    flyd++;
                }
            }
            catch(InterruptedException e){
                //do nothing
            }
        }
    }

    public void update(Graphics g){
        paint(g);
    }

    public void paint(Graphics g) {
        bufferG.setColor(this.getBackground());
        startLandscape(bufferG,f);
        g.drawImage(buffer,5,5,null);
    }

    public void startLandscape(Graphics g, int n) {
        //TODO make all of these colors static and final
        Color skyColor = new Color(62,139,165);
        Color sunColor = new Color(254,202,61);
        Color groundColor = new Color(35,96,65);
        Color pondColor = new Color(4,43,86);
        Color pondSplashColor = new Color(60,140,167);
        Color frogBodyColor = new Color(121,146,63);
        Color lillypadColor = new Color(14,94,9);
        Color bushColor = new Color(83,160,80);
        Color berryColor = new Color(146,28,40);
        Color frogBlinkColor = new Color(96,162,100);

        //creates & colors the sky
        g.setColor(skyColor);
        g.fillRect(-5,0,800,200);


        //TODO create a drawSun method and draw half as many lines (make each line go all the way through the sun)
        //creates & colors the sun with sunrays
        g.setColor(sunColor);
        g.fillOval(40,40,60,60);
        //top line & continues drawing sunrays clockwise
        g.drawLine(70,70,70,10);
        g.drawLine(66,78,85,35);
        g.drawLine(68,68,122,20);
        g.drawLine(90,61,105,55);
        //bottom line
        g.drawLine(70,100,70,130);
        g.drawLine(96,80,106,83);
        g.drawLine(93,89,115,110);
        g.drawLine(81,96,84,105);
        //right line
        g.drawLine(100,70,135,70);
        g.drawLine(76,70,52,105);
        g.drawLine(72,75,20,110);
        g.drawLine(70,68,30,83);
        //left line
        g.drawLine(10,70,40,70);
        g.drawLine(45,58,32,53);
        g.drawLine(55,50,25,20);
        g.drawLine(60,49,53,35);


        //creates clouds
        drawClouds(g,100+c,50,30,30);
        drawClouds(g,300+c,30,30,30);
        drawClouds(g,600+c,40,30,30);

        //creates & fills the ground area
        g.setColor(groundColor);
        g.fillRect(0,200,800,300);

        //TODO create a loop that draws trees and only call drawTrees once
        //creates the tress by using a method
        drawTrees(g,768,195);
        drawTrees(g,768,200);

        drawTrees(g,718,185);
        drawTrees(g,718,180);

        drawTrees(g,668,170);
        drawTrees(g,668,165);

        drawTrees(g,618,180);
        drawTrees(g,618,175);

        drawTrees(g,568,185);
        drawTrees(g,568,190);

        drawTrees(g,518,170);
        drawTrees(g,518,165);

        drawTrees(g,468,195);
        drawTrees(g,468,200);

        drawTrees(g,418,185);
        drawTrees(g,418,180);

        drawTrees(g,368,170);
        drawTrees(g,368,165);

        drawTrees(g,318,185);
        drawTrees(g,318,180);

        drawTrees(g,268,195);
        drawTrees(g,268,200);

        drawTrees(g,218,180);
        drawTrees(g,218,175);

        drawTrees(g,168,170);
        drawTrees(g,168,165);

        drawTrees(g,118,185);
        drawTrees(g,118,180);

        drawTrees(g,68,170);
        drawTrees(g,68,165);

        drawTrees(g,18,185);
        drawTrees(g,18,190);

        //TODO create a Bush class
        //TODO create a drawBush method that will do all of this
        //creates berry bushes
        g.setColor(bushColor);
        g.fillOval(140,260,40,40);
        g.fillOval(160,250,40,50);
        g.fillOval(180,260,40,40);

        //creates the berries on the bush
        g.setColor(berryColor);
        g.fillOval(155,265,5,5);
        g.fillOval(150,278,5,5);
        g.fillOval(155,290,5,5);
        g.fillOval(167,275,5,5);
        g.fillOval(195,290,5,5);
        g.fillOval(183,255,5,5);
        g.fillOval(179,285,5,5);
        g.fillOval(186,270,5,5);
        g.fillOval(172,262,5,5);
        g.fillOval(197,265,5,5);
        g.fillOval(204,280,5,5);

        //TODO put this stuff in a Pond class
        //creates & colors the pond area
        g.setColor(pondColor);
        g.fillOval(400,300,450,160);

        //creates the lillypads on the pond
        g.setColor(lillypadColor);
        g.fillArc(450,330,45,16,335,320);

        //creates the flowers on the lillypads
        g.setColor(Color.pink);
        g.fillArc(465,325,10,13,150,180);
        g.fillArc(470,325,10,13,210,180);

        //TODO refactor this logic
        //creates small frog
        frogcnt++;
        if(frogcnt < 125) {
            //TODO put this stuff in a Frog class
            drawFrogs(g,100+frogx,400-frogy);
            if(frogy < 50){
                jumpup = false;
            }
            else {
                if(frogy > 100) {
                    jumpup = true;
                }
                frogx = frogx + 3;

                if(jumpup) {
                    frogy = frogy - 3;
                }
                else {
                    frogy = frogy + 3;
                }
            }
        }
        else if (frogcnt < 142){
            //TODO put this stuff in a Pond class
            g.setColor(Color.blue);
            g.fillArc(445,335,55,50,130,35);
            g.fillArc(460,330,55,50,80,35);
            g.fillArc(475,335,55,50,40,35);

            g.setColor(pondSplashColor);
            g.fillArc(445, 335, 50, 45, 130, 35);
            g.fillArc(460, 330, 50, 45, 80, 35);
            g.fillArc(475,335,50,45,40,35);
        }
        else {
            //TODO make this stuff part of the Frog class
                g.setColor(frogBodyColor);
                g.fillArc(707,335,22,17,360,180);
                //creates the frog eyes
                g.fillArc(710,332,7,10,28,180);
                g.fillArc(720,332,7,10,335,180);
                //creates the white parts of the eyes
                g.setColor(Color.white);
                g.fillOval(711, 332, 4, 4);
                g.fillOval(721, 332, 4, 4);
                //creates the black part of the eyes
                g.setColor(Color.black);
                g.fillOval(712, 333, 2, 2);
                g.fillOval(722,333,2,2);

            blink++;
            if (blink >= 35){
                g.setColor(frogBlinkColor);
                g.fillOval(711, 332, 4, 4);
                g.fillOval(721,332,4,4);

                if (blink == 45){
                    blink = 0;
                }
            }
        }

        drawFrogs(g, 300, 400);

        if ((420-flyo) > 323){
            g.setColor(Color.black);
            g.fillOval(430 - flyo, 300 + flyd, 8, 6);
            g.setColor(Color.white);
            g.fillOval(430 - flyo, 295 + flyd, 3, 6);
            g.fillOval(435-flyo, 295+flyd, 3, 6);
        }

        if(flyo == 94 && flyd == 94){
            g.setColor(Color.red);
            g.fillOval(320, 395, 15, 6);
        }
        if (flyo == 95 && flyd == 95){
            g.setColor(Color.red);
            g.fillOval(320, 395, 20, 6);            
        }
        if (flyo == 96 && flyd == 96){
            g.setColor(Color.red);
            g.fillOval(320, 395, 15, 6);
        }

    }

    public void drawClouds(Graphics g, int x, int y, int h, int w){
        //TODO create a Cloud class
        g.setColor(Color.white);
        g.fillArc(x, y, h, w, 45, 360);
        g.fillArc(x+20, y, h, w, 45, 360);
        g.fillArc(x+40, y, h, w, 45, 360);
    }

    public void drawTrees(Graphics g, int x, int y){
        //TODO create a Tree class
        //using the class will look like this new Tree(x, y);
        int t[] = {x, x-13, x+12};
        int r[] = {y, y+20, y+20};

        int x1[] = {x, x-10, x+10};
        int y1[] = {y-5, y+10, y+10};

        Color trunkColor = new Color(149, 106, 51);
        g.setColor(Color.green);
        g.fillPolygon(t, r, 3);
        g.fillPolygon(x1, y1, 3);

        g.setColor(trunkColor);
        g.fillRect(x-2, y+25, 4, 5);

    }

    //method definition that creates the frogs
    public void drawFrogs(Graphics g, int x, int y){
        //TODO create a Frog class
        int blink = 0;
        Color frogBodyColor = new Color(121,146,063);
        Color frogBellyColor = new Color(145,197,122);
        Color frogBlinkColor = new Color(96,162,100);
        g.setColor(frogBodyColor);

        //creates the frog's head
        g.fillOval(x+7,y-15,22,17);

        //creates the frog's body
        g.fillOval(x,y,35,27);

        //creates the frog's legs
        g.fillOval(x-5,y+2,12,25);
        g.fillOval(x+29,y+2,12,25);

        //creates the frog's feet
        g.fillOval(x-10,y+20,12,8);
        g.fillOval(x+34,y+20,12,8);

        //creates the frog eyes
        g.fillArc(x+10,y-18,7,10,28,180);
        g.fillArc(x+20,y-18,7,10,335,180);

        //creates the white parts of the eye
        g.setColor(Color.white);
        g.fillOval(x + 11, y - 18, 4, 4);
        g.fillOval(x+21,y-18,4,4);

        //creates the black parts of the eye
        g.setColor(Color.black);
        g.fillOval(x + 12, y - 17, 2, 2);
        g.fillOval(x+22,y-17,2,2);

        //creates the belly of the frog
        g.setColor(frogBellyColor);
        g.fillOval(x+5,y+5,25,17);

        //creates the nose of the frog
        g.setColor(Color.black);
        g.fillOval(x + 15, y - 10, 1, 1);
        g.fillOval(x+19,y-10,1,1);

        //creates the mouth of the frog
        g.drawLine(x+12,y-5,x+17,y-3);
        g.drawLine(x+17,y-3,x+22,y-5);
    }

}
