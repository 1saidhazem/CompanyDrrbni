package com.example.companyDrrbni.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.LoginFragmentDirections;
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
                String name = binding.signUpEtName.getText().toString().trim();
                String email = binding.signUpEtEmail.getText().toString().trim();
                String password = binding.signUpEtPassword.getText().toString().trim();
                String category = binding.signUpEtCategory.getText().toString().trim();

                if (name.isEmpty()) {
                    Snackbar.make(view, "أدخل الاسم", Snackbar.LENGTH_LONG).show();
                } else if (email.isEmpty()) {
                    Snackbar.make(view, "أدخل الايميل", Snackbar.LENGTH_LONG).show();
                } else if (password.isEmpty()) {
                    Snackbar.make(view, "أدخل كلمة المرور", Snackbar.LENGTH_LONG).show();
                } else if (password.length() < 6) {
                    Snackbar.make(view, "أدخل كلمة المرور أكبر من 6 أحرف", Snackbar.LENGTH_LONG).show();
                } else if (category.isEmpty()) {
                    Snackbar.make(view, "حدد التصنيف", Snackbar.LENGTH_LONG).show();
                }else {
                    NavController navController = Navigation.findNavController(binding.getRoot());
                    navController.navigate
                            (LoginFragmentDirections.actionLoginFragmentToSignUpAddressFragment(name,email,password,category));
                }
            }
        });


        return binding.getRoot();
    }
}