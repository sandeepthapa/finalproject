package com.example.user.cn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;
    Button c,d,e,f,g;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        c = (Button)x.findViewById(R.id.btn1);
        c.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment fragment = new Flightticket();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commit();
                c.setVisibility(View.GONE);
            }
        });
        d = (Button)x.findViewById(R.id.btn2);
        d.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment fragment = new Vehicleticketing();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commit();
                c.setVisibility(View.GONE);
            }
        });
        e = (Button)x.findViewById(R.id.btn3);
        e.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment fragment = new Spinner1();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commit();
                c.setVisibility(View.GONE);
            }
        });
        f = (Button)x.findViewById(R.id.btn4);
        f.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment fragment = new Tour();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commit();
                c.setVisibility(View.GONE);
            }
        });
        g = (Button)x.findViewById(R.id.btn5);
        g.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Fragment fragment = new Adventurousactivities();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commit();
                c.setVisibility(View.GONE);
            }
        });


        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            Fragment primaryFrag = new PrimaryFragment();
            switch (position){
                case 0 :
                    Bundle basket = new Bundle();
                    basket.putInt("image",R.drawable.lake);
                    primaryFrag.setArguments(basket);
                    return primaryFrag;

                case 1 :
                    Bundle basket1 = new Bundle();
                    basket1.putInt("image",R.drawable.lake3);
                    primaryFrag.setArguments(basket1);
                    return primaryFrag;
                case 2 :
                    Bundle basket2 = new Bundle();
                    basket2.putInt("image",R.drawable.pkr);
                    primaryFrag.setArguments(basket2);
                    return primaryFrag;
                case 3 :
                    Bundle basket3 = new Bundle();
                    basket3.putInt("image",R.drawable.pkr);
                    primaryFrag.setArguments(basket3);
                    return primaryFrag;
                case 4 :
                    Bundle basket4 = new Bundle();
                    basket4.putInt("image",R.drawable.pkr);
                    primaryFrag.setArguments(basket4);
                    return primaryFrag;
                case 5 :
                    Bundle basket5= new Bundle();
                    basket5.putInt("image",R.drawable.pkr);
                    primaryFrag.setArguments(basket5);
                    return primaryFrag;
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "lake";
                case 1 :
                    return "Mountain";
                case 2 :
                    return "boat";
                case 3 :
                    return "Mardi HImal";
                case 4:
                    return "Lwang ghalel";
                case 5 :
                    return "Ghandruk";
            }
            return null;
        }
    }

}