package pieces;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.customizablechess.pieces.Colour;
import com.customizablechess.pieces.Piece;

public class PieceTests {

    @Test
    public void declareBasicKingPiece() {
        int[] movement = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Piece piece = new Piece("K", Colour.WHITE, movement);
        assertNotNull(piece);
    }
}
