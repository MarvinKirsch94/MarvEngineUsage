package com.marvinkirsch.core.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public class Window {

    private JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;

    public Window(GameContainer gc) {

        image = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);

        canvas = new Canvas();
        Dimension s = new Dimension(gc.getWidth() * (int)gc.getScale(), gc.getHeight() * (int)gc.getScale());
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setPreferredSize(s);

        frame = new JFrame(gc.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.BLUE);

        canvas.createBufferStrategy(1);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void update() {
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void cleanUp() {
        g.dispose();
        bs.dispose();
        image.flush();
        frame.dispose();

    }
}
