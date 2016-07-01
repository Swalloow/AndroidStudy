package com.example.mycardview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Junyoung on 2016-07-02.
 */

public class MyCardView extends CardView {
    CardView cardView;
    LinearLayout linearLayout;
    ImageView imageView;
    TextView textView;

    private UserActionListener mUserActionListener;

    public interface UserActionListener {
        public void onImageClicked();

        public void onTextClicked();
    }

    public MyCardView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public MyCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MyCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void setUserActionListener(UserActionListener l) {
        this.mUserActionListener = l;
    }

    public void setData(Item item) {
        Glide.with(getContext()).load(item.getImage()).into(imageView);
        textView.setText(item.getTitle());
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // Initialization
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.item_cardview, this, true);

        cardView = (CardView) findViewById(R.id.cardview);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.title);

        cardView.setOnClickListener(mOnClickListener);
        imageView.setOnClickListener(mOnClickListener);
        textView.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if(mUserActionListener == null) {
                return;
            }

            if(v == imageView) {
                mUserActionListener.onImageClicked();
            }else if(v == textView) {
                mUserActionListener.onTextClicked();
            }
        }
    };

}
