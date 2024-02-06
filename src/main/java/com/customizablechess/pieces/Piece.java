package com.customizablechess.pieces;

public class Piece {
    private final String pieceCode;
    private final Colour colour;
    private final int[] movementOffsets;

    public Piece(String pieceCode, Colour colour, int[] movementOffsets) {
        this.pieceCode = pieceCode;
        this.colour = colour;
        this.movementOffsets = movementOffsets;
    }

    public String getPieceCode() {
        return this.pieceCode;
    }

    public Colour getColour() {
        return this.colour;
    }

    public int[] getMovementOffsets() {
        return this.movementOffsets;
    }
}
