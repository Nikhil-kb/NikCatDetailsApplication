package com.example.nikcatdetailsapp.cat_details.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CatDetailsViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;
    public CatDetailsViewModelFactory(Application myApplication) {
        application = myApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CatDetailsViewModel(application);
    }
}

