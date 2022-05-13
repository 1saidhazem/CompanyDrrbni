package com.example.companyDrrbni.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.Adapters.OnboardingPagerAdapter;
import com.example.companyDrrbni.Fragments.SignUp.SignUpFragment;
import com.example.companyDrrbni.databinding.FragmentLoginBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LoginFragment() {
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        // Inflate the layout for this fragment
        FragmentLoginBinding binding = FragmentLoginBinding.inflate(getLayoutInflater());

        String [] tabs = {"تسجيل الدخول","التسجيل"};
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(SignInFragment.newInstance());
        list.add(SignUpFragment.newInstance());

        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(requireActivity(),list);
        binding.loginViewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout,binding.loginViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        }).attach();



        return binding.getRoot();
    }
}
