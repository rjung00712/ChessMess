package techiiesio.com.chessmess;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by Richard on 4/12/17.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    int[] images;
    int[] pieces;
    View view;
    LayoutInflater layoutInflater;
    boolean containsDragable;
    ChessActivity chessActivity;

//    int position;

    public GridAdapter(Context context, int[] images, int[] pieces, ChessActivity chessActivity) {
        this.context = context;
        this.images = images;
        this.pieces = pieces;
        this.chessActivity = chessActivity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = new View(context);
            view = layoutInflater.inflate(R.layout.activity_square, null);


//            this.position = position;

            // get dimensions of width and height respective of screen resolution
            DisplayMetrics display = context.getResources().getDisplayMetrics();
            int squareWidth = display.widthPixels / 8;
            int squareHeight = display.heightPixels / 8;

//        ImageView squareImage = new ImageView(context);
//
//        ImageView pieceImage = new ImageView(context);

            final ImageView squareImage = (ImageView) view.findViewById(R.id.square_background);

//            squareImage.setLayoutParams(new FrameLayout.LayoutParams(squareHeight, squareWidth));

            squareImage.setImageResource(images[position]);
            final ImageView pieceImage = (ImageView) view.findViewById(R.id.piece);

//        squareImage.setBackgroundResource(images[position]);

//            pieceImage.setImageResource(pieces[position]);

        if(pieces[position] != -1) {
            pieceImage.setImageResource(pieces[position]);
        }

            squareImage.setOnDragListener(new MyDragListener());

//            pieceImage.setOnTouchListener(new MyTouchListener());

            pieceImage.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (chessActivity.isHasOne()) {
                            chessActivity.setPosition2(position);
                            chessActivity.move();
                            chessActivity.setHasOne(false);
                        } else {
                            chessActivity.setPosition1(position);
                            chessActivity.setHasOne(true);
                            squareImage.setBackgroundResource(R.drawable.tan_square);
                        }
                    }
                    return true;
                }
            });

    }

        return view;
}

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

//    // This defines your touch listener
//    private final class MyTouchListener implements View.OnTouchListener {
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                ClipData data = ClipData.newPlainText("", "");
//                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
//                        view);
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    view.startDragAndDrop(data, shadowBuilder, view, 0);
//                } else {
//                    view.startDrag(data, shadowBuilder, view, 0);
//                }
//                view.setVisibility(View.INVISIBLE);
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }





    class MyDragListener implements View.OnDragListener {
//        Drawable enterShape = getResources().getDrawable(
//                R.drawable.shape_droptarget);
//        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        FrameLayout frameLayout;
        ImageView imageView;

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();

            View dragView = (View) event.getLocalState();


            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    containsDragable = true;
                    // v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //v.setBackgroundDrawable(normalShape);
                    if (dropEventNotHandled(event)) {
                        dragView.setVisibility(View.VISIBLE);
                    }
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    containsDragable = false;

                    // v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    if (containsDragable) {

//                        checkMove();
///////////////////////////////////////////

                        dragView.setVisibility(View.VISIBLE);
                    }


//                case DragEvent.ACTION_DROP:
//                    //              Log.v("Test", "Entered drop");
//                    fl2 = (FrameLayout) v.getParent();
//                    imgv2 = (ImageView) fl2.getChildAt(1);
//                    Piece square = (Piece) imgv2.getTag();
//
//                    if(currentPiece.getPossibleMoves().contains(square.getCurrentSquare())){
//                        //                  imgv.setImageResource(currentPiece.getRessource());
//                        Piece destinationPiece = lp[square.getCurrentSquare()];
//                        lp[square.getCurrentSquare()] = currentPiece;
//                        lp[currentPiece.getCurrentSquare()] = new Piece();
//
//                        if((yourBeingCheckedDumbAss(currentPiece))
//                                ||((destinationPiece instanceof King)
//                                &&(destinationPiece.getColor() != currentPiece.getColor()))
//                                ||(whiteTurn != currentPiece.getColor())){
//                            imgvcp.setImageResource(currentPiece.getRessource());
//                            imgvcp.setVisibility(View.VISIBLE);
//                            lp[square.getCurrentSquare()] = destinationPiece;
//                            lp[currentPiece.getCurrentSquare()] = currentPiece;
//                        }else{
//                            imgvcp.setImageResource(currentPiece.getRessource());
//                            ((ChessActivity) mContext).setNewAdapter(lp);
//                        }


//                    // Dropped, reassign View to ViewGroup
//                    View view = (View) event.getLocalState();
//                    ViewGroup owner = (ViewGroup) view.getParent();
//                    owner.removeView(view);
//                    LinearLayout container = (LinearLayout) v;
//                    container.addView(view);
//                    view.setVisibility(View.VISIBLE);
                    break;

                default:
                    break;
            }
            return true;
        }
    }

//    private void checkMove() {
////
//        chessActivity.setPosition2(position);
//        chessActivity.move();
//        chessActivity.setHasOne(false);
//
//
//
//    }


    //    squareImage.setOnTouchListener(new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            if(event.getAction() == MotionEvent.ACTION_DOWN) {
//                if (chessActivity.isHasOne()) {
//                    chessActivity.setPosition2(position);
//                    chessActivity.move();
//                    chessActivity.setHasOne(false);
//                } else {
//                    chessActivity.setPosition1(position);
//                    chessActivity.setHasOne(true);
//                    squareImage.setBackgroundResource(R.drawable.red_square);
//                }
//            }
//            return true;
//        }
//    });



    private boolean dropEventNotHandled(DragEvent dragEvent) {
        return !dragEvent.getResult();
    }
}


