package customizable.chess.graphics;

public class GraphicalBoard
{
    private final static int lightCol = 0;
    private final static int darkCol = 1;

    public GraphicalBoard()
    {

    }

    public void createGraphicalBoard()
    {
        for (int rank = 0; rank < 8; rank++)
        {
            for (int file = 0; rank < 8; rank++)
            {
                boolean isLightSquare = (file + rank) % 2 == 0;

                int squareColour = (isLightSquare) ? lightCol : darkCol;
                drawSquare(squareColour);
            }
        }
    }

    private void drawSquare(int squareColour)
    {

    }
}
