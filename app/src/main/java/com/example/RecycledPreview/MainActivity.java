package com.example.RecycledPreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ScollablePlacePreviewRecyclerViewAdapter.OnRowClickListener {
    private TextView PicturePreviewTitle, PlacesPreviewTitle;

    RecyclerView ScollablePicturePreviewRecyclerView;
    RecyclerView ScollablePlacesPreviewRecyclerView;
    ScollablePicturePreviewRecyclerViewAdapter ScollablePicturePreviewRecyclerViewAdapter;
    ScollablePlacePreviewRecyclerViewAdapter ScollablePlacePreviewRecyclerViewAdapter;
    List<PicturePreview> picturePreviewList = new ArrayList<>();
    List<PlacesPreview> placesPreviewList = new ArrayList<>();
    Integer[] imageList = {R.drawable.eiffeltower,
                            R.drawable.londonbridge,
                            R.drawable.goldengatebridge,
                            R.drawable.christtheredeemer};

    Integer[] imageListPlaceToGo = {R.drawable.eiffeltower,
                                    R.drawable.londonbridge,
                                    R.drawable.goldengatebridge,
                                    R.drawable.christtheredeemer};

    String[] nameList = {"A", "B", "C", "D"};
    String[] descriptionList = {"This is Eiffel Tower",
                                "This is London Bridge",
                                "This is Golden Gate Bridge",
                                "This is Christ the redeemer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PicturePreviewTitle = findViewById(R.id.Textviewabove);
        PlacesPreviewTitle = findViewById(R.id.Textviewunder);
        ScollablePicturePreviewRecyclerView = findViewById(R.id.ScollablePicturePreview_Hor);
        ScollablePlacesPreviewRecyclerView = findViewById(R.id.ScollablePicturePreview_Ver);
        ScollablePicturePreviewRecyclerViewAdapter = new ScollablePicturePreviewRecyclerViewAdapter(picturePreviewList, MainActivity.this);
        ScollablePlacePreviewRecyclerViewAdapter = new ScollablePlacePreviewRecyclerViewAdapter(placesPreviewList, MainActivity.this, this);
        ScollablePicturePreviewRecyclerView.setAdapter(ScollablePicturePreviewRecyclerViewAdapter);
        ScollablePlacesPreviewRecyclerView.setAdapter(ScollablePlacePreviewRecyclerViewAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManagerPlaceToGo = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ScollablePicturePreviewRecyclerView.setLayoutManager(layoutManager);
        ScollablePlacesPreviewRecyclerView.setLayoutManager(layoutManagerPlaceToGo);

        for (int a = 0; a < imageList.length; a++) { //The horrizontal one.
            PicturePreview PicturePreview = new PicturePreview(a, imageList[a]);
            picturePreviewList.add(PicturePreview);
        }
        for (int a = 0; a < imageListPlaceToGo.length; a++) { // The vertical one.
            PlacesPreview PlacesPreview = new PlacesPreview(a, imageListPlaceToGo[a], nameList[a], descriptionList[a]);
            placesPreviewList.add(PlacesPreview);
        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = DefaultFragment.newInstance(nameList[position],descriptionList[position],imageListPlaceToGo[position]);
        fragmentTransaction.add(R.id.firstFrameLayout1, fragment).commitAllowingStateLoss();
        ScollablePlacesPreviewRecyclerView.setVisibility(View.INVISIBLE);
        ScollablePicturePreviewRecyclerView.setVisibility(View.INVISIBLE);
        PicturePreviewTitle.setVisibility(View.INVISIBLE);
        PlacesPreviewTitle.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (ScollablePlacesPreviewRecyclerView.getVisibility() == View.INVISIBLE) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentManager.getFragments().get(0));
            fragmentTransaction.commit();
            ScollablePlacesPreviewRecyclerView.setVisibility(View.VISIBLE);
            ScollablePicturePreviewRecyclerView.setVisibility(View.VISIBLE);
            PicturePreviewTitle.setVisibility(View.VISIBLE);
            PlacesPreviewTitle.setVisibility(View.VISIBLE);
        }
    }
}