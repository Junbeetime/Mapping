package com.gachon.mapping;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShareClickApplyAdapter extends RecyclerView.Adapter<ShareClickApplyAdapter.ClickApplyHolder>
{
    private Activity activity;

    private List<String> itemNameList;

    private View.OnClickListener clickListener;

    private View.OnCreateContextMenuListener menuClickListener;

    private int currentPosition = 0;

    public ShareClickApplyAdapter(Activity activity, List<String> itemNameList, View.OnClickListener clickListener, View.OnCreateContextMenuListener menuClickListener)
    {
        this.activity = activity;

        this.itemNameList = itemNameList;

        this.clickListener = clickListener;

        this.menuClickListener = menuClickListener;
    }



    public class ClickApplyHolder extends RecyclerView.ViewHolder
    {
        private TextView ck_click_title;

        private Button btn_look_item;

        public ClickApplyHolder(@NonNull View itemView)
        {
            super(itemView);

            ck_click_title = itemView.findViewById(R.id.ck_click_title);


            btn_look_item = itemView.findViewById(R.id.btn_look_item);


        }
    }

    @NonNull
    @Override
    public ShareClickApplyAdapter.ClickApplyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);

        View itemView = layoutInflater.inflate(R.layout.sharediary_title_item, parent, false);

        return new ClickApplyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShareClickApplyAdapter.ClickApplyHolder holder, int position)
    {
        String itemName = itemNameList.get(position);

        holder.ck_click_title.setText(itemName);

        holder.btn_look_item.setOnClickListener(clickListener);

        holder.btn_look_item.setTag(position);

    }

    @Override
    public int getItemCount()
    {
        return itemNameList.size();
    }

    public int getCurrentPosition()
    {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition)
    {
        this.currentPosition = currentPosition;
    }




}