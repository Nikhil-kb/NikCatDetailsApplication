package com.example.nikcatdetailsapp.cat_details.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nikcatdetailsapp.networking.NetworkCallRepository;
import com.example.nikcatdetailsapp.networking.model.CatDetailsModel;
import com.example.nikcatdetailsapp.room.CatDetailsEntity;
import com.example.nikcatdetailsapp.room.CatDetailsRepsitory;

import java.util.List;
import java.util.Objects;


public class CatDetailsViewModel extends AndroidViewModel {

    //For Room Data persistence operations
    private final CatDetailsRepsitory catDetailsRepsitory;
    private final LiveData<List<CatDetailsEntity>> catDetailsLiveData;

    //For retrofit related operations
    private final NetworkCallRepository networkCallRepository;
    public MutableLiveData<List<CatDetailsModel>> catDetailsModelLiveData;

    public CatDetailsViewModel(@NonNull Application application) {
        super(application);
        catDetailsRepsitory = new CatDetailsRepsitory(application);
        catDetailsLiveData = catDetailsRepsitory.getAllCatDetails();

        networkCallRepository = new NetworkCallRepository();
        getCatDetailsList();
    }

    //To get list cat details available in the database
    public LiveData<List<CatDetailsEntity>> getAllCatDetails() {
        return catDetailsLiveData;
    }

    //To insert cat details to room database
    public void insertCatDetailsOnDB(List<CatDetailsModel> catDetailsModelList){
        for(CatDetailsModel catDetailsModel: catDetailsModelList){
            if(!catDetailsRepsitory.hasRowAvailable(catDetailsModel.getId())){
                if(catDetailsModel.getBreeds() == null){
                    catDetailsRepsitory.insertDetails(catDetailsModel.getId(), catDetailsModel.getUrl(),
                            null, null);
                }else{
                    catDetailsRepsitory.insertDetails(catDetailsModel.getId(), catDetailsModel.getUrl(),
                            catDetailsModel.getBreeds().get(0).getName(), catDetailsModel.getBreeds().get(0).getDescription());
                }
            }
        }
    }

    //To get cat details from the remote data source(Retrofit)
    public void getCatDetailsList(){
        catDetailsModelLiveData = networkCallRepository.getCatDetailsLiveData();
    }

    //To refresh the list of cat details from the remote data source(Retrofit)
    public void refreshCatDetailsList(){
        if(catDetailsModelLiveData != null){
            Objects.requireNonNull(catDetailsModelLiveData.getValue()).clear();
        }
        catDetailsModelLiveData = networkCallRepository.getCatDetailsLiveData();
    }

}


