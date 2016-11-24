package com.marvinkirsch.core.engine.fx;

/**
 * Created by Marvin Kirsch on 21.11.2016.
 * Matrikelnr.: 11118687
 */
public class LightRequest {
    public Light light;
    public int x, y;

    public LightRequest(Light light, int x, int y) {
        this.light = light;
        this.x = x;
        this.y = y;
    }
}
