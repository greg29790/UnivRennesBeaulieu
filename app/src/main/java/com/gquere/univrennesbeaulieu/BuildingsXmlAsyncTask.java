package com.gquere.univrennesbeaulieu;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by USER on 20/01/2018.
 */

public class BuildingsXmlAsyncTask extends AsyncTask<InputStream, Void, Document> {
    interface DocumentConsumer{
        void setXMLDocument(Document document);
    }

    private DocumentConsumer _consumer;

    public BuildingsXmlAsyncTask(DocumentConsumer consumer){
        _consumer = consumer;
    }

    @Override
    protected Document doInBackground(InputStream... inputStreams) {
        try{
            InputStream stream = inputStreams[0];
            try{
                return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream);
            }finally {
                stream.close();
            }
        } catch (Exception ex){
            Log.e("BuildingsXmlAsyncTask", "Exception while parsing", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void onPostExecute(Document result){
        Log.e("BuildingsXmlAsyncTask", "Finished");
        _consumer.setXMLDocument(result);
    }
}
