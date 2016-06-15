package com.example.user.cn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Contact extends Fragment implements View.OnClickListener {

    Button btn1,b,c,d;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        btn1 = (Button) v.findViewById(R.id.btncall);
        b = (Button) v.findViewById(R.id.btnemail);
        c = (Button) v.findViewById(R.id.btnlocation);
        d = (Button) v.findViewById(R.id.btnweb);

        btn1.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);


        return v;

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btncall:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9804142425"));
                startActivity(callIntent);

        }
        switch (v.getId()) {
            case R.id.btnemail:
                Uri uri = Uri.parse("http://gmail.com/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


        }
        switch (v.getId()) {
            case R.id.btnlocation:
                Uri uri = Uri.parse("http://youtube.com/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


        }
        switch (v.getId()) {
            case R.id.btnweb:
                Uri uri = Uri.parse("http://www.cntravels.com.np/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


        }

    }
}