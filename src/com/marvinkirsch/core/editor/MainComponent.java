package com.marvinkirsch.core.editor;

import com.marvinkirsch.core.engine.AbstractGame;
import com.marvinkirsch.core.engine.GameContainer;
import com.marvinkirsch.core.engine.Renderer;

/**
 * @author Marvin Kirsch
 * @version 0.0
 *          created on 24.11.2016
 */
public class MainComponent extends AbstractGame{

    public static void main(String args[]) {
        GameContainer gc = new GameContainer(new MainComponent());
        gc.setWidth(320);
        gc.setHeight(240);
        gc.setScale(2.5f);
        gc.setLockFrameRate(true);
        gc.setClearScreen(true);
        gc.start();
    }

    public MainComponent() {

    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer r) {

    }
}
