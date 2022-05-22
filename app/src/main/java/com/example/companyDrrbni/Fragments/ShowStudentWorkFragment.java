package com.example.companyDrrbni.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.databinding.FragmentShowStudentWorkBinding;

public class ShowStudentWorkFragment extends Fragment {

    private FragmentShowStudentWorkBinding binding;
    public ShowStudentWorkFragment() {}

    public static ShowStudentWorkFragment newInstance() {
        return new ShowStudentWorkFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShowStudentWorkBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

}