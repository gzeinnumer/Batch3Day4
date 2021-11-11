package com.gzeinnumer.batch3day4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyHolder> implements Filterable {

    private List<President> list;
    private List<President> listFilter;

    public RVAdapter(List<President> list) {
        this.list = list;
        this.listFilter = new ArrayList<>(list);
    }

    public void setList(ArrayList<President> list) {
        this.list = list;
        this.listFilter = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvStart;
        public TextView tvEnd;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvStart = itemView.findViewById(R.id.tv_start);
            tvEnd = itemView.findViewById(R.id.tv_end);
        }

        public void bind(President data) {
            tvName.setText(data.getNama());
            tvStart.setText(data.getStart());
            tvEnd.setText(data.getEnd());
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<President> fildteredList = new ArrayList<>();

            String filterPattern = constraint.toString().toLowerCase().trim();

            for (President item : listFilter){
                if( item.getNama().toLowerCase().contains(filterPattern)){
                    fildteredList.add(item);
                }
            }
            FilterResults results = new FilterResults();
            results.values = fildteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
