package com.example.nikcatdetailsapp.networking;

import com.example.nikcatdetailsapp.networking.model.CatDetailsModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("search")
    Observable<List<CatDetailsModel>> getCatDetails(
            @Query("limit") int limit,
            @Query("breed_ids") String breedIds,
            @Query("api_key") String apiKey
    );


}
