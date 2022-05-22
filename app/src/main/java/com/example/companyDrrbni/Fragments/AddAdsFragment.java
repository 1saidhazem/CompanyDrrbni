package com.example.companyDrrbni.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentAddAdsBinding;

public class AddAdsFragment extends Fragment {

    private FragmentAddAdsBinding binding;
    public AddAdsFragment() {}

    public static AddAdsFragment newInstance() {
        return new AddAdsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddAdsBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}