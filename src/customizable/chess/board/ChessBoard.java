package customizable.chess.board;

import customizable.chess.pieces.*;

public class ChessBoard
{
    private Tile[] board;
    private char[] legalPieces = {'k', 'q', 'r', 'n', 'b', 'p'};

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

    // debugging method
    public void printTextBoard()
    {
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                System.out.print(board[i+j]);
            }
            System.out.print("\n");
        }
    }

    public void processFenString(String fen)
    {
        Tile[] tempBoard = new Tile[64];

        if (!checkFenStringValid(fen))
        {
            System.out.println("FEN is invalid");
            return;
        }

        int fenLocation = 0;
        for (int i = 0; i < 63; i++)
        {
            if (pieceTypeValid(fen.charAt(i)))
            {
                tempBoard[i] = new Tile(i, pieceFromChar(fen.charAt(fenLocation)));
            } else if (Character.isDigit(fen.charAt(fenLocation))) // if it is a number, which dictates moving forward the amount of squares specified
            {
                i += Character.getNumericValue(fen.charAt(fenLocation)); // move up the specified amount of squares
            }
            fenLocation++;
        }

        // form board
        int boardLocation = 0;
        String fenBoard = fen.split(" ")[0];
        for (int i = 0; i < fenBoard.length(); i++)
        {
            if (pieceTypeValid(fenBoard.charAt(i))) // if it is a valid piece, make current tile hold that piece
            {
                tempBoard[boardLocation] = new Tile(boardLocation, pieceFromChar(fenBoard.charAt(i)));
            } else if (Character.isDigit(fenBoard.charAt(i))) // if it is a number, which dictates moving forward the amount of squares specified
            {
                boardLocation += Character.getNumericValue(fenBoard.charAt(i)); // move up specified amount of squares
            }
        }
    }

    /**
     * Function designed to check the validity of a given fen string.
     * Based off of the function found in the Stockfish engine as of [April 14th, 2016]. Thanks Stockfish!
     *
     * @param fen a fen string
     * @return true if fen is valid, otherwise false
     */
    public boolean checkFenStringValid(String fen)
    {
        // splitting the fen string up and then separating into its constituent parts (halfmove and fullmove ignored currently)
        String[] fenSplit = fen.split(" ");
        String board = fenSplit[0];
        String side = fenSplit[1];
        String castleRights = fenSplit[2];
        String ep = fenSplit[3];

        // checking there are entries for board and blank
        if (board.isBlank() || side.isBlank())
            return false;

        //System.out.println("Board and side isn't blank");

        // empty entries for castle rights and en passant are acceptable, so filled in if not provided
        if (castleRights.isBlank())
            castleRights = "-";
        if (ep.isBlank())
            ep = "-";

        // checking side is valid
        if (!(side.equals("w") || side.equals("b")))
            return false;

        //System.out.println("side choice is valid");

        // checking castle rights is one of the acceptable variations.
        if (!(castleRights.equals("-") || castleRights.equals("K") || castleRights.equals("Kk")
            || castleRights.equals("Kkq") || castleRights.equals("Kq") || castleRights.equals("KQ")
            || castleRights.equals("KQk") || castleRights.equals("KQq") || castleRights.equals("KQkq")
            || castleRights.equals("k") || castleRights.equals("q") || castleRights.equals("kq")
            || castleRights.equals("Q") || castleRights.equals("Qk") || castleRights.equals("Qq")
            || castleRights.equals("Qkq")))
            return false;

        //System.out.println("Castle rights is valid");

        if (!(ep.equals("-")))
        {
            // checking ep string length is exactly 2
            if (ep.length() != 2)
                return false;
            // checking the letters given are between a & h
            if (!(ep.charAt(0) >= 'a' && ep.charAt(0) <= 'h'))
                return false;
            // checking something idk probably valid side thing i don't understand the ep thing wikipedia is bare empty
            if (!((side == "w" && ep.charAt(1) == '6') || (side == "b" && ep.charAt(1) == '3')))
                return false;
        }

        //System.out.println("ep is valid");

        // now for the board
        // counting the occurrences of characters such as slash and kings
        int slashCount = 0;
        int whiteKingCount = 0;
        int blackKingCount = 0;
        for (int i = 0; i < board.length(); i++)
        {
            if (board.charAt(i) == '/')
                slashCount++;

            if (!(board.charAt(i) == '/' || (Character.getNumericValue(board.charAt(i)) >= 1 && Character.getNumericValue(board.charAt(i)) <= 8) || pieceTypeValid(board.charAt(i))))
            {
                System.out.println("non-valid character found: " + board.charAt(i));
                return false;
            }

            if (board.charAt(i) == 'k')
                blackKingCount++;
            if (board.charAt(i) == 'K')
                whiteKingCount++;
        }
        // 7 slashes are required
        if (slashCount != 7)
            return false;
        // must be exactly 1 king per side, non-negotiable
        if (blackKingCount != 1 || whiteKingCount != 1)
            return false;

        //System.out.println("character count is valid");

        // could also do a piece count, but it actually complicates things with this project. Kinda defeats the purpose of customisability.

        return true;
    }

    // could be useful as default method, but maybe should be built up more fundamentally?
    private void populateBoardWithStartingPosition()
    {

    }

    private boolean pieceTypeValid(char p)
    {
        for (char c: legalPieces)
        {
            if (p == c || p == Character.toUpperCase(c))
                return true;
        }
        return false;
    }

    private Piece pieceFromChar(char p)
    {
        if (Character.isLowerCase(p))
            return new Pawn(0);
        return new Pawn(1);
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

    public Tile[] getBoard()
    {
        return board;
    }
}
