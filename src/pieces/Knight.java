package pieces;

// the tricky piece! movement might need an extra number on the end of the array for L-movement.
// making it so movement can be utterly customizable for all pieces can be added later. real pain though.

public class Knight extends Piece
{
    /**
     * Constructor for the piece class. Colour is 0 for black or 1 for white, and movement is an array covering all directional movement. The first 4 numbers
     * refer to orthogonal movement, in the order up, right, down, left, and then the last 4 numbers refer to diagonal movement, starting from top-left
     * and also rotating clockwise.
     *
     * @param colour the colour of the piece, 0 or 1
     * @param movement the movement of the piece defined in a single-dimension array, first orthogonal movement and then diagonal.
     */
    public Knight(Colour colour, int[] movement)
    {
        super(colour, movement);
        setPieceLetter("n");
    }

    public Knight(Colour colour)
    {
        super(colour);
        //setMovement(); // TO-DO: knight's movement has to be factored into movement system.
        setPieceLetter("n");
    }
}
