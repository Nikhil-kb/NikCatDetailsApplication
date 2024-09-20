package com.example.nikcatdetailsapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CatDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCatDetails(CatDetailsEntity catDetailsEntity);

    @Query("SELECT * FROM cat_details")
    LiveData<List<CatDetailsEntity>> getAllCatDetails();

    @Query("SELECT * FROM cat_details")
    List<CatDetailsEntity> getAllCatDetailsRow();

    @Query("SELECT EXISTS(SELECT * FROM cat_details WHERE catId = :catID)")
    boolean hasRowAvailable(String catID);

}
