package com.example.companyDrrbni.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentSignUpAddressBinding;
import com.google.android.material.snackbar.Snackbar;


public class SignUpAddressFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SignUpAddressFragment() {
    }

    public static SignUpAddressFragment newInstance(String param1, String param2) {
        SignUpAddressFragment fragment = new SignUpAddressFragment();
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
        FragmentSignUpAddressBinding binding = FragmentSignUpAddressBinding.inflate(getLayoutInflater(), container, false);

        binding.signUpBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = SignUpAddressFragmentArgs.fromBundle(requireArguments()).getName();
                String email = SignUpAddressFragmentArgs.fromBundle(requireArguments()).getEmail();
                String password = SignUpAddressFragmentArgs.fromBundle(requireArguments()).getPassword();
                String category = SignUpAddressFragmentArgs.fromBundle(requireArguments()).getCategory();
                String governorate = binding.signUpEtGovernorate.getText().toString().trim();
                String address = binding.signUpEtAddress.getText().toString().trim();

                if (governorate.isEmpty()) {
                    Snackbar.make(view, "حدد المحافظة", Snackbar.LENGTH_LONG).show();
                } else if (address.isEmpty()) {
                    Snackbar.make(view, "أدخل العنوان", Snackbar.LENGTH_LONG).show();
                } else {
                    NavController navController = Navigation.findNavController(binding.getRoot());
                    navController.navigate(SignUpAddressFragmentDirections
                            .actionSignUpAddressFragmentToSignUpContactInformationFragment(name, email, password, category, governorate, address));
                }
            }
        });

        return binding.getRoot();
    }
}