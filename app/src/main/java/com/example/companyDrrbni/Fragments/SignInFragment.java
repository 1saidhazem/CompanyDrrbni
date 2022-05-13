package com.example.companyDrrbni.Fragments;

import static com.example.companyDrrbni.Constant.COLLECTION_COMPANY_PROFILES;
import static com.example.companyDrrbni.Constant.EMAIL;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.companyDrrbni.Models.Company;
import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentSignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class SignInFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fireStore;
    private Company company = new Company();

    public SignInFragment() {
    }

    public static SignInFragment newInstance() {  // String param1, String param2
        SignInFragment fragment = new SignInFragment();
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
        company = new Company();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSignInBinding binding = FragmentSignInBinding.inflate(getLayoutInflater(), container, false);

        mAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.loginEmail.getText().toString().trim();
                String password = binding.loginPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    Snackbar.make(view, "أدخل الايميل", Snackbar.LENGTH_LONG).show();
                } else if (password.isEmpty()) {
                    Snackbar.make(view, "أدخل كلمة المرور", Snackbar.LENGTH_LONG).show();
                } else {
                    fireStore.collection(COLLECTION_COMPANY_PROFILES).whereEqualTo(EMAIL, email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot doc : task.getResult()) {
                                    company = doc.toObject(Company.class);
                                    break;
                                }
                                Log.d("ttt", company.getEmail());
                                //TODO:: if account is active or not and user type company

                                if (company.getEmail().equals(email)) {
                                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                NavController navController = Navigation.findNavController(binding.getRoot());
                                                navController.navigate(R.id.action_login_to_homeActivity);
                                                binding.progressBar.setVisibility(View.INVISIBLE);
                                            } else {
                                                binding.progressBar.setVisibility(View.VISIBLE);
                                                Snackbar.make(view, task.getException().getMessage() , Snackbar.LENGTH_LONG).show();
                                            }
                                            binding.progressBar.setVisibility(View.INVISIBLE);
                                        }
                                    });
                                }
                            } else {
                                binding.progressBar.setVisibility(View.INVISIBLE);
                                Snackbar.make(view, "ليس لديك الصلاحية في الوصول الى هذا الحساب", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });

        binding.loginTvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(binding.getRoot());
                navController.navigate(R.id.action_loginFragment_to_forgotPasswordFragment);
            }
        });

        return binding.getRoot();
    }
}