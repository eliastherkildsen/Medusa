package org.apollo.template.model;

public abstract class Food implements Eatable {
    private final int POINT;

    protected Food(int point) {
        this.POINT = point;
    }

    public int getPOINT() {
        return POINT;
    }
}