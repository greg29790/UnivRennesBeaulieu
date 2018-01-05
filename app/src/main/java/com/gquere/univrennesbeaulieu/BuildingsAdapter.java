package com.gquere.univrennesbeaulieu;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 05/01/2018.
 */


public class BuildingsAdapter extends RecyclerView.Adapter<BuildingsAdapter.BuildingViewHolder> {

    private final List<String> buildings = Arrays.asList(
            "Bâtiment 1A",
            "Bâtiment 2A",
            "Bâtiment 2B",
            "Bâtiment 3",
            "Bâtiment 4",
            "Bâtiment 5",
            "Bâtiment 6",
            "Bâtiment 7",
            "Bâtiment 8A",
            "Bâtiment 8B",
            "Bâtiment 9A",
            "Bâtiment 9B",
            "Bâtiment 10A,B,C"
    );


    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position) {
        String building = buildings.get(position);
        holder.display(building);
    }

    @Override
    public int getItemCount() {
        return buildings.size();
    }

    public class BuildingViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;


        public BuildingViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("Batiment")
                            .setMessage(name.getText())
                            .show();
                }
            });
        }

        public void display(String str) {
            name.setText(str);
        }
    }
}
