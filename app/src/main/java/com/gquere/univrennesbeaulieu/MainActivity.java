package com.gquere.univrennesbeaulieu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private BuildingsXmlAsyncTask _task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.ActionBarTitle);

        final RecyclerView rv_buildings = (RecyclerView) findViewById(R.id.list_buildings);

        rv_buildings.setLayoutManager(new LinearLayoutManager(this));
        BuildingsAdapter _adapter = new BuildingsAdapter(this);
        rv_buildings.setAdapter(_adapter);

        _task = new BuildingsXmlAsyncTask(_adapter);
        _task.execute(getResources().openRawResource(R.raw.buidings_mini));

        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        _adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                progress.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        _task.cancel(true);
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
