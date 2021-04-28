package com.example.RecycledPreview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DefaultFragment extends Fragment {

    private static final String ARG_PARAM1 = "Holder1";
    private static final String ARG_PARAM2 = "Holder2";

    private String Container1;
    private String Container2;




    public DefaultFragment() {
        //Yep, should just leave this place empty.
    }


    public static DefaultFragment newInstance(String name, String description, Integer imageID) {
        DefaultFragment firstDefaultFragment = new DefaultFragment();
        Bundle args = new Bundle();
        args.putString("name",name);
        args.putString("description",description);
        args.putInt("image",imageID);
        firstDefaultFragment.setArguments(args);
        return firstDefaultFragment;
        //passing names, descriptions and image based on id.
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Container1 = getArguments().getString(ARG_PARAM1);
            Container2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView DefaultImageDisplay = view.findViewById(R.id.UpOnClickDefaultPlaceImage);
        TextView Toplist = view.findViewById(R.id.UponClickPlaceName);
        TextView UnderList = view.findViewById(R.id.UpOnClickPlaceDescription);
        //react and display corresponding name, place, image and description based up on selection and choice made.

        if(getArguments()!=null)
        {
            DefaultImageDisplay.setImageResource(getArguments().getInt("image"));
            Toplist.setText(getArguments().getString("name"));
            UnderList.setText(getArguments().getString("description"));
            //if accessable, display, Else nothing happens.
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_place_fragment, container, false);
    }
}