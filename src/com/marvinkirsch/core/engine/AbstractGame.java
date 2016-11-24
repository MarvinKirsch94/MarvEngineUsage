package com.marvinkirsch.core.engine;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public abstract class AbstractGame {

    public abstract void update(GameContainer gc, float dt);
    public abstract void render(GameContainer gc, Renderer r);
}
