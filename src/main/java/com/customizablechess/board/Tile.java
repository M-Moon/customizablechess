package com.customizablechess.board;

public class Tile {
    private final int[] coordinates;

    public Tile(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return this.coordinates;
    }
}
