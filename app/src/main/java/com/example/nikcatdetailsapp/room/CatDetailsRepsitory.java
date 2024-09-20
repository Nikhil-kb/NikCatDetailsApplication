package com.example.nikcatdetailsapp.room;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CatDetailsRepsitory {

    CatDetailsDatabase catDetailsDatabase;
    CatDetailsDao catDetailsDao;
    private LiveData<List<CatDetailsEntity>> catDetailsList;

    public CatDetailsRepsitory(Application application) {
        catDetailsDatabase = CatDetailsDatabase.getDatabase(application);
        catDetailsDao = catDetailsDatabase.getCatDetailsDao();
        catDetailsList = catDetailsDao.getAllCatDetails();
        Log.e("CatDetailsRepsitory:", "CalledDB");
    }

    public void insertDetails( String catId, String url, String name, String description){
        Log.e("insertDetails( String catId, String url, String name, String description):", "CalledDB");
        CatDetailsEntity catDetailsEntity = new CatDetailsEntity();
        catDetailsEntity.setCatId(catId);
        catDetailsEntity.setUrl(url);
        catDetailsEntity.setName(name);
        catDetailsEntity.setDescription(description);
        insertCatDetails(catDetailsEntity);
    }

    public void insertCatDetails(CatDetailsEntity catDetailsEntity) {
       // CatDetailsDatabase.databaseWriteExecutor.execute(() -> catDetailsDao.insertCatDetails(catDetailsEntity));

        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                catDetailsDao.insertCatDetails(catDetailsEntity);
            }
        });

    }

    public LiveData<List<CatDetailsEntity>> getAllCatDetails() {
        return catDetailsList;
    }

    public List<CatDetailsEntity> getAllCatDetailsRow(){
        return catDetailsDao.getAllCatDetailsRow();
    }

    public boolean hasRowAvailable(String catID){
        return catDetailsDao.hasRowAvailable(catID);
    }

}
