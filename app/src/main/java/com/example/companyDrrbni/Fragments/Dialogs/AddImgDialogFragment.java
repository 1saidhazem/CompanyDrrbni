package com.example.companyDrrbni.Fragments.Dialogs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.databinding.FragmentAddImgDialogBinding;

public class AddImgDialogFragment extends Fragment {

    private FragmentAddImgDialogBinding binding;
    public AddImgDialogFragment() {}

    public static AddImgDialogFragment newInstance() {
        AddImgDialogFragment fragment = new AddImgDialogFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddImgDialogBinding
                .inflate(getLayoutInflater(),container,false);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}