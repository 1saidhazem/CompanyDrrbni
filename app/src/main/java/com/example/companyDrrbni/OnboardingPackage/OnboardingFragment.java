package com.example.companyDrrbni.OnboardingPackage;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.companyDrrbni.Adapters.OnboardingPagerAdapter;
import com.example.companyDrrbni.R;
import com.example.companyDrrbni.databinding.FragmentOnboardingBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class OnboardingFragment extends Fragment {

    FragmentOnboardingBinding binding ;
    int position = 0;
    Animation btnAnimation;

    public OnboardingFragment() {
        // Required empty public constructor
    }


    public static OnboardingFragment newInstance(int screen_img, int title , int description) {
        OnboardingFragment fragment = new OnboardingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (restorePrefData()){
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_onboarding_to_login);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         binding = FragmentOnboardingBinding.inflate(getLayoutInflater());

        // ArrayList of on boarding fragments

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(OnboardingContainerFragment.newInstance(R.drawable.onboarding1 ,
                R.string.onboarding1_title , R.string.onboarding1_subtitle ));

        fragments.add(OnboardingContainerFragment.newInstance(R.drawable.onboarding2 ,
                R.string.onboarding2_title , R.string.onboarding2_subtitle ));

        fragments.add(OnboardingContainerFragment.newInstance(R.drawable.onboarding3 ,
                R.string.onboarding3_title , R.string.onboarding3_subtitle ));

        fragments.add(OnboardingContainerFragment.newInstance(R.drawable.onboarding1 ,
                R.string.onboarding4_title , R.string.onboarding4_subtitle ));

        OnboardingPagerAdapter pagerAdapter = new OnboardingPagerAdapter(requireActivity() , fragments);

        binding.onboardingSlider.setAdapter(pagerAdapter);

        new TabLayoutMediator(binding.dotSlider, binding.onboardingSlider, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();

        btnAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.button_animation);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = binding.onboardingSlider.getCurrentItem();
                if (position < fragments.size()) {
                    position++;
                    binding.onboardingSlider.setCurrentItem(position);
                }
                if (position == fragments.size()-1) {
                    loadedLastScreen();
                }
            }
        });


        binding.getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(binding.getRoot());
                navController.navigate(R.id.action_onboarding_to_login);
                savePrefsData();
            }
        });

        binding.dotSlider.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == fragments.size()-1) {
                    loadedLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return binding.getRoot();
    }
    private Boolean restorePrefData() {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(requireContext());
        Boolean isOpened = sharedPreferences.getBoolean("isIntroOpened", false);

        return isOpened;
    }

    private void savePrefsData() {
        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
        sharedPreferencesEditor.putBoolean("isIntroOpened", true);
        sharedPreferencesEditor.apply();
    }

    private void loadedLastScreen() {
        binding.btnNext.setVisibility(View.INVISIBLE);
        binding.getStarted.setVisibility(View.VISIBLE);
        binding.dotSlider.setVisibility(View.INVISIBLE);
        binding.getStarted.setAnimation(btnAnimation);
    }

}