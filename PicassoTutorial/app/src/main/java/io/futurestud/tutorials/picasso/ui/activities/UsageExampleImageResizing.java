package io.futurestud.tutorials.picasso.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.picasso.R;

public class UsageExampleImageResizing extends ActionBarActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageViewResize;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewResizeCenterCrop;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewResizeCenterInside;
    @InjectView(R.id.standard_list_imageview4) ImageView imageViewResizeScaleDown;
    @InjectView(R.id.standard_list_imageview5) ImageView imageViewFit;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        loadImageWithResize();
        loadImageWithResizeCenterCrop();
        loadImageWithResizeCenterInside();
        loadImageWithResizeScaleDown();
        loadImageWithFit();
    }

    private void loadImageWithResize() {
        Picasso
                .with(context)
                .load(UsageExampleAdapter.eatFoodyImages[0])
                .resize(600, 200) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(imageViewResize);
    }

    private void loadImageWithResizeCenterCrop() {
        Picasso
                .with(context)
                .load(UsageExampleAdapter.eatFoodyImages[0])
                .resize(600, 200) // resizes the image to these dimensions (in pixel)
                .centerCrop() // This cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                .into(imageViewResizeCenterCrop);
    }

    private void loadImageWithResizeCenterInside() {
        Picasso
                .with(context)
                .load(UsageExampleAdapter.eatFoodyImages[0])
                .resize(600, 200)
                .centerInside() // this scales the image so that both dimensions are equal to or less than the requested bounds.
                .into(imageViewResizeCenterInside);
    }

    private void loadImageWithResizeScaleDown() {
        Picasso
                .with(context)
                .load(UsageExampleAdapter.eatFoodyImages[0])
                .resize(6000, 2000)
                .onlyScaleDown()
                .into(imageViewResizeScaleDown);
    }

    private void loadImageWithFit() {
        Picasso
                .with(context)
                .load(UsageExampleAdapter.eatFoodyImages[0])
                .fit()
                        // .centerInside() // add a center() call to avoid a stretched image
                .into(imageViewFit);
    }
}