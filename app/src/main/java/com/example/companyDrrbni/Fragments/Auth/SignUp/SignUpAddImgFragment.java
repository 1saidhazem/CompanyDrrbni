package com.example.companyDrrbni.Fragments.Auth.SignUp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.Models.Company;
import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentSignUpAddImgBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpAddImgFragment extends Fragment {

    private FragmentSignUpAddImgBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fireStore;
    public SignUpAddImgFragment() {}

    public static SignUpAddImgFragment newInstance() {
        SignUpAddImgFragment fragment = new SignUpAddImgFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUpAddImgBinding
                .inflate(getLayoutInflater(), container, false);

        mAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();

        String name = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getName();
        String email = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getEmail();
        String password = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getPassword();
        String category = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getCategory();
        String governorate = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getGovernorate();
        String address = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getAddress();
        String whatsApp = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getWhatsapp();
        String linkFacebook = SignUpAddImgFragmentArgs.fromBundle(requireArguments()).getLinkFacebook();

        binding.addImgBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!email.equals("") && !password.equals("")) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Company company = new Company(name, email, category, governorate, address, whatsApp, linkFacebook, mAuth.getUid(),false,false);

                                        fireStore.collection("CompanyProfiles").document(mAuth.getUid()).set(company).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d("ttt", "onFailure : " + e.getMessage());
                                            }
                                        });

                                        NavController navController = Navigation.findNavController(binding.getRoot());
                                        navController.navigate(R.id.action_signUpAddImgFragment_to_homeActivity);
//                                    binding.progressBar.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                } else {
                    Log.d("ttt", "else");
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}