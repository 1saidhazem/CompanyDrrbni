package com.example.companyDrrbni.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentSignUpContactInformationBinding;
import com.google.android.material.snackbar.Snackbar;

public class SignUpContactInformationFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SignUpContactInformationFragment() {
    }

    public static SignUpContactInformationFragment newInstance(String param1, String param2) {
        SignUpContactInformationFragment fragment = new SignUpContactInformationFragment();
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
        FragmentSignUpContactInformationBinding binding = FragmentSignUpContactInformationBinding
                .inflate(getLayoutInflater(), container, false);


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = SignUpContactInformationFragmentArgs.fromBundle(requireArguments()).getName();
                String email = SignUpContactInformationFragmentArgs.fromBundle(requireArguments()).getEmail();
                String password = SignUpContactInformationFragmentArgs.fromBundle(requireArguments()).getPassword();
                String category = SignUpContactInformationFragmentArgs.fromBundle(requireArguments()).getCategory();
                String governorate = SignUpContactInformationFragmentArgs.fromBundle(requireArguments()).getGovernorate();
                String address = SignUpContactInformationFragmentArgs.fromBundle(requireArguments()).getAddress();
                String whatsApp = binding.etWhatsapp.getText().toString().trim();
                String linkFacebook = binding.etLinkFacebook.getText().toString().trim();

                if (whatsApp.isEmpty()) {
                    Snackbar.make(view, "أدخل رقم الواتس اب", Snackbar.LENGTH_LONG).show();
                } else if (linkFacebook.isEmpty()) {
                    Snackbar.make(view, "أدخل رابط صفحة الفيسبوك", Snackbar.LENGTH_LONG).show();
                } else {
                    NavController navController = Navigation.findNavController(binding.getRoot());
                    navController.navigate(SignUpContactInformationFragmentDirections
                            .actionSignUpContactInformationFragmentToSignUpAddImgFragment(name, email, password, category, governorate, address, whatsApp, linkFacebook));
                }
            }
        });

        return binding.getRoot();
    }
}