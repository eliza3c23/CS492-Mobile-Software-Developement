package com.example.android.basicweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;


public class WeatherAdpater extends RecyclerView.Adapter<WeatherAdpater.W_ViewHolder> {

    private List<String> mDayWeatherList;
    private OnWeatherCheckChangedListener mListener;
    private LayoutInflater mInflater;

    public interface OnWeatherCheckChangedListener{
        void onWeatherCheckedChanged(View v,int pos);
    }

    public WeatherAdpater(Context content, List<String> list){
       this.mInflater = LayoutInflater.from(content);
       this.mDayWeatherList = list;
    }
    @Override
    public W_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.weather_list_item, parent, false);
        W_ViewHolder viewHolder = new W_ViewHolder(v);
        return  viewHolder;
    }
    @Override
    public void onBindViewHolder(W_ViewHolder holder, int position){
        String weather = mDayWeatherList.get(position);
        holder.mWeatherTextView.setText(weather);
        //holder.bind(weather);
    }
    @Override
    public int getItemCount(){
        return mDayWeatherList.size();
    }
    class W_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mWeatherTextView;

        public W_ViewHolder(final View v) {
            super(v);
            mWeatherTextView = v.findViewById(R.id.tv_weather);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mListener != null)
                mListener.onWeatherCheckedChanged(v, getAdapterPosition());
        }
    }
       void setClickListener(OnWeatherCheckChangedListener clickListener){
            this.mListener = clickListener;
       }

    }

