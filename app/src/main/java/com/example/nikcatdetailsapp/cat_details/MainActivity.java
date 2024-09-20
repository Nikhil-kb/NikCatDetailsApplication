package com.example.nikcatdetailsapp.cat_details;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nikcatdetailsapp.R;
import com.example.nikcatdetailsapp.cat_details.adapter.CatDetailsGridAdapter;
import com.example.nikcatdetailsapp.cat_details.adapter.CatDetailsPagerAdapter;
import com.example.nikcatdetailsapp.cat_details.adapter.CateDetailsLinearAdapter;
import com.example.nikcatdetailsapp.cat_details.view_model.CatDetailsViewModel;
import com.example.nikcatdetailsapp.databinding.ActivityMainBinding;
import com.example.nikcatdetailsapp.networking.model.CatDetailsModel;
import com.example.nikcatdetailsapp.networking.model.CatDetailsRes;
import com.example.nikcatdetailsapp.room.CatDetailsEntity;
import com.example.nikcatdetailsapp.util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private CatDetailsViewModel catDetailsViewModel;
    private int viewType = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        init();

    }

    private void init() {

        setSupportActionBar(activityMainBinding.layoutToolbar.getRoot());

        catDetailsViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(CatDetailsViewModel.class);
        observeCatDetailsFromNetworkCall();

    }


    private void createCatDetailsRvListView(List<CatDetailsRes> catDetailsModelList) {

        CateDetailsLinearAdapter cateDetailsLinearAdapter = new CateDetailsLinearAdapter(getApplicationContext(), catDetailsModelList);
        cateDetailsLinearAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        activityMainBinding.rvCatDetails.setLayoutManager(layoutManager);
        activityMainBinding.rvCatDetails.setAdapter(cateDetailsLinearAdapter);
        activityMainBinding.viewPager.setVisibility(View.GONE);
        activityMainBinding.rvCatDetails.setVisibility(View.VISIBLE);

    }

    private void createCatDetailsRvGridView(List<CatDetailsRes> catDetailsModelList) {

        CatDetailsGridAdapter catDetailsGridAdapter = new CatDetailsGridAdapter(getApplicationContext(), catDetailsModelList);
        catDetailsGridAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3, GridLayoutManager.HORIZONTAL, false);
        activityMainBinding.rvCatDetails.setLayoutManager(layoutManager);
        activityMainBinding.rvCatDetails.setAdapter(catDetailsGridAdapter);
        activityMainBinding.viewPager.setVisibility(View.GONE);
        activityMainBinding.rvCatDetails.setVisibility(View.VISIBLE);

    }

    private void createCatDetailsViewPager(List<CatDetailsRes> catDetailsModelList) {
        CatDetailsPagerAdapter catDetailsPagerAdapter = new CatDetailsPagerAdapter(getApplicationContext(), catDetailsModelList);
        activityMainBinding.viewPager.setAdapter(catDetailsPagerAdapter);
        activityMainBinding.viewPager.setPadding(100, 0, 100, 0);
        activityMainBinding.rvCatDetails.setVisibility(View.GONE);
        activityMainBinding.viewPager.setVisibility(View.VISIBLE);

    }

    private void observeCatDetailsFromNetworkCall() {
        List<CatDetailsRes> catDetailsResList = new ArrayList<>();
        if (NetworkUtil.checkInternetConnection(getApplicationContext())) {
            catDetailsViewModel.catDetailsModelLiveData.observe(this, catDetailsModels -> {
                for(CatDetailsModel catDetailsModel: catDetailsModels){
                    if(catDetailsModel.getBreeds() == null){
                        catDetailsResList.add(new CatDetailsRes(catDetailsModel.getUrl(), null, null));
                    }else{
                        catDetailsResList.add(new CatDetailsRes(catDetailsModel.getUrl(), catDetailsModel.getBreeds().get(0).getName(), catDetailsModel.getBreeds().get(0).getDescription()));

                    }
                }

                switch (viewType) {
                    case 1: {
                        createCatDetailsRvListView(catDetailsResList);
                        break;
                    }

                    case 2: {
                        createCatDetailsRvGridView(catDetailsResList);
                        break;
                    }

                    case 3: {
                        createCatDetailsViewPager(catDetailsResList);
                        break;
                    }
                }
                insertToDB(catDetailsModels);
            });
        }else{
            catDetailsViewModel.getAllCatDetails().observe(this, catDetailsEntities -> {

                for(CatDetailsEntity catDetailsEntity: catDetailsEntities){
                    catDetailsResList.add(new CatDetailsRes(catDetailsEntity.getUrl(), catDetailsEntity.getName(), catDetailsEntity.getDescription()));
                }

                switch (viewType) {
                    case 1: {
                        createCatDetailsRvListView(catDetailsResList);
                        break;
                    }

                    case 2: {
                        createCatDetailsRvGridView(catDetailsResList);
                        break;
                    }

                    case 3: {
                        createCatDetailsViewPager(catDetailsResList);
                        break;
                    }
                }
            });
        }
    }

    private void insertToDB(List<CatDetailsModel> catDetailsModels) {
        catDetailsViewModel.insertCatDetailsOnDB(catDetailsModels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.linear_view) {
            viewType = 1;
            catDetailsViewModel.refreshCatDetailsList();
            observeCatDetailsFromNetworkCall();
            //Toast.makeText(MainActivity.this, "Linear View", Toast.LENGTH_SHORT).show();
        }

        if (itemId == R.id.grid_view) {
            viewType = 2;
            catDetailsViewModel.refreshCatDetailsList();
            observeCatDetailsFromNetworkCall();
            // Toast.makeText(MainActivity.this, "Grid View", Toast.LENGTH_SHORT).show();
        }

        if (itemId == R.id.view_pager) {
            viewType = 3;
            catDetailsViewModel.refreshCatDetailsList();
            observeCatDetailsFromNetworkCall();
            //  Toast.makeText(MainActivity.this, "View Pager", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

}