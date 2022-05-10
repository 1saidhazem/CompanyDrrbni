package com.example.companyDrrbni.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentSignUpBinding;
import com.google.android.material.snackbar.Snackbar;

public class SignUpFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SignUpFragment() {}

    public static SignUpFragment newInstance() {  // String param1, String param2
        SignUpFragment fragment = new SignUpFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
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
        FragmentSignUpBinding binding = FragmentSignUpBinding.inflate(getLayoutInflater(),container,false);


        binding.signUpBtnCompleteTheRegistrationProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(binding.getRoot());
                navController.navigate(R.id.action_loginFragment_to_signUpAddressFragment5);
            }
        });


        return binding.getRoot();
    }
}