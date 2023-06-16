package com.example.registrator_for_to;

import static android.app.TimePickerDialog.*;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FRFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FRFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String[] autoMarka ={"Toyota", "Nissan", "BMW"};
    Spinner spAutoMarka = null;
    private String[] autoModel ={"Yaris","Qashqai", "X6"};
    Spinner spAutoModel=null;
    EditText date_time_in;
    private TextView mTv_status;
    AppCompatButton mBtn_record;


    public FRFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FRFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FRFragment newInstance(String param1, String param2) {
        FRFragment fragment = new FRFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_f_r, container, false);
        spAutoMarka =  view.findViewById(R.id.spAutoMarka);
        spAutoModel = view.findViewById(R.id.spAutoModel);
        date_time_in=view.findViewById(R.id.date_time_input);
        mBtn_record = view.findViewById(R.id.mBtn_record);
        mTv_status = view.findViewById(R.id.mTv_status);

        date_time_in.setInputType(InputType.TYPE_NULL);

        createSpinner(autoMarka, spAutoMarka);
        createSpinner1(autoModel,spAutoModel);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, autoMarka);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAutoMarka.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, autoModel);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAutoModel.setAdapter(adapter1);

        date_time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_time_in);
            }
        });
        mBtn_record.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String car_brand =
                        spAutoMarka.getSelectedItem().toString();
                String car_model =
                        spAutoModel.getSelectedItem().toString();
                String date_time = date_time_in.getText().toString();
                if(car_brand.isEmpty() || car_model.isEmpty() ||
                        date_time.isEmpty()){
                    mTv_status.setText("Пожалуйста, заполните форму, чтобы продолжить.");
                    mTv_status.setVisibility(View.VISIBLE);
                } else {

                    mBtn_record.setEnabled(false);
                    mTv_status.setText("Ваше транспортное средство " +autoMarka+ " - " + autoModel + " записано на диагностику: " +
                            date_time);
                }
            }
        });
        return view;
    }

    public void createSpinner(String[] autoMarka, Spinner spAutoMarka){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, autoMarka);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAutoMarka.setAdapter(adapter);
    }
    public void createSpinner1(String[] autoModel, Spinner spAutoModel){
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, autoModel);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAutoModel.setAdapter(adapter1);
    }
    private void showDateTimeDialog(final EditText date_time_in) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                OnTimeSetListener timeSetListener=new OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd HH:mm");

                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(getActivity(),timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(getActivity(),dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

    }


}