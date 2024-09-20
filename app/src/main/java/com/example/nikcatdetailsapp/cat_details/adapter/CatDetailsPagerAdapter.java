package com.example.nikcatdetailsapp.cat_details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nikcatdetailsapp.R;
import com.example.nikcatdetailsapp.databinding.LayoutCatdetailsViewpagerAdapterBinding;
import com.example.nikcatdetailsapp.networking.model.CatDetailsRes;

import java.util.ArrayList;
import java.util.List;

public class CatDetailsPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<CatDetailsRes> catDetailsResList = new ArrayList<>();

    public CatDetailsPagerAdapter(Context mContext, List<CatDetailsRes> catDetailsResList) {
        this.mContext = mContext;
        this.catDetailsResList = catDetailsResList;
    }

    @Override
    public int getCount() {
        return catDetailsResList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutCatdetailsViewpagerAdapterBinding binding =
                LayoutCatdetailsViewpagerAdapterBinding.inflate(LayoutInflater.from(container.getContext()), container, false);
        binding.getRoot().setTag(position);
        container.addView(binding.getRoot());

        CatDetailsRes CatDetailsRes = catDetailsResList.get(position);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        Glide.with(mContext)
                .load(CatDetailsRes.getUrl())
                .apply(options)
                .into(binding.ivCatImage);
        

            if(CatDetailsRes.getName() != null){
                binding.tvName.setText(CatDetailsRes.getName());
            }

            if(CatDetailsRes.getDescription() != null){
                binding.tvDesc.setText(CatDetailsRes.getDescription());
            }
            

        return binding.getRoot();

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

