package id.telkomuniversity.tika.mymovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.telkomuniversity.tika.mymovie.R;

/**
 * Created by Ajie_Arga on 1/12/2016.
 */
public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder>{
    private List<String> dataMovie;
    private AdapterListener adapterListener;
    private Context mContext;

    public AdapterMovie(List<String> dataMovie,AdapterListener adapterListener){
        this.dataMovie=dataMovie;
        this.adapterListener=adapterListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        View view= LayoutInflater.from(mContext).inflate(R.layout.row_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String item = dataMovie.get(position);
        holder.title.setText(item);
        holder.layoutMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterListener.onClick(item,position);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.layout_movie)
        LinearLayout layoutMovie;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    @Override
    public int getItemCount() {
        return dataMovie.size();
    }

    public interface AdapterListener{
        void onClick(String item,int position);
    }
}
