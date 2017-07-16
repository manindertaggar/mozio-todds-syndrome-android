package com.manindertaggar.toddssyndrome.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manindertaggar.toddssyndrome.R;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.storage.Dao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Maninder Taggar on 16/7/17.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder> {

    private Context context;
    private List<SyndromTest> syndromTestList;

    public ResultsAdapter(Context context) {
        this.context = context;
        syndromTestList = Dao.getDaoSession().getSyndromTestDao().loadAll();
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_syndrome_calculator, parent, false);
        return new ResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        holder.setData(syndromTestList.get(position));
    }

    @Override
    public int getItemCount() {
        return syndromTestList.size();
    }


    public class ResultViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSex)
        TextView tvSex;
        @BindView(R.id.tvAge)
        TextView tvAge;
        @BindView(R.id.tvMigranes)
        TextView tvMigranes;
        @BindView(R.id.tvDrugs)
        TextView tvDrugs;
        @BindView(R.id.tvProbability)
        TextView tvProbability;

        public ResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(SyndromTest syndromTest) {
            tvSex.setText(syndromTest.getIsMale() ? "Male" : "Female");
            tvMigranes.setText(syndromTest.getHaveMigranes() ? "Yes" : "No");
            tvDrugs.setText(syndromTest.getUsesHallucinogeninDrugs() ? "Yes" : "No");
            tvAge.setText(syndromTest.getAge() + "");
            tvProbability.setText(syndromTest.getProbabity() + " %");
        }
    }
}
