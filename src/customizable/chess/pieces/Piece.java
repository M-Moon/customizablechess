package customizable.chess.pieces;

public abstract class Piece
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
    protected int[] movement;

    /**
     * Constructor for the piece class. Colour is 0 for black or 1 for white, and movement is an array covering all directional movement. The first 4 numbers
     * refer to orthogonal movement, in the order up, right, down, left, and then the last 4 numbers refer to diagonal movement, starting from top-left
     * and also rotating clockwise.
     *
     * @param colour the colour of the piece, 0 or 1
     * @param movement the movement of the piece defined in a single-dimension array, first orthogonal movement and then diagonal.
     */
    public Piece(int colour, int[] movement)
    {
        this.colour = colour;
        this.movement = movement;
    }

    public Piece(int colour)
    {
        this.colour = colour;
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