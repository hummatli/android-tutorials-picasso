package io.futurestud.tutorials.picasso.ui.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.picasso.R;

public class UsageExampleSimpleLoading extends ActionBarActivity {

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    @InjectView(R.id.simple_loading_internet) ImageView imageViewInternet;
    @InjectView(R.id.simple_loading_resource) ImageView imageViewResource;
    @InjectView(R.id.simple_loading_file) ImageView imageViewFile;
    @InjectView(R.id.simple_loading_uri) ImageView imageViewUri;

    /**
     * helper method which creates an Uri for a resourceId
     */
    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_simple_loading);
        ButterKnife.inject(this);

        loadImageByInternetUrl();
        loadImageByResourceId();
        loadImageByFile();
        loadImageByUri();
    }

    private void loadImageByInternetUrl() {
        // the url could be any image URL, which is accessible with a normal HTTP GET request
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        Picasso
                .with(UsageExampleSimpleLoading.this)
                .load(internetUrl)
                .into(imageViewInternet);
    }

    private void loadImageByResourceId() {
        int resourceId = R.mipmap.ic_launcher;
        Picasso
                .with(UsageExampleSimpleLoading.this)
                .load(resourceId)
                .into(imageViewResource);
    }

    private void loadImageByFile() {
        // this file probably does not exist on your device. However, you can use any file path, which points to an image file
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Running.jpg");
        Picasso
                .with(UsageExampleSimpleLoading.this)
                .load(file)
                .into(imageViewFile);
    }

    private void loadImageByUri() {
        // this could be any Uri. for demonstration purposes we're just creating an Uri pointing to a launcher icon
        Uri uri = resourceIdToUri(UsageExampleSimpleLoading.this, R.mipmap.future_studio_launcher);
        Picasso
                .with(UsageExampleSimpleLoading.this)
                .load(uri)
                .into(imageViewUri);
    }
}