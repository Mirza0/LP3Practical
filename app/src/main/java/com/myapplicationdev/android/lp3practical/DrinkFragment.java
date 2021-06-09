package com.myapplicationdev.android.lp3practical;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkFragment extends Fragment {


    public DrinkFragment() {
        RadioGroup Rad;
        ListView lv;
        ArrayAdapter aa;
        ArrayList<String> data;

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_drink, container, false);
            Rad = v.findViewById(R.id.group);
            lv = v.findViewById(R.id.lvDrink);

            DBHelper db = new DBHelper(getActivity());
            data = db.getItemsOfCategory("coffee");
            aa = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, data);
            lv.setAdapter(aa);

            Rad.setOnClickListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {


                    int categoryid = radioGroup.getCheckedRadioButtonId();
                    if (categoryid == R.id.kopi) {
                        DBHelper db = new DBHelper(getActivity());
                        data = db.getItemsOfCategory("coffee");
                    } else if (categoryid == R.id.tea) {
                        DBHelper db = new DBHelper(getActivity());
                        data = db.getItemsOfCategory("tea");
                    }
                    new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, data);
                    lv.setAdapter(aa);


                }


            });
            return;
        }
    }