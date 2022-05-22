package com.example.companyDrrbni.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.databinding.FragmentProfileStudentBinding;

public class StudentProfileFragment extends Fragment {

    private FragmentProfileStudentBinding binding;
    public StudentProfileFragment() {}

    public static StudentProfileFragment newInstance() {
        return new StudentProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileStudentBinding
                .inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

}