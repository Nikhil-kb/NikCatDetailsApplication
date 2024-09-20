package com.example.nikcatdetailsapp.networking;

import androidx.lifecycle.MutableLiveData;

import com.example.nikcatdetailsapp.networking.model.CatDetailsModel;
import com.example.nikcatdetailsapp.util.Constants;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NetworkCallRepository {

    private Api api = null;

    public NetworkCallRepository() {
        this.api = RetrofitClient.getClient().create(Api.class);
    }

    public MutableLiveData<List<CatDetailsModel>> getCatDetailsLiveData() {
        MutableLiveData<List<CatDetailsModel>> catDetailsLiveData = new MutableLiveData<>();
        DisposableObserver<List<CatDetailsModel>> catDetailsObservables = api.getCatDetails(10,
                        "beng",
                        Constants.CAT_API_KEY
                ).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<CatDetailsModel>>() {
                    @Override
                    public void onComplete() {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> onComplete Called");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<CatDetailsModel> list) {
                        //adapter.setItems(list);
                        catDetailsLiveData.postValue(list);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> onNext Called");
                    }
                });

    return  catDetailsLiveData;
    }


}
