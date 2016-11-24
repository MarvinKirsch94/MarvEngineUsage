package com.marvinkirsch.core.engine;

import java.awt.event.*;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public class Input implements KeyListener, MouseListener, MouseMotionListener {

    private GameContainer gc;

    private boolean[] keys = new boolean[256];
    private boolean[] keysLast = new boolean[256];

    private boolean[] buttons = new boolean[256];
    private boolean[] buttonsLast = new boolean[256];

    private int mouseX, mouseY;

    public Input(GameContainer gc) {
        this.gc = gc;
        gc.getWindow().getCanvas().addKeyListener(this);
        gc.getWindow().getCanvas().addMouseListener(this);
        gc.getWindow().getCanvas().addMouseMotionListener(this);
    }

    public void update() {
        keysLast = keys.clone();
        buttons = buttons.clone();
    }

    public boolean isKey(int keyCode) {
        return keys[keyCode];
    }

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isKeyReleased(int keyCode) {
        return !keys[keyCode] && keysLast[keyCode];
    }

    public boolean isButton(int button) {
        return buttons[button];
    }

    public boolean isButtonPressed(int button) {
        return buttons[button] && !buttonsLast[button];
    }

    public boolean isButtonReleased(int button) {
        return !buttons[button] && buttonsLast[button];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int)(e.getX() / gc.getScale());
        mouseY = (int)(e.getY() / gc.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX() / gc.getScale());
        mouseY = (int)(e.getY() / gc.getScale());
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
}
