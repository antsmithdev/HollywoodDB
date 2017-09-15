package com.droidsmith.hollywooddb.ui.main.fragments.home.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularTVListAdapter extends RecyclerView.Adapter<PopularTVListAdapter.ViewHolder>  {


    private Context context;
    private List<TVShow> TVList;


    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    public PopularTVListAdapter(List<TVShow> TVList, Context context) {
        this.TVList = TVList;
        this.context = context;
    }

    public PopularTVListAdapter(Context context) {
        this.TVList = new ArrayList<>();
        this.context = context;
    }

    public void setResults(List<TVShow> results){
        this.TVList = results;
        notifyDataSetChanged();
    }

    @Override
    public PopularTVListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thumbnail_movie,parent,false);

        //ButterKnife.bind(context, v);
        return new PopularTVListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PopularTVListAdapter.ViewHolder holder, int position) {

        Picasso.with(context)
                .load(IMAGE_URL_BASE_PATH + TVList.get(position).posterPath)
                .into(holder.getPoster());

        holder.getTitle().setText(TVList.get(position).name);

    }

    @Override
    public int getItemCount() {
        return TVList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {


        //@BindView(R.id.thumb_poster)
        TextView title;

        //@BindView(R.id.thumb_title)
        ImageButton poster;

        private ViewHolder(View movieCard) {
            super(movieCard);
            poster = (ImageButton) movieCard.findViewById(R.id.thumb_poster);
            title = (TextView) movieCard.findViewById(R.id.thumb_title);
        }


        public TextView getTitle() {
            return title;
        }

        public ImageView getPoster() {
            return poster;
        }


    }



}
