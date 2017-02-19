package com.example.pulkitluthra.acmandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by PULKIT LUTHRA on 2/12/2017.
 */

public class RecyclerAndroidClass extends RecyclerView.Adapter<RecyclerAndroidClass.CustomViewHolder> {

    private List<DataSample> DataSampleList;
    private Context mContext;


    public RecyclerAndroidClass(Context context, List<DataSample> feedItemList) {
        this.DataSampleList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crd_main, viewGroup,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        DataSample feedItem = DataSampleList.get(i);

        if (!TextUtils.isEmpty(feedItem.getImage())) {
            Picasso.with(mContext).load(feedItem.getImage())

                    .into(customViewHolder.imageView);
        }


        customViewHolder.textView1.setText(Html.fromHtml(feedItem.getTitle1()));
        customViewHolder.textView2.setText(Html.fromHtml(feedItem.getTitle2()));


    }

    @Override
    public int getItemCount() {
        return (null != DataSampleList ? DataSampleList.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView textView1;
        protected TextView textView2;
        protected ImageView imageView;


        public CustomViewHolder(View view) {
            super(view);

            this.imageView = (ImageView) view.findViewById(R.id.image);
            this.textView1 = (TextView) view.findViewById(R.id.title1);
            this.textView2 = (TextView) view.findViewById(R.id.title2);
        }
    }
}


