package techiiesio.com.chessmess;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


//        if (convertView == null) {
//            view = new View(context);
//            view = layoutInflater.inflate(R.layout.item, null);

        DisplayMetrics display = context.getResources().getDisplayMetrics();
        int squareWidth = display.widthPixels / 8;
        int squareHeight = display.heightPixels / 8;

        Log.i("yo", Integer.toString(display.widthPixels));
        Log.i("yo", Integer.toString(display.heightPixels));


        ImageView imageView = new ImageView(context);

        imageView.setLayoutParams(new GridView.LayoutParams(squareHeight, squareHeight));
        imageView.setImageResource(images[position]);

//            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);


//        }
        return imageView;
    }
}
