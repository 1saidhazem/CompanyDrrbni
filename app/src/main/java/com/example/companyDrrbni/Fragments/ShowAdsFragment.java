package com.example.companyDrrbni.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.databinding.FragmentShowAdsBinding;

public class ShowAdsFragment extends Fragment {

    private FragmentShowAdsBinding binding;
    public ShowAdsFragment() {}

    public static ShowAdsFragment newInstance() {
        return new ShowAdsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShowAdsBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}