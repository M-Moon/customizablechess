package customizable.chess.game;

import customizable.chess.board.ChessBoard;
import customizable.chess.board.Tile;

public class Game
{
    private ChessBoard board;

    public Game()
    {
        ChessBoard board = new ChessBoard();

        Tile testTile = board.getTileAtPosition(6, 6);
        //System.out.println("The tile at rank 6, file 6 is: " + testTile);
        //System.out.println("and its coordinate is: " + testTile.getTileCoord());

        board.processFenString("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");

        board.printTextBoard();
    }

    public ChessBoard getBoard()
    {
        return board;
    }

    public static void main(String[] args)
    {
        Game mainGame = new Game();
    }
}
