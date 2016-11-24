package com.marvinkirsch.core.engine.components;

import com.marvinkirsch.core.engine.GameContainer;
import com.marvinkirsch.core.engine.Renderer;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public abstract class State {

    protected ObjectManager manager = new ObjectManager();
    public abstract void update(GameContainer gc, float dt);
    public abstract void render(GameContainer gc, Renderer r);
    public abstract void dispose();

    public ObjectManager getManager() {
        return manager;
    }

    public void setManager(ObjectManager manager) {
        this.manager = manager;
    }
}
