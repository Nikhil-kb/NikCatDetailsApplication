package com.example.nikcatdetailsapp.cat_details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nikcatdetailsapp.R;
import com.example.nikcatdetailsapp.databinding.LayoutCatdetailsGridAdapterBinding;
import com.example.nikcatdetailsapp.databinding.LayoutCatdetailsGridAdapterBinding;
import com.example.nikcatdetailsapp.networking.model.CatDetailsRes;

import java.util.ArrayList;
import java.util.List;

public class CatDetailsGridAdapter extends RecyclerView.Adapter<CatDetailsGridAdapter.MyViewHolder> {

    private Context context;
    private List<CatDetailsRes> catDetailsResList = new ArrayList<>();

    public CatDetailsGridAdapter(Context context, List<CatDetailsRes> catDetailsResList) {
        this.context = context;
        this.catDetailsResList = catDetailsResList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCatdetailsGridAdapterBinding layoutCatdetailsGridAdapterBinding =
                LayoutCatdetailsGridAdapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(layoutCatdetailsGridAdapterBinding);
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
                .into(holder.layoutCatdetailsGridAdapterBinding.ivCatImage);


        if (CatDetailsRes.getName() != null) {
                holder.layoutCatdetailsGridAdapterBinding.tvName.setText(CatDetailsRes.getName());
            }
            

    }

    @Override
    public int getItemCount() {
        return catDetailsResList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LayoutCatdetailsGridAdapterBinding layoutCatdetailsGridAdapterBinding;

        public MyViewHolder(LayoutCatdetailsGridAdapterBinding layoutCatdetailsGridAdapterBinding) {
            super(layoutCatdetailsGridAdapterBinding.getRoot());
            this.layoutCatdetailsGridAdapterBinding = layoutCatdetailsGridAdapterBinding;
        }
    }


}
