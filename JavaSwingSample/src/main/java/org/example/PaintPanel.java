package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {


    private Color color = Color.BLUE;
    private List<PixelColor> pixelColorList = new ArrayList<>();

    private boolean pressed = false;

    public PaintPanel(){

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                if(pressed){
                    int x = mouseEvent.getX();
                    int y = mouseEvent.getY();
                    pixelColorList.add(new PixelColor(x,y,color));
                    repaint(x,y,10,10);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
            }
        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();
                pixelColorList.add(new PixelColor(x,y,color));
                repaint();
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                pressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }

    public void setColor(Color color){
        if(color != null) {
            this.color = color;
        }
    }

    public void clear(){
        pixelColorList.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        for(PixelColor p : pixelColorList){
            g.setColor(p.color);
            g.fillOval(p.x,p.y,10,10);
        }
    }

    public class PixelColor{
        int x;
        int y;
        Color color;
        public PixelColor(int x, int y, Color color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
