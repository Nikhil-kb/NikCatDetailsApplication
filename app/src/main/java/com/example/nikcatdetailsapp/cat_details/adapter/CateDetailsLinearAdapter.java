package com.example.nikcatdetailsapp.cat_details.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nikcatdetailsapp.R;
import com.example.nikcatdetailsapp.databinding.LayoutCatdetailsLinearAdapterBinding;
import com.example.nikcatdetailsapp.networking.model.CatDetailsRes;

import java.util.ArrayList;
import java.util.List;

public class CateDetailsLinearAdapter extends RecyclerView.Adapter<CateDetailsLinearAdapter.MyViewHolder> {

    private Context context;
    private List<CatDetailsRes> catDetailsResList = new ArrayList<>();

    public CateDetailsLinearAdapter(Context context, List<CatDetailsRes> catDetailsResList) {
        this.context = context;
        this.catDetailsResList = catDetailsResList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCatdetailsLinearAdapterBinding layoutCatdetailsLinearAdapterBinding =
                LayoutCatdetailsLinearAdapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(layoutCatdetailsLinearAdapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CatDetailsRes CatDetailsRes = catDetailsResList.get(position);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        Glide.with(context)
                .load(CatDetailsRes.getUrl())
                .apply(options)
                .into(holder.layoutCatdetailsLinearAdapterBinding.ivCatImage);



            if(CatDetailsRes.getName() != null){
                holder.layoutCatdetailsLinearAdapterBinding.tvName.setText(CatDetailsRes.getName());
            }

            if(CatDetailsRes.getDescription() != null){
                holder.layoutCatdetailsLinearAdapterBinding.tvDesc.setText(CatDetailsRes.getDescription());
            }


    }

    @Override
    public int getItemCount() {
        return catDetailsResList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LayoutCatdetailsLinearAdapterBinding layoutCatdetailsLinearAdapterBinding;
        public MyViewHolder(LayoutCatdetailsLinearAdapterBinding layoutCatdetailsLinearAdapterBinding) {
            super(layoutCatdetailsLinearAdapterBinding.getRoot());
            this.layoutCatdetailsLinearAdapterBinding = layoutCatdetailsLinearAdapterBinding;
        }
    }


}
