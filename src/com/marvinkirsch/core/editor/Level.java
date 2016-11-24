package com.marvinkirsch.core.editor;

import com.marvinkirsch.core.engine.GameContainer;
import com.marvinkirsch.core.engine.Renderer;

/**
 * @author Marvin Kirsch
 * @version 0.0
 *          created on 24.11.2016
 */
public class Level {

    private int levelW, levelH;
    private int[] tiles;

    private int tileW = 8, tileH = 8;

    public Level(int levelW, int levelH) {
        this.levelH = levelH;
        this.levelW = levelW;
        tiles = new int[levelW * levelH];
    }

    public void update(GameContainer gc, Renderer r) {

    }

    public void render(GameContainer gc, float dt) {
        for(int x = 0; x < levelW; x++) {
            for(int y = 0; y < levelH; y++) {

            }
        }
    }
}
