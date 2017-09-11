package com.filho.filho.helper;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.filho.filho.MainActivity;
import com.filho.filho.R;

import java.io.InputStream;

/**
 * Created by HeryVandoro on 9/11/2017.
 */

public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{
    ImageView imageView;


    public ImageDownloader(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        Bitmap bmp = null;
        try {
            InputStream in = new java.net.URL(urls[0]).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    protected void onPreExecute() {
        imageView.setImageResource(R.drawable.avatar);
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}
