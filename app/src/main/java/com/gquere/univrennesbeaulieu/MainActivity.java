package com.gquere.univrennesbeaulieu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.ActionBarTitle);

        final RecyclerView rv_buildings = (RecyclerView) findViewById(R.id.list_buildings);

        rv_buildings.setLayoutManager(new LinearLayoutManager(this));
        rv_buildings.setAdapter(new BuildingsAdapter(this));
    }

    // No menu for the moment
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    */
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.all :
                //SHOW ALL MAP
                return true;
            case R.id.rennes :
                //Show subMenu with rennes 1 building list
                return true;
            case R.id.iut :
                //SHOW subMenu with iut building list
                return true;
            case R.id.parking :
                //SHOW subMenu with parking list
                return true;
            case R.id.other :
                //SHOW subMenu with other building list
            return true;
        }
        return (super.onOptionsItemSelected(item));
    }
    */
}
