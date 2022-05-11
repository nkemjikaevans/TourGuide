package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * Adapter to display list item for each category i.e Architecture, Shopping
 * Nightlife, Restaurant etc.
 * Created by Evans on 01/06/2020.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    AttractionAdapter(Context context, ArrayList<Attraction> attraction) {
        super(context, 0, attraction);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext( )).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Attraction object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the ImageView in list_item.xml by Id for displaying attraction thumbnail
        ImageView attractionImage = listItemView.findViewById(R.id.list_item_image);
        assert currentAttraction != null;
        attractionImage.setImageResource(currentAttraction.getThubmnailResourceId( ));

        // Find the TextView in list_item.xml by Id for displaying attraction name
        TextView attractionName = listItemView.findViewById(R.id.list_item_attraction_name);
        // Get the name from attractionName object
        // Set the attraction name on TextView
        attractionName.setText(currentAttraction.getAttractionName( ));

        // Find the TextView in list_item.xml by id for displaying attraction address or phone number
        TextView attractionAddress = listItemView.findViewById(R.id.list_item_attraction_detail);
        // If current Attraction object has a phone number then, display phone number and change
        // the text color to color accent
        if (currentAttraction.hasPhoneNumber( )) {
            attractionAddress.setText(currentAttraction.getAttractionPhoneNumber( ));
            attractionAddress.setTextColor(ContextCompat.getColor(getContext( ), R.color.colorAccent));
        } else {
            // If current Attraction object has not a phone number then, display address and change
            // the text color to secondary color
            attractionAddress.setText(currentAttraction.getAttractionAddress( ));
            attractionAddress.setTextColor(ContextCompat.getColor(getContext( ), R.color.secondaryTextColor));
        }

        return listItemView;
    }
}
