package com.example.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class OverviewFragment extends Fragment {
    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_overview, container, false);

        // Find ImageView with ID overview_image and set the image resource
        ImageView nigeriaImage = rootView.findViewById(R.id.overview_image);
        nigeriaImage.setImageResource(R.drawable.nigeria_coat_of_arm);

        // Find the TextView with ID overview_text and set the text
        TextView overviewText = rootView.findViewById(R.id.overview_text);
        overviewText.setText(getString(R.string.overview_text));

        // Find the ImageVIew with ID overview_image2 and set the image resource
        ImageView nigeriaImageSecond = rootView.findViewById(R.id.overview_image2);
        nigeriaImageSecond.setImageResource(R.drawable.river);

        // Find the ImageView with ID overview_image3 and set the image resource
        ImageView nigeriaImageThree = rootView.findViewById(R.id.overview_image3);
        nigeriaImageThree.setImageResource(R.drawable.mosque);

        // FInd the ImageVIew with ID overview_image4 and set the image resource
        ImageView nigeriaImageFour = rootView.findViewById(R.id.overview_image4);
        nigeriaImageFour.setImageResource(R.drawable.lagos);

        return rootView;
    }
}
