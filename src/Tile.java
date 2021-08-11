public class Tile
{
    private int tileCoord;
    private boolean isOccupied;
    private Piece pieceOnTile;

    public Tile(int tileCoord)
    {
        this.tileCoord = tileCoord;
    }

    public Tile(int tileCoord, Piece pieceOnTile)
    {
        this.tileCoord = tileCoord;
        this.isOccupied = true;
        this.pieceOnTile = pieceOnTile;
    }

    public void setTileCoord(int tileCoord)
    {
        this.tileCoord = tileCoord;
    }

    public int getTileCoord()
    {
        return this.tileCoord;
    }

    public void setOccupied(boolean occupied)
    {
        this.isOccupied = occupied;
    }

    public boolean isOccupied()
    {
        return this.isOccupied;
    }
}
