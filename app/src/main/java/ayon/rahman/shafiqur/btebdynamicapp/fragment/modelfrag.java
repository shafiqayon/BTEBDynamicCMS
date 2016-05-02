package ayon.rahman.shafiqur.btebdynamicapp.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import ayon.rahman.shafiqur.btebdynamicapp.R;
import ayon.rahman.shafiqur.btebdynamicapp.handler;

public class modelfrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    final int size = 8;
    public Bundle bundle;
    handler h = new handler();
    int j = 0;
    Fragment nextfrag = null;
    String buttonBuilder = null;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public modelfrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static modelfrag newInstance(String param1, String param2) {
        modelfrag fragment = new modelfrag();
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


        bundle = new Bundle();
        String testosendtofragment = "Havi Javi";
        bundle.putString("messagePassing", testosendtofragment);

        // Inflate the layout for this fragment
        //static params starts here

        String[] button = new String[size];
        button[0] = "Digital Library";
        button[1] = "Notice";
        button[2] = "History of BTEB";
        button[3] = "Events";
        button[4] = "Mars";
        button[5] = "Jupitar";
        button[6] = "Saturn";
        button[7] = "Neptune";



        final String[] buttonListeners = new String[size];
        buttonListeners[0] = "1";
        buttonListeners[1] = "2";
        buttonListeners[2] = "3";
        buttonListeners[3] = "1";
        buttonListeners[4] = "2";
        buttonListeners[5] = "3";
        buttonListeners[6] = "1";
        buttonListeners[7] = "2";





       /* final String[] buttonListeners = new String[size];
        buttonListeners[0] = "ListView";
        buttonListeners[1] = "SlideTab";
        buttonListeners[2] = "StaticPage";
        buttonListeners[3] = "ListView";
        buttonListeners[4] = "ListView";
        buttonListeners[5] = "SlideTab";
        buttonListeners[6] = "StaticPage";
        buttonListeners[7] = "ListView";*/
        final String[] typeofunderneath = new String[size];
        // 1 for listview 2 for slider and 3 for static page
        typeofunderneath[0] = "1";//1 for listview
        typeofunderneath[1] = "2"; //2 for slider
        typeofunderneath[2] = "3";//3 for staticpage
        typeofunderneath[3] = "1";
        typeofunderneath[4] = "1";//1 for listview
        typeofunderneath[5] = "2"; //2 for slider
        typeofunderneath[6] = "3";//3 for staticpage
        typeofunderneath[7] = "1";

        //static params ends here

        View rootView = inflater.inflate(R.layout.modelfrag, container, false);
        GridLayout gridLayout = (GridLayout) rootView.findViewById(R.id.modelfrag);
        gridLayout.removeAllViews();
        //LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.modelfrag);
        //now I will pull datafrom json and make number of buttons respective with their name
       /* for (int i = 0; i <= 2; i++) {
            buttonBuilder = "bt" + i;
            Button buttonBuilder = new Button(getActivity());
            buttonBuilder.setText(button[i]);
            buttonBuilder.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            final int finalI = i;
            buttonBuilder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    thisis(buttonListeners[finalI], typeofunderneath[finalI]);
                    Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(buttonBuilder);
        }*/
        //grid configuration
        int total = 8;
        int column = 2;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for (int i = 0, c = 0, r = 0; i < total; i++, c++) {
            if (c == column) {
                c = 0;
                r++;
            }
            buttonBuilder = "bt" + i;
            Button buttonObjects = new Button(getActivity());
            buttonObjects.setText(button[i]);
            buttonObjects.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            final int finalI = i;
            buttonObjects.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    thisis(buttonListeners[finalI], typeofunderneath[finalI]);
                }
            });
           /* GridLayout.Spec rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 1);
            GridLayout.Spec colspan = GridLayout.spec(GridLayout.UNDEFINED, 1);*/

           /* if (r == 0 && c == 0) {
                Log.e("", "spec");
                colspan = GridLayout.spec(c, 1);
                rowSpan = GridLayout.spec(r, 1);
            }*/
            GridLayout.Spec rowSpan = GridLayout.spec(r,1);
            GridLayout.Spec colspan = GridLayout.spec(c, 1);
            GridLayout.LayoutParams gridParam = new GridLayout.LayoutParams(
                    rowSpan, colspan);
            gridLayout.addView(buttonObjects, gridParam);
        }//grid ends
        return rootView;


    }

    public void thisis(String type, String url) {

            if (type.equals("1")) {
                ListViewFrag nextfrag = new ListViewFrag();
                nextfrag.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out).commit();
               // getFragmentManager().popBackStack();
                Log.e("Check", "ListView _ Listview tab");
            } else if (type.equals("2")) {
                SliderFrag nextfrag = new SliderFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();

                Log.e("Check", "ListView _ Listview tab");
            } else if (type.equals("3")) {
                SliderFrag nextfrag = new SliderFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out).commit();
                Log.e("Check", "ListView _ Listview tab");
            }



    }

    /*public void thisis(String url, String type) {

        if (url.equals("ListView")) {

            //check which layout should be run from here
            if (type.equals("1")) {
                ListViewFrag nextfrag = new ListViewFrag();
                nextfrag.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).commit();
                Log.e("Check", "ListView _ Listview tab");
            } else if (type.equals("2")) {
                SliderFrag nextfrag = new SliderFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).commit();

                Log.e("Check", "ListView _ Listview tab");
            } else if (type.equals("3")) {
                SliderFrag nextfrag = new SliderFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).commit();
                Log.e("Check", "ListView _ Listview tab");
            }


        } else if (url.equals("SlideTab")) {


            //check which layout should be run from here
            if (type.equals("1")) {
                ListViewFrag nextfrag = new ListViewFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).commit();
                Log.e("Check", "S _s tab");
            } else if (type.equals("2")) {
                SliderFrag nextfrag = new SliderFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).commit();
                Log.e("Check", "s _stab");
            } else if (type.equals("3")) {
                SliderFrag nextfrag = new SliderFrag();
                getFragmentManager().beginTransaction().replace(R.id.myMainActivityFrameContainer, nextfrag).addToBackStack(null).commit();
                Log.e("Check", "s _s tab");
            }
        } else if (url.equals("StaticPage")) {
            System.out.print("Static Page");
            Log.e("Check", "Static Page");
        } else {
            System.out.print("Nothing Found");
            Log.e("Check", "Nothing Found");
        }
    }*/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void onBackPressed()
    {

        FragmentManager fm = getActivity().getFragmentManager();
        fm.popBackStack();
        Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
    }

}
