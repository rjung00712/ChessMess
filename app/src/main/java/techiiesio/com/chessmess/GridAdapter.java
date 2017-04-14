package techiiesio.com.chessmess;

import android.content.ClipData;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import static techiiesio.com.chessmess.R.id.piece;

/**
 * Created by Richard on 4/12/17.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] values;
    int[] images;
    int[] pieces;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, int[] images, int[] pieces) {
        this.context = context;
        this.images = images;
        this.pieces = pieces;
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
<<<<<<< HEAD
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
=======
            view = new View(context);
            view = layoutInflater.inflate(R.layout.activity_square, null);

            // get dimensions of width and height respective of screen resolution
            DisplayMetrics display = context.getResources().getDisplayMetrics();
            int squareWidth = display.widthPixels / 8;
            int squareHeight = display.heightPixels / 8;

//        ImageView squareImage = new ImageView(context);
//
//        ImageView pieceImage = new ImageView(context);

            ImageView squareImage = (ImageView) view.findViewById(R.id.square_background);

//            squareImage.setLayoutParams(new FrameLayout.LayoutParams(squareHeight, squareWidth));

            squareImage.setImageResource(images[position]);
            ImageView pieceImage = (ImageView) view.findViewById(R.id.piece);


//        squareImage.setBackgroundResource(images[position]);


            pieceImage.setImageResource(pieces[position]);


//        if(pieces[position] != -1) {
//            squareImage.setImageResource(pieces[position]);
//        }


            pieceImage.setOnTouchListener(new MyTouchListener());
        }

        return view;
    }
>>>>>>> 6df9ce5de582843be2b3d357fb483e373e3919ab

            squareImage.setImageResource((ImageView) view.findViewById(R.id.piece));

<<<<<<< HEAD
        return squareImage;
=======
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        if(convertView == null) {
//            view = new View(context);
//            view = layoutInflater.inflate(R.layout.activity_square, null);
//
//            // get dimensions of width and height respective of screen resolution
//            DisplayMetrics display = context.getResources().getDisplayMetrics();
//            int squareWidth = display.widthPixels / 8;
//            int squareHeight = display.heightPixels / 8;
//
//            ImageView squareBackground = (ImageView) view.findViewById(R.id.square_background);
//
//            squareBackground.setLayoutParams(new FrameLayout.LayoutParams(squareHeight, squareWidth));
//
//            squareBackground.setImageResource(images[position]);
//
//            ImageView piece = (ImageView) view.findViewById(R.id.piece);
//            piece.setImageResource(pieces[position]);
//
////            squareBackground.setImageResource(images[position]);
////            squareBackground.setImageResource(pieces[position]);
////
////            piece.setImageResource(pieces[position]);
//
//            piece.setOnTouchListener(new MyTouchListener());
//            squareBackground.setOnTouchListener(new MyTouchListener());
//        }
//
//
//        return view;
//    }

    // This defines your touch listener
    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
>>>>>>> 6df9ce5de582843be2b3d357fb483e373e3919ab
    }

}
