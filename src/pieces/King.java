package pieces;

public class King extends Piece
{

    /**
     * Constructor for the piece class. Colour is 0 for black or 1 for white, and movement is an array covering all directional movement. The first 4 numbers
     * refer to orthogonal movement, in the order up, right, down, left, and then the last 4 numbers refer to diagonal movement, starting from top-left
     * and also rotating clockwise.
     *
     * @param colour the colour of the piece, 0 or 1 (black or white)
     * @param movement the movement of the piece defined in a single-dimension array, first orthogonal movement and then diagonal.
     */
    public King(Colour colour, int[] movement)
    {
        super(colour, movement);
        setPieceLetter("k");
    }

    /**
     * Constructor for the base king with its standard movement
     * @param colour the colour of the piece, 0 or 1 (black or white)
     */
    public King(Colour colour)
    {
        super(colour);
        setMovement(new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        setPieceLetter("k");
    }
}
