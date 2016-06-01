package com.example.user.cn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class PrimaryFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_primary, container,false);
        ImageView imageView = (ImageView)rootView.findViewById(R.id.imageView);
        int imageId = getArguments().getInt("image");
        imageView.setImageResource(imageId);
        return rootView;
    }
}