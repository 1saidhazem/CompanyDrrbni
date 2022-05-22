package com.example.companyDrrbni.Fragments.Auth.SignIn;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.Adapters.OnboardingPagerAdapter;
import com.example.companyDrrbni.databinding.FragmentLoginBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import com.example.companyDrrbni.Fragments.Auth.SignUp.SignUpFragment;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    public LoginFragment() {}

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding
                .inflate(getLayoutInflater(),container,false);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
