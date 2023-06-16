package com.example.registrator_for_to;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomSheetFragmentE#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomSheetFragmentE extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton imageBtnO1;
    ImageButton imageBtnO2;
    ImageButton imageBtnO3;
    ImageButton imageBtnO4;

    public BottomSheetFragmentE() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomSheetFragmentE.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomSheetFragmentE newInstance(String param1, String param2) {
        BottomSheetFragmentE fragment = new BottomSheetFragmentE();
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
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_e, container, false);
        imageBtnO1 = view.findViewById(R.id.imageBtnO1);
        imageBtnO2 = view.findViewById(R.id.imageBtnO2);
        imageBtnO3 = view.findViewById(R.id.imageBtnO3);
        imageBtnO4 = view.findViewById(R.id.imageBtnO4);
        imageBtnO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrame, new FRFragment()).commit();
                Toast.makeText(getActivity(), "Успех", Toast.LENGTH_SHORT).show();
            }
        });
        imageBtnO2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrame, new FRFragment()).commit();
                Toast.makeText(getActivity(), "Успех", Toast.LENGTH_SHORT).show();
            }
        });
        imageBtnO3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrame, new FRFragment()).commit();
                Toast.makeText(getActivity(), "Успех", Toast.LENGTH_SHORT).show();
            }
        });
        imageBtnO4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrame, new FRFragment()).commit();
                Toast.makeText(getActivity(), "Успех", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}