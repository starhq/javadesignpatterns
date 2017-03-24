package com.iluwatar.doubledispatch;

/**
 * Created by starhq on 2017/3/24.
 */
public class SpaceStationIss extends SpaceStationMir {
    public SpaceStationIss(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
    }

    @Override
    public void collision(GameObject gameObject) {
        gameObject.collision(this);
    }
}
