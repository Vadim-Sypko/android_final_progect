package com.example.registrator_for_to;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText nameEditText;
    EditText loginEditText;
    EditText passEditText;
    AppCompatButton regBtn;

    public RegFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegFragment newInstance(String param1, String param2) {
        RegFragment fragment = new RegFragment();
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
        View view = inflater.inflate(R.layout.fragment_reg, container, false);
        nameEditText = view.findViewById(R.id.nameEditText);
        loginEditText = view.findViewById(R.id.loginEditText);
        passEditText = view.findViewById(R.id.passEditText);
        regBtn = view.findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();   // сщздаем строковую переменную name и читаем введенную пользователем информацию
                String login = loginEditText.getText().toString(); // создаем строковую переменную login и читаем введеную пользователем информацию
                String pass = passEditText.getText().toString();// создаем строковую переменную pass и читаем введеную пользователем информацию
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (Connector.reg(name,login,pass)){
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.mainFrame,new CatalogFragment()).commit();// у fragmentTransaction, вызываем метод replace и заменяем экран на новый фрагмент
                                    Toast.makeText(getActivity().getApplicationContext(), "Вы успешно авторизовались", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else{
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity().getApplicationContext(), "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
                thread.start();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}