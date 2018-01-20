package com.gquere.univrennesbeaulieu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


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
}
