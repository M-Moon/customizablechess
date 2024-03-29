package pieces;

public class Pawn extends Piece
{
    private boolean hasMoved = false;

    /**
     * Constructor for the piece class. Colour is 0 for black or 1 for white, and movement is an array covering all directional movement. The first 4 numbers
     * refer to orthogonal movement, in the order up, right, down, left, and then the last 4 numbers refer to diagonal movement, starting from top-left
     * and also rotating clockwise.
     *
     * @param colour the colour of the piece, 0 or 1
     * @param movement the movement of the piece defined in a single-dimension array, first orthogonal movement and then diagonal.
     */
    public Pawn(Colour colour, int[] movement)
    {
        super(colour, movement);
        setPieceLetter("p");
    }

    // since the pawn has specific movement, we will be using this constructor. Probably a better design pattern for this kind of inheritance
    public Pawn(Colour colour)
    {
        super(colour);
        setMovement(new int[]{1, 0, 0, 0, 0, 0, 0, 0});
        setPieceLetter("p");
    }

    public boolean getHasMoved()
    {
        return hasMoved;
    }
}
