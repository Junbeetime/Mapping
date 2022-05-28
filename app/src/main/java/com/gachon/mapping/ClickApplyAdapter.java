package com.gachon.mapping;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClickApplyAdapter extends RecyclerView.Adapter<ClickApplyAdapter.ClickApplyHolder>
{
    private Activity activity;

    private List<String> itemNameList;

    private View.OnClickListener clickListener;

    private View.OnCreateContextMenuListener menuClickListener;

    private int currentPostion = 0;

    public ClickApplyAdapter(Activity activity, List<String> itemNameList, View.OnClickListener clickListener, View.OnCreateContextMenuListener menuClickListener)
    {
        this.activity = activity;

        this.itemNameList = itemNameList;

        this. clickListener = clickListener;

        this.menuClickListener = menuClickListener;
    }

    public class ClickApplyHolder extends RecyclerView.ViewHolder
    {
        private CheckedTextView ck_click_title;

        private Button btn_click_item;


        public ClickApplyHolder(@NonNull View itemView) {
            super(itemView);

            ck_click_title = itemView.findViewById(R.id.ck_click_title);

            btn_click_item = itemView.findViewById(R.id.btn_click_item);
        }
    }

    @NonNull
    @Override
    public ClickApplyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);

        View itemView = layoutInflater.inflate(R.layout.diary_title_item, parent, false);

        return new ClickApplyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClickApplyHolder holder, int position)
    {
        String itemName = itemNameList.get(position);

        holder.ck_click_title.setText(itemName);

        holder.btn_click_item.setOnClickListener(clickListener);

        holder.btn_click_item.setOnCreateContextMenuListener(menuClickListener);

        holder.btn_click_item.setTag(position);
    }

    @Override
    public int getItemCount() {
        return itemNameList.size();
    }

    public int getCurrentPostion() {
        return currentPostion;
    }


    public void setCurrentPostion(int currentPostion) {
        this.currentPostion = currentPostion;
    }


}
