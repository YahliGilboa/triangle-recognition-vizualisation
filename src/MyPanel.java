import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class MyPanel extends JPanel implements MouseListener {

    LinkedList<Point> points;
    int pointDiameter = 15;
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

    private void drawPoints(Graphics2D g2D) {

        for (Point p : points) {

            int x = (int) p.getX();
            int y = (int) p.getY();

            drawPoint(x, y, g2D);
        }

    }

    private void drawPoint(int x, int y, Graphics2D g2D) {
        // draws a white centered point with gray outline at coords x,y wheras they define the top left corner of the containing square of the point/
        x -= pointDiameter/2;
        y -= pointDiameter/2;

        g2D.setPaint(Color.gray);
        g2D.fillOval(x, y, pointDiameter, pointDiameter);

        g2D.setPaint(Color.white);
        g2D.fillOval(x + outlineThickness, y + outlineThickness, pointDiameter - (outlineThickness * 2), pointDiameter - (outlineThickness * 2));


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //when mouse is pressed add new point at position of mouseClick/
        //System.out.println("lmao");

        int x = e.getX();
        int y = e.getY();

        Point pointClicked = onPoint(points,x,y);
        System.out.println(pointClicked);
        if(pointClicked==null)
            points.add(new Point(x, y));


        //if is right click and clicked on point delete it.
        if (e.getButton() == e.BUTTON2 && pointClicked != null){
        points.remove(pointClicked);
        }

        repaint();

    }

    private Point onPoint(LinkedList<Point> points, int x, int y) {
        //checks if the value of the point x,y is contained within one of the points in the linked list. if it is,
        // returns the point. else returns null

        for (Point p : points) {
            //as long as at least distance from center of points is a bit more than 1 diameter dont paint it.
            int pointLBorder = p.x-(pointDiameter+1);
            int pointRBorder = p.x+(pointDiameter+1);
            int pointTBorder = p.y-(pointDiameter+1);
            int pointBBorder = p.y+(pointDiameter+1);

            //checks if click is contained within point bounds, if it is returns the point.
            if (x > pointLBorder && x < pointRBorder) {
                if (y > pointTBorder && y < pointBBorder) {
                    return p;
                }
            }

        }

        return null;
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


