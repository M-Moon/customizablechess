package customizable.chess.pieces;

public class Piece
{
    // the piece types, made readable in binary (Thanks Sebastian Lague!)
    public final static int None = 0;
    public final static int King = 1;
    public final static int Pawn = 2;
    public final static int Knight = 3;
    public final static int Bishop = 4;
    public final static int Rook = 5;
    public final static int Queen = 6;

    public final static int Black = 8;
    public final static int White = 16;

    // final for immutability
    private final int colour;
    private final int[] movement;

    public Piece(int colour, int[] movement)
    {
        this.colour = colour;
        this.movement = movement;
    }

    public int[] getMovement()
    {
        return this.movement;
    }

    public int getColour()
    {
        return this.colour;
    }


}