package com.gquere.univrennesbeaulieu;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;


public class MapUnivActivity extends AppCompatActivity {
    private ImageView emptyMapImg;
    private ImageView buildingImg;

    private PhotoView emptyMapPhoto;
    private PhotoView buildingPhoto;

    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector SGD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_univ);


        final Building building = (Building) getIntent().getSerializableExtra(getString(R.string.building_Info));
        final int resourceId = getResources().getIdentifier(building.id, getString(R.string.drawable), getPackageName());


        setTitle(building.name);
        Log.i("MapUniv", building.id);
        Log.i("MapUniv", String.valueOf(resourceId));
        if (resourceId == 0)
        {
            new AlertDialog.Builder(this)
                    .setTitle("Not found")
                    .setMessage(building.name + " " + getString(R.string.not_found))
                    .show();
        }
        else
        {
           Drawable emptyMapDrw = getDrawable(R.drawable.planfull_nb);
           Drawable buildingDrw = getDrawable(resourceId);

           LayerDrawable finalLayer = new LayerDrawable(new Drawable[] {emptyMapDrw, buildingDrw});
           buildingPhoto = (PhotoView) findViewById(R.id.building_img);
           buildingPhoto.setImageDrawable(finalLayer);

        }
    }
}
