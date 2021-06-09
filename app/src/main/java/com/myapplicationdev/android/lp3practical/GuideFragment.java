package com.myapplicationdev.android.lp3practical;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GuideFragment extends Fragment {

    ImageView iv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide,container,false);
        iv = v.findViewById();
        String myUrl = "https://cdn-blog.seedly.sg/wp-content/uploads/2018/10/03105442/coffee-guide-in-article.png";
        Picasso.with(getActivity())load(myUrl).into(iv);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guide, container, false);
    }
}