package ayon.rahman.shafiqur.btebdynamicapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ayon.rahman.shafiqur.btebdynamicapp.R;


public class StaticFragment extends android.app.Fragment {
    String t;

    public StaticFragment(String t) {
        this.t = t;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_static, container, false);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}