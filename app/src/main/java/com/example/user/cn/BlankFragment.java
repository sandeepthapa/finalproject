package com.example.user.cn;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



public class BlankFragment extends Fragment implements ImageButton.OnClickListener, AdapterView.OnItemSelectedListener{
    private String mParam1;
    private String mParam2;
    private TextView txtdate;
    private int dd;
    private int mm;
    private int yy;
    private DatePickerDialog mDatePickerDialog;
    private ImageButton dates;
    private SimpleDateFormat dateFormatter;

    public BlankFragment() {
        // Required empty public constructor
    }
    public interface fragment1{

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setDateTimeField();
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_blank, container, false);
        View view = null;
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        dates = (ImageButton) view.findViewById(R.id.imgbtncal);
        dates.setOnClickListener(this);
        txtdate=(TextView) view.findViewById(R.id.txtappdate);
        txtdate.setInputType(InputType.TYPE_NULL);
//        String [] City =
//                {"Kathmandu","Pokhara","Baglung",};
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner.setAdapter(adapter);
        return view;
    }
    public void onClick(View view) {
        mDatePickerDialog.show();
    }
    private void setDateTimeField() {
        dates.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener mDateSetListener
                = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int selectedYear,
                                  int selectedMonth, int selectedDay) {
                yy=selectedYear;
                mm=selectedMonth;
                dd=selectedDay;
                //age.setDateOfBirth(startYear, startMonth, startDay);
                txtdate.setText(""+dd+"-"+(mm+1)+"-"+yy);
                //calculateAge();
            }
        };}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
