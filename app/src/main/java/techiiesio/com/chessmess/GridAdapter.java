package techiiesio.com.chessmess;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import static techiiesio.com.chessmess.R.id.piece;

/**
 * Created by Richard on 4/12/17.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] values;
    int[] images;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.activity_image, null);

//            ImageView square = (ImageView) view.findViewById(R.id.square_background);
            ImageView piece = (ImageView) view.findViewById(piece);

//            square.setImageResource(images[position]);
            piece.setImageResource(images[position]);



//        }
//            view = new View(context);
//            view = layoutInflater.inflate(R.layout.activity_image, null);
//        }
//
            // get dimensions of width and height respective of screen resolution
            DisplayMetrics display = context.getResources().getDisplayMetrics();
            int squareWidth = display.widthPixels / 8;
            int squareHeight = display.heightPixels / 8;
//
//
//            ImageView pieceView = (ImageView) view.findViewById(R.id.piece);
//
//
            ImageView squareImage = new ImageView(context);
            squareImage.setLayoutParams(new GridView.LayoutParams(squareHeight, squareWidth));

            view.getResources().getDrawable(images[position], piece);

            squareImage.setImageResource(images[position]);

            squareImage.setImageResource((ImageView) view.findViewById(R.id.piece));

        return squareImage;
    }
}
