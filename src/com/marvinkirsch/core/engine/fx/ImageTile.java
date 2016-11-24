package com.marvinkirsch.core.engine.fx;

/**
 * @author Marvin Kirsch
 * @version 0.0
 */
public class ImageTile extends Image {
    public int tileWidth, tileHeight;

    public ImageTile(String path, int tileWidth, int tileHeight) {
        super(path);
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }
}
