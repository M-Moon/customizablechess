package customizable.chess.board;

import customizable.chess.pieces.Piece;

public class Tile
{
    private final int tileCoord;
    private boolean isOccupied;
    private Piece pieceOnTile;

    public Tile(int tileCoord)
    {
        this.tileCoord = tileCoord;
        this.isOccupied = false;
    }

    public Tile(int tileCoord, Piece pieceOnTile)
    {
        this.tileCoord = tileCoord;
        this.isOccupied = true;
        this.pieceOnTile = pieceOnTile;
    }

    public int getTileCoord()
    {
        return this.tileCoord;
    }

    // private for external immutability
    private void setOccupied(boolean occupied)
    {
        this.isOccupied = occupied;
    }

    public boolean isOccupied()
    {
        return this.isOccupied;
    }

    public void placePieceOnTile(Piece pieceToPlace)
    {
        this.pieceOnTile = pieceToPlace;
        setOccupied(true);
    }
}
