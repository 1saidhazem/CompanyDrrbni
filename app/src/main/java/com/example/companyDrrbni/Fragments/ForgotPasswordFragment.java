package com.example.companyDrrbni.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentForgotPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ForgotPasswordFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FirebaseAuth mAuth;

    public ForgotPasswordFragment() {
    }

    public static ForgotPasswordFragment newInstance(String param1, String param2) {
        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
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

        FragmentForgotPasswordBinding binding = FragmentForgotPasswordBinding.inflate(getLayoutInflater(), container, false);

        mAuth = FirebaseAuth.getInstance();



        binding.forgotPasswordBtnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.forgotPasswordEtEmail.getText().toString().trim();

                if (email.isEmpty()) {
                    Snackbar.make(view, "أدخل البريد الالكتروني", Snackbar.LENGTH_LONG).show();
                    binding.progressBar.setVisibility(View.GONE);
                } else {
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Snackbar.make(view, "تم إرسال رابط إعادة تعيين كلمة المرور على بريدك الإلكتروني", Snackbar.LENGTH_LONG).show();
                                NavController navController = Navigation.findNavController(binding.getRoot());
                                navController.navigate(R.id.action_forgotPasswordFragment_to_loginFragment);
                            } else {
                                Snackbar.make(view, task.getException().getMessage() , Snackbar.LENGTH_LONG).show();
                            }
                            binding.progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

        return binding.getRoot();
    }

}