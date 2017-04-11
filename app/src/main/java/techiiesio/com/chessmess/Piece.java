package techiiesio.com.chessmess;

/**
 * Created by awing_000 on 4/10/2017.
 */

public class Piece
{
    protected char Color;	//Color of the piece ('B' or 'W')
    protected int xCoord;	//X coordinate of the piece
    protected int yCoord;	//Y coordinate of the piece
    protected boolean moved;	//Says whether or not the piece has been moved

    public Piece(char c, int x, int y)
    {
        Color = c;
        xCoord = x;
        yCoord = y;
        moved = false;
    }

    public void setColor(char c) {Color = c;}

    public void setCoords(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public void setMoved(boolean m)	{moved = m;}

    public char getColor() {return Color;}

    public int getX() {return xCoord;}

    public int getY() {return yCoord;}

    public boolean hasMoved() {return moved;}

    //Returns false if the move does not cause your king to be in check
    public boolean causesCheck(int x, int y, Board b)
    {
        //Make a copy of the board
        Piece[][] board = b.getBoard();
        //Get the white King
        King whiteKing = b.getKing('W');
        //Get the black King
        King blackKing = b.getKing('B');
        //board[y][x] = board[yCoord][xCoord];
        //board[yCoord][xCoord] = null;
        if(this.Color == 'W')
            if(!whiteKing.checkForCheck(whiteKing.xCoord, whiteKing.yCoord, b))
                return true;
            else
            if(!blackKing.checkForCheck(blackKing.xCoord, blackKing.yCoord, b))
                return true;

        return false;
    }
}