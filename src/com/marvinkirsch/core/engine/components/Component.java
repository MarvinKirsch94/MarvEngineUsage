package com.marvinkirsch.core.engine.components;

import com.marvinkirsch.core.engine.GameContainer;
import com.marvinkirsch.core.engine.Renderer;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public abstract class Component {

    protected String tag = null;
    public abstract void update(GameContainer gc, GameObject object, float dt);
    public abstract void render(GameContainer gc, Renderer r);

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
