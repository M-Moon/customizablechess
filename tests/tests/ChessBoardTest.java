package tests;

import board.ChessBoard;
import board.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    void checkFenStringValid() {
        ChessBoard board = new ChessBoard();

        String fen1 = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        assertEquals(true, board.checkFenStringValid(fen1));

        String fen2 = "rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2";
        assertEquals(true, board.checkFenStringValid(fen2));

        String fen3 = "rnbqkbnr/pp1ppppp/10/2p5/4P3/5N2/PPPP10PPP/RNBQKB1R b KQkq - 1 2"; // added incorrect numbers in the spacings
        assertEquals(false, board.checkFenStringValid(fen3));

        String fen4 = "rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b Qk - 1 2"; // removed K and q from end of FEN
        assertEquals(false, board.checkFenStringValid(fen4));

        String fen5 = "rnbqbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQB1R b KQkq - 1 2"; // no kings for either side
        assertEquals(false, board.checkFenStringValid(fen5));
    }

    @Test
    void getBoard() {
        ChessBoard board = new ChessBoard();

        assertTrue(board.getBoard() != null && board.getBoard() instanceof Tile[]);
    }
}