package com.example.cinemaapp.model;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.cinemaapp.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private List<Integer> listOfPlaces;
    private List<Integer> selectedPositions;
    private Context mContext;

    public GridViewAdapter(List<Integer> listOfPlaces, Context mContext) {
        this.listOfPlaces = listOfPlaces;
        this.mContext = mContext;
        this.selectedPositions = new ArrayList<>();
    }

    public List<Integer> getSelectedPositions() {
        return selectedPositions;
    }

    @Override
    public int getCount() {
        return listOfPlaces.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfPlaces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(mContext);
            button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(8,8,8,8);
            button.setText(Integer.toString(listOfPlaces.get(position)));
            button.setBackgroundColor(Color.LTGRAY);
            button.setTextColor(Color.BLACK);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(((Button)view).getText());
                    int pos = Integer.parseInt(((Button)view).getText().toString());

                    int selectedIndex = selectedPositions.indexOf(pos);
                    if (selectedIndex > -1) {
                        selectedPositions.remove(selectedIndex);
                        ((Button)view).setBackgroundColor(Color.LTGRAY);
                    } else {
                        selectedPositions.add(pos);
                        ((Button)view).setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.titleColor));
                    }
                }
            });
        } else {
          button = (Button)convertView;
        }

        return button;
    }
}