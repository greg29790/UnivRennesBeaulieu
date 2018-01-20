package com.gquere.univrennesbeaulieu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import com.gquere.univrennesbeaulieu.BuildingXmlParser.Building;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 05/01/2018.
 */


public class BuildingsAdapter extends RecyclerView.Adapter<BuildingsAdapter.BuildingViewHolder> implements BuildingsXmlAsyncTask.DocumentConsumer{

    //parsing with async

    private Document    _document = null;
    private Context     _context = null;
    @Override
    public int getItemCount() {
        if (_document != null){
            return (_document.getElementsByTagName("building").getLength());
        } else {
            return 0;
        }
    }

    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position) {
        Element building = (Element) _document.getElementsByTagName("building").item(position);
        holder.setElement(building);
    }

    public  BuildingsAdapter(Context context){
        _context = context;


    }

    @Override
    public void setXMLDocument(Document document) {
        _document = document;
        notifyDataSetChanged();
    }

    public class BuildingViewHolder extends RecyclerView.ViewHolder {

        private final TextView _name;
        private Element _currentBuilding;

        public BuildingViewHolder(final View itemView) {
            super(itemView);

            _name = ((TextView) itemView.findViewById(R.id.name));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(_context, MapUnivActivity.class);
                    intent.putExtra(_context.getString(R.string.building_Info), new Building(_currentBuilding));
                    _context.startActivity(intent);
                }
            });
        }

        public void setElement(Element element) {
            _currentBuilding = element;
            _name.setText(element.getElementsByTagName("name").item(0).getTextContent());
        }
    }

    // parsing without async
    /*
    private List<BuildingXmlParser.Building> list_buildings = new ArrayList<>();
    private BuildingXmlParser bxp = new BuildingXmlParser();
    private Context context;

    public  BuildingsAdapter(Context context){
        this.context = context;

        final InputStream stream = this.context.getResources().openRawResource(R.raw.buidings_mini);

        try {
            list_buildings = bxp.parse(stream);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position) {
        Building building = list_buildings.get(position);
        holder.display(building);
    }

    @Override
    public int getItemCount() {
        return list_buildings.size();
    }

    public class BuildingViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private Building building;

        public BuildingViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MapUnivActivity.class);
                    intent.putExtra(context.getString(R.string.building_Info), building);
                    context.startActivity(intent);
                }
            });
        }

        public void display(Building b) {
            building = b;
            name.setText(b.name);
        }
    }
    */
}
