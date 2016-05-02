package ayon.rahman.shafiqur.btebdynamicapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ayon.rahman.shafiqur.btebdynamicapp.R;

public class ListViewFrag extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listfrag, container, false);
       // onBackPressed();
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.listfragid);
        TextView t = new TextView(getActivity());
        t.setText("Hello From set text");
        t.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        try {
            linearLayout.addView(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String text = getArguments().getString("messagePassing");
        Log.e("Test Check ", text);

        parsing(text);
    }

    public void parsing(String text) {
        Log.e("Test Check ", "inside parsing " + text);

    }
    //not working ?????  31st jan 2016
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            getFragmentManager().popBackStack();

            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }
}