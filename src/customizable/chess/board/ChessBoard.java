package customizable.chess.board;

public class ChessBoard
{
    private Tile[] board;

    public ChessBoard()
    {
        board = new Tile[64];
        formEmptyBoard();
    }

    // is forming empty board necessary?
    private void formEmptyBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            board[i] = new Tile(i);
        }
    }

    // could be useful as default method, but maybe should be built up more fundamentally?
    private void populateBoardWithStartingPosition()
    {

    }

    /**
     * Returns tile at desired rank and file by calculating its whereabouts in the board array.
     * This is achieved by starting from 0 (first array item) and adding 8 to get to the beginning of the desired rank.
     * The file number is then added, but -1 to compensate for the fact we started on the first item (technically starting on '1') and avoid overshooting.
     *
     * @param rank
     * @param file
     * @return
     */
    public Tile getTileAtPosition(int rank, int file)
    {
        int tilePos = (8 * (rank-1)) + (file - 1);
        return board[tilePos];
    }
}
