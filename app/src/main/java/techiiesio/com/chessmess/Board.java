package techiiesio.com.chessmess;

/**
 * Created by awing_000 on 4/10/2017.
 */

public class Board
{
    private Piece[][] board;
    private King whiteKing;
    private King blackKing;

    public Board()
    {
        board = new Piece[8][8];
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                board[i][i] = null;
        whiteKing = new King('W', 4, 7);
        blackKing = new King('B', 4, 0);
        board[7][4] = whiteKing;
        board[0][4] = blackKing;
        initBoard('W', 6, 7);
        initBoard('B', 1, 0);
    }

    //Initializes the board with the correct pieces in the correct spots
    public void initBoard(char c, int pawnY, int restY)
    {
        for(int i = 0; i < 8; i++)
            board[pawnY][i] = new Pawn(c, i, pawnY);
        board[restY][0] = new Rook(c, 0, restY);
        board[restY][7] = new Rook(c, 7, restY);
        board[restY][1] = new Knight(c, 1, restY);
        board[restY][6] = new Knight(c, 6, restY);
        board[restY][2] = new Bishop(c, 2, restY);
        board[restY][5] = new Bishop(c, 5, restY);
        board[restY][3] = new Queen(c, 3, restY);
    }


    public void makeMove(int startX, int startY, int endX, int endY)
    {
        boolean check = false;
        boolean checkmate = true;
        Piece piece = board[startY][startX];
        if(piece instanceof Pawn)
        {
            Pawn p = (Pawn) piece;
            if(p.isValid(endX, endY, this, false))
            {
                p.setCoords(endX, endY);
                p.setMoved(true);
                board[endY][endX] = p;
                board[startY][startX] = null;
                if(p.getColor() == 'W')
                {
                    if(p.yCoord == 0)
                    {
                        int choice = 0;
                        switch(choice)
                        {
                            case 0:
                                Queen q = new Queen('W', p.xCoord, p.yCoord);
                                q.setMoved(true);
                                board[p.yCoord][p.xCoord] = q;
                                if(q.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                                    check = true;
                                break;
                            case 1:
                                Knight kn = new Knight('W', p.xCoord, p.yCoord);
                                kn.setMoved(true);
                                board[p.yCoord][p.xCoord] = kn;
                                if(kn.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                                    check = true;
                                break;
                            case 2:
                                Bishop b = new Bishop('W', p.xCoord, p.yCoord);
                                b.setMoved(true);
                                board[p.yCoord][p.xCoord] = b;
                                if(b.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                                    check = true;
                                break;
                            case 3:
                                Rook r = new Rook('W', p.xCoord, p.yCoord);
                                r.setMoved(true);
                                board[p.yCoord][p.xCoord] = r;
                                if(r.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                                    check = true;
                                break;
                        }
                    }
                    else
                    {
                        if(p.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                            check = true;
                    }
                }
                else
                {
                    if(p.yCoord == 7)
                    {
                        int choice = 0;
                        switch(choice)
                        {
                            case 0:
                                Queen q = new Queen('B', p.xCoord, p.yCoord);
                                q.setMoved(true);
                                board[p.yCoord][p.xCoord] = q;
                                if(q.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                                    check = true;
                                break;
                            case 1:
                                Knight kn = new Knight('B', p.xCoord, p.yCoord);
                                kn.setMoved(true);
                                board[p.yCoord][p.xCoord] = kn;
                                if(kn.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                                    check = true;
                                break;
                            case 2:
                                Bishop b = new Bishop('B', p.xCoord, p.yCoord);
                                b.setMoved(true);
                                board[p.yCoord][p.xCoord] = b;
                                if(b.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                                    check = true;
                                break;
                            case 3:
                                Rook r = new Rook('B', p.xCoord, p.yCoord);
                                r.setMoved(true);
                                board[p.yCoord][p.xCoord] = r;
                                if(r.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                                    check = true;
                                break;
                        }
                    }
                    else
                    {
                        if(p.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                            check = true;
                    }
                }
            }
        }
        if(piece instanceof Rook)
        {
            Rook r = (Rook) piece;
            if(r.isValid(endX, endY, this, false))
            {
                r.setCoords(endX, endY);
                r.setMoved(true);
                board[endY][endX] = r;
                board[startY][startX] = null;
                if(r.getColor() == 'W')
                {
                    if(r.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                        check = true;
                }
                else
                {
                    if(r.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                        check = true;
                }
            }
        }
        if(piece instanceof Knight)
        {
            Knight kn = (Knight) piece;
            if(kn.isValid(endX, endY, this, false))
            {
                kn.setCoords(endX, endY);
                kn.setMoved(true);
                board[endY][endX] = kn;
                board[startY][startX] = null;
                if(kn.getColor() == 'W')
                {
                    if(kn.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                        check = true;
                }
                else
                {
                    if(kn.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                        check = true;
                }
            }
        }
        if(piece instanceof Bishop)
        {
            Bishop b = (Bishop) piece;
            if(b.isValid(endX, endY, this, false))
            {
                b.setCoords(endX, endY);
                b.setMoved(true);
                board[endY][endX] = b;
                board[startY][startX] = null;
                if(b.getColor() == 'W')
                {
                    if(b.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                        check = true;
                }
                else
                {
                    if(b.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                        check = true;
                }
            }
        }
        if(piece instanceof Queen)
        {
            Queen q = (Queen) piece;
            if(q.isValid(endX, endY, this, false))
            {
                q.setCoords(endX, endY);
                q.setMoved(true);
                board[endY][endX] = q;
                board[startY][startX] = null;
                if(q.getColor() == 'W')
                {
                    if(q.isValid(blackKing.xCoord, blackKing.yCoord, this, true))
                        check = true;
                }
                else
                {
                    if(q.isValid(whiteKing.xCoord, whiteKing.yCoord, this, true))
                        check = true;
                }
            }
        }
        if(piece instanceof King)
        {
            King k = (King) piece;
            if(k.isValid(endX, endY, this))
            {
                k.setCoords(endX, endY);
                k.setMoved(true);
                if(k.getColor() == 'W')
                    whiteKing.setCoords(endX, endY);
                else
                    blackKing.setCoords(endX, endY);
                if(endX == startX + 2)
                {
                    Rook r = (Rook) board[startY][7];
                    r.setCoords(startY, 5);
                    r.setMoved(true);
                    board[startY][5] = r;
                    board[startY][7] = null;
                }
                else if(endX == startX - 2)
                {
                    Rook r = (Rook) board[startY][0];
                    r.setCoords(startY, 3);
                    r.setMoved(true);
                    board[startY][3] = r;
                    board[startY][0] = null;
                }
                board[endY][endX] = k;
                board[startY][startX] = null;
            }
        }
        if(check)
        {
            for(int i = 0; i < 8; i++)
                for(int j = 0; j < 8; j++)
                {
                    if(board[i][j] != null && board[i][j].getColor() != piece.getColor())
                    {
                        if(board[i][j] instanceof Pawn)
                        {
                            Pawn pawn = (Pawn) board[i][j];
                            if(pawn.hasValid(this))
                                checkmate = false;
                        }
                        if(board[i][j] instanceof Rook)
                        {
                            Rook rook = (Rook) board[i][j];
                            if(rook.hasValid(this))
                                checkmate = false;
                        }
                        if(board[i][j] instanceof Knight)
                        {
                            Knight knight = (Knight) board[i][j];
                            if(knight.hasValid(this))
                                checkmate = false;
                        }
                        if(board[i][j] instanceof Bishop)
                        {
                            Bishop bishop = (Bishop) board[i][j];
                            if(bishop.hasValid(this))
                                checkmate = false;
                        }
                        if(board[i][j] instanceof Queen)
                        {
                            Queen queen = (Queen) board[i][j];
                            if(queen.hasValid(this))
                                checkmate = false;
                        }
                        if(board[i][j] instanceof King)
                        {
                            King king = (King) board[i][j];
                            if(king.hasValid(this))
                                checkmate = false;
                        }
                    }
                }
            if(checkmate)
                System.out.println("Checkmate");
            else
                System.out.println("Check");
        }
    }

    public Piece[][] getBoard() {return board;}

    public King getKing(char c)
    {
        if(c == 'W')
            return whiteKing;
        else
            return blackKing;
    }

    public void printBoard()
    {
        for(int y = 0; y < 8; y++)
        {
            for(int x = 0; x < 8; x++)
            {
                Piece p = board[y][x];
                if(p == null)
                    System.out.print(" ");
                else
                {
                    if(p instanceof Pawn)
                        System.out.print("P");
                    if(p instanceof Rook)
                        System.out.print("R");
                    if(p instanceof Knight)
                        System.out.print("N");
                    if(p instanceof Bishop)
                        System.out.print("B");
                    if(p instanceof Queen)
                        System.out.print("Q");
                    if(p instanceof King)
                        System.out.print("K");
                }
            }
            System.out.println("");
        }
    }
}