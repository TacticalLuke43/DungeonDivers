package csc310.dungeondivers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.R.attr.fragment;

public class AdventureBottom extends Fragment{
    adventureActivity2 activity2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.adventure_bottom, container, false);
        return view;

    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity2 = new adventureActivity2();


    }

    public void showSocial(View view)
    {
      //  activity2.changeFragment();
    }
}
