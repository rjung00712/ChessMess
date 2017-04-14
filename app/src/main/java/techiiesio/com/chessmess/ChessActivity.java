package techiiesio.com.chessmess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class ChessActivity extends AppCompatActivity {

<<<<<<< HEAD
    int[] images = {    // chess background images per each activity_square of the chess board
=======
    static int[] images = {    // chess background images per each square of the chess board
>>>>>>> 6df9ce5de582843be2b3d357fb483e373e3919ab
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

    static int[] pieces = {    // chess piece images per each square of the chess board
            R.drawable.black_rook, R.drawable.black_knight, R.drawable.black_bishop, R.drawable.black_queen,
            R.drawable.black_king, R.drawable.black_bishop, R.drawable.black_knight, R.drawable.black_rook,
            R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn,
            R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square,
            R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn,
            R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn,
            R.drawable.white_rook, R.drawable.white_knight, R.drawable.white_bishop, R.drawable.white_queen,
            R.drawable.white_king, R.drawable.white_bishop, R.drawable.white_knight, R.drawable.white_rook,
    };

    GridView gridView;  // gridview object that references the grid view container

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        GridAdapter gridAdapter = new GridAdapter(this, images, pieces);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        initializeBoard();
    }

    protected void initializeBoard() {

    }

}
