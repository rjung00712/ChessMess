package techiiesio.com.chessmess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    String[] values = { "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white",
                        "black", "white"

                    };

    // chess images per each square of the chess board
    int[] images = {
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
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square,
            R.drawable.brown_square, R.drawable.tan_square, R.drawable.brown_square, R.drawable.tan_square
            };

    GridView gridView;  // gridview object that references the grid view container

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);

//        setContentView(R.layout.activity_chess);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);

//        gridView = (GridView) findViewById(R.id.chessboard);

        GridAdapter gridAdapter = new GridAdapter(this, images);

        gridView.setAdapter(gridAdapter);


    }
}
