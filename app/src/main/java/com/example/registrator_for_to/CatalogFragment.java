package com.example.registrator_for_to;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CatalogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CatalogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    AppCompatButton infoBtn;
    AppCompatButton regimBtn;
    AppCompatButton busesBtn;
    AppCompatButton priceBtn;
    AppCompatButton recordBtn;

    public CatalogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CatalogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CatalogFragment newInstance(String param1, String param2) {
        CatalogFragment fragment = new CatalogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //  получаем элемент ListView
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        //присваиваем id полям
        infoBtn = view.findViewById(R.id.infoBtn);
        regimBtn = view.findViewById(R.id.regimBtn);
        busesBtn = view.findViewById(R.id.busesBtn);
        priceBtn = view.findViewById(R.id.priceBtn);
        recordBtn = view.findViewById(R.id.recordBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.mainFrame,new InfoFragment()).commit();
                    }
                });
                thread.start();
            }
        });
        regimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.mainFrame,new RegimFragment()).commit();
                    }
                });
                thread.start();
            }
        });
        busesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.mainFrame,new BusesFragment()).commit();
                    }
                });
                thread.start();
            }
        });
        priceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.mainFrame,new PriceFragment()).commit();
                    }
                });
                thread.start();
            }
        });
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.mainFrame,new RecordFragment()).commit();
                    }
                });
                thread.start();
            }
        });
        return view;

    }
}