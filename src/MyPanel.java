import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.*;
public class MyPanel extends JPanel implements MouseListener {

    LinkedList<Point> points;
    int pointRadius = 15;
    int outlineThickness = 2;
    MyPanel() {
        this.setPreferredSize(new Dimension(1000, 800));
        points = new LinkedList<Point>();
        this.setBackground(Color.black);
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {

             Graphics2D g2D = (Graphics2D) g;

             super.paint(g);

             drawPoints(g2D);

             //drawLines(g2D
        }
    private void drawPoints(Graphics2D g2D){
      Iterator i = points.listIterator();

      while(i.hasNext()){

          Point p = (Point) i.next();
          int x = (int) p.getX();
          int y = (int) p.getY();

          drawPoint(x,y,g2D);
      }

    }

    private void drawPoint(int x,int y, Graphics2D g2D){
    // draws a white centered point with gray outline at coords x,y wheras they define the top left corner of the containing square of the point/
        x -= pointRadius;
        y -= pointRadius;

        g2D.setPaint(Color.gray);
        g2D.fillOval(x,y,pointRadius,pointRadius);

        g2D.setPaint(Color.white);
        g2D.fillOval(x+outlineThickness,y+outlineThickness,pointRadius-(outlineThickness*2),pointRadius-(outlineThickness*2));



    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //when mouse is pressed add new point at position of mouseClick/
        System.out.println("lmao");

        int x = e.getX();
        int y = e.getY();

        points.add(new Point(x,y));

        repaint();

        }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}


