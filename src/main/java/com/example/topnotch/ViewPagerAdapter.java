package com.example.topnotch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;



public class ViewPagerAdapter extends FragmentPagerAdapter {

  private final List<Fragment> lstfragment = new ArrayList<>();
  private final List<String> lstTitle = new ArrayList<>();
  private String[] tabTitles = new String[]{"Home delivery", "Self Pickup"};




  public ViewPagerAdapter(@NonNull FragmentManager fm) {



    super(fm);
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return lstfragment.get(position);
  }

  @Override
  public int getCount() {
    return lstTitle.size();
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return tabTitles[position];
  }

  public  void AddFragment(Fragment fragment,String title){
    lstfragment.add(fragment);
    lstTitle.add(title);
  }

}