package com.gquere.univrennesbeaulieu;

import android.graphics.Matrix;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

//import com.gquere.univrennesbeaulieu.BuildingXmlParser.Building;

public class MapUnivActivity extends AppCompatActivity {
    private ImageView emptyMapImg;
    private ImageView buildingImg;

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
            //emptyMapImg = (ImageView) findViewById(R.id.empty_map);
            buildingImg = (ImageView) findViewById(R.id.building_img);
            buildingImg.setImageResource(resourceId);

        }
    }


}
