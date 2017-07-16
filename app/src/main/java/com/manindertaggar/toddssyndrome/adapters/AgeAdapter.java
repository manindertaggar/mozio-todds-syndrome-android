package com.manindertaggar.toddssyndrome.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manindertaggar.toddssyndrome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Maninder Taggar on 16/7/17.
 */

public class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder> {

    private static final int MAX_AGE = 120;
    private Context context;
    private AgeSelectedListener ageSelectedListener;

    public AgeAdapter(Context context, AgeSelectedListener ageSelectedListener) {
        this.context = context;
        this.ageSelectedListener = ageSelectedListener;
    }

    @Override
    public AgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_age, parent, false);
        return new AgeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AgeViewHolder holder, int position) {
        final int age = position + 1;
        holder.tvAge.setText("" + age);
        holder.tvAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ageSelectedListener.onAgeSelected(age);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MAX_AGE-1;
    }

    class AgeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvAge)
        TextView tvAge;

        public AgeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static interface AgeSelectedListener {
        void onAgeSelected(int age);
    }
}
