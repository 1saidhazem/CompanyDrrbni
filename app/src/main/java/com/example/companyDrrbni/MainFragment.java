package com.example.companyDrrbni;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.companyDrrbni.Fragments.BottomNavigationScreens.CategoriesFragment;
import com.example.companyDrrbni.Fragments.BottomNavigationScreens.HomeFragment;
import com.example.companyDrrbni.Fragments.BottomNavigationScreens.NotificationsFragment;
import com.example.companyDrrbni.Fragments.BottomNavigationScreens.ProfileFragment;
import com.example.companyDrrbni.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = FragmentMainBinding.inflate(getLayoutInflater(),container,false);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(HomeFragment.newInstance());
        list.add(CategoriesFragment.newInstance());
        list.add(NotificationsFragment.newInstance());
        list.add(ProfileFragment.newInstance());

        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.mainFragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);

        return binding.getRoot();
    }
}