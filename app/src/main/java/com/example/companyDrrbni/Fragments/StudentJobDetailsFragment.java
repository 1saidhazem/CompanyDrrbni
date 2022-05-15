package com.example.companyDrrbni.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.databinding.FragmentStudentJobDetailsBinding;

public class StudentJobDetailsFragment extends Fragment {

    private FragmentStudentJobDetailsBinding binding;
    public StudentJobDetailsFragment() {}

    public static StudentJobDetailsFragment newInstance(String param1, String param2) {
        StudentJobDetailsFragment fragment = new StudentJobDetailsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStudentJobDetailsBinding
                .inflate(getLayoutInflater(),container,false);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}