package techiiesio.com.chessmess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

public class ChessActivity extends AppCompatActivity {

    int[] images = {    // chess background images per each square of the chess board
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            };

    int[] pieces = {    // chess piece images per each square of the chess board
            R.drawable.black_rook, R.drawable.black_knight, R.drawable.black_bishop, R.drawable.black_queen,
            R.drawable.black_king, R.drawable.black_bishop, R.drawable.black_knight, R.drawable.black_rook,
            R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn,
            R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            -1, -1, -1, -1,
            R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn,
            R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn,
            R.drawable.white_rook, R.drawable.white_knight, R.drawable.white_bishop, R.drawable.white_queen,
            R.drawable.white_king, R.drawable.white_bishop, R.drawable.white_knight, R.drawable.white_rook,
    };

    GridView gridView;  // gridview object that references the grid view container
    private Board board;
    private boolean hasOne;
    private int position1;
    private int position2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);
        position1 = 0;
        position2 = 0;
        hasOne = false;
        board = new Board();

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);

        GridAdapter gridAdapter = new GridAdapter(this, images, pieces, this);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        initializeBoard();
    }

    protected void initializeBoard() {

    }

    public Board getBoard() {return board;}

    public void setBoard(Board b) {board = b;}

    public void setHasOne(boolean h) {hasOne = h;}

    public void setPosition1(int p) {position1 = p;}

    public void setPosition2(int p) {position2 = p;}

    public int getPosition1() {return position1;}

    public int getPosition2() {return position2;}

    public boolean isHasOne() {return hasOne;}

    public void move()
    {
        int startX = getX(position1);
        int startY = getY(position1);
        int endX = getX(position2);
        int endY = getY(position2);
        boolean moved = board.makeMove(startX, startY, endX, endY);
        if(moved)
        {
            setPieces(board.getBoard());
            if(board.getTurn() == 'B')
                flipBoard();
            if(board.getCheckmate())
            {
                Toast toast = Toast.makeText(this, "Checkmate!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if(board.getCheck())
            {
                Toast toast = Toast.makeText(this, "Check!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else
        {
            Toast toast = Toast.makeText(this, "That is not a valid move!", Toast.LENGTH_SHORT);
            toast.show();
        }
        GridAdapter gridAdapter = new GridAdapter(this, images, pieces, this);
        gridView.setAdapter(gridAdapter);
    }

    public int getX(int position)
    {
        if(board.getTurn() == 'W')
            return position % 8;
        return (63 - position) % 8;
    }

    public int getY(int position)
    {
        if(board.getTurn() == 'W')
            return position / 8;
        else
            return (63 - position) / 8;
    }

    public void setPieces(Piece[][] p)
    {
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
            {
                if(p[i][j] != null)
                {
                    if(p[i][j] instanceof Pawn)
                    {
                        if(p[i][j].getColor() == 'W')
                            pieces[(8 * i) + j] = R.drawable.white_pawn;
                        else
                            pieces[(8 * i) + j] = R.drawable.black_pawn;
                    }
                    else if(p[i][j] instanceof Rook)
                    {
                        if(p[i][j].getColor() == 'W')
                            pieces[(8 * i) + j] = R.drawable.white_rook;
                        else
                            pieces[(8 * i) + j] = R.drawable.black_rook;
                    }
                    else if(p[i][j] instanceof Knight)
                    {
                        if (p[i][j].getColor() == 'W')
                            pieces[(8 * i) + j] = R.drawable.white_knight;
                        else
                            pieces[(8 * i) + j] = R.drawable.black_knight;
                    }
                    else if(p[i][j] instanceof Bishop)
                    {
                        if(p[i][j].getColor() == 'W')
                            pieces[(8 * i) + j] = R.drawable.white_bishop;
                        else
                            pieces[(8 * i) + j] = R.drawable.black_bishop;
                    }
                    else if(p[i][j] instanceof Queen)
                    {
                        if(p[i][j].getColor() == 'W')
                            pieces[(8 * i) + j] = R.drawable.white_queen;
                        else
                            pieces[(8 * i) + j] = R.drawable.black_queen;
                    }
                    else
                    {
                        if(p[i][j].getColor() == 'W')
                            pieces[(8 * i) + j] = R.drawable.white_king;
                        else
                            pieces[(8 * i) + j] = R.drawable.black_king;
                    }
                }
                else
                    pieces[(8 * i) + j] = -1;
            }
    }

    public void flipBoard()
    {
        int[] temp = new int[pieces.length];
        int x = pieces.length - 1;
        for(int i = 0; i < pieces.length; i++, x--)
            temp[x] = pieces[i];
        pieces = temp;
    }
}
