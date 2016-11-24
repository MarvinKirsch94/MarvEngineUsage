package com.marvinkirsch.core.engine;

import java.awt.event.KeyEvent;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public class GameContainer implements Runnable {

    private Thread thread;
    private AbstractGame game;
    private Window window;
    private Renderer renderer;
    private Input input;

    private int width = 320, height = 240;
    private float scale = 2.0f;
    private String title = "MarvEngine v0.0 by Marvin Kirsch";
    private double frameCap = 1.0 / 60.0;
    private boolean isRunning = false;

    private boolean lockFrameRate = false;
    private boolean lightEnable = false;
    private boolean dynamicLights = false;
    private boolean clearScreen = false;
    private boolean debug = false;

    public GameContainer(AbstractGame game) {
        this.game = game;
    }

    public void start() {
        if (isRunning)
            return;

        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();
    }

    public void stop() {
        if (!isRunning)
            return;

        isRunning = false;
    }

    public void run() {
        isRunning = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;
        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (isRunning) {
            boolean render = !lockFrameRate;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= frameCap) {
                if (input.isKeyPressed(KeyEvent.VK_F2)) debug = !debug;

                game.update(this, (float) frameCap);
                input.update();
                unprocessedTime -= frameCap;
                render = true;

                if (frameTime >= 1) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }
            }

            if (render) {

                if (clearScreen) renderer.clear();

                game.render(this, renderer);

                if (lightEnable || dynamicLights) {
                    renderer.drawLightArray();
                    renderer.flushMaps();
                }

                renderer.setTranslate(false);

                if (debug) renderer.drawString("FPS-" + fps, 0xffffffff, 0, 0);

                window.update();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        cleanUp();
    }

    public AbstractGame getGame() {
        return game;
    }

    public void setGame(AbstractGame game) {
        this.game = game;
    }

    public boolean isLightEnable() {
        return lightEnable;
    }

    public void setLightEnable(boolean lightEnable) {
        this.lightEnable = lightEnable;
    }

    public boolean isClearScreen() {
        return clearScreen;
    }

    public void setClearScreen(boolean clearScreen) {
        this.clearScreen = clearScreen;
    }

    private void cleanUp() {
        window.cleanUp();
    }

    public void setFrameCap(int number) {
        frameCap = 1.0f / number;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public boolean isDynamicLights() {
        return dynamicLights;
    }

    public void setDynamicLights(boolean dynamicLights) {
        this.dynamicLights = dynamicLights;
    }

    public Input getInput() {
        return input;
    }
}
