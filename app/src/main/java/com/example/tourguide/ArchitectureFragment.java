package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchitectureFragment extends Fragment {

    public ArchitectureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Attraction> architecturePlaces = new ArrayList<>( );
        architecturePlaces.add(new Attraction(getString(R.string.cbn_title)
                , getString(R.string.cbn_headquarters_address)
                , getResources( ).getString(R.string.cbn_headquarters)
                , R.drawable.cbn_building
                , "9.0667,-7.4833"
                , 3.5
                , R.drawable.cbn_building));
        architecturePlaces.add(new Attraction(getString(R.string.city_hall_title)
                , getString(R.string.lagos_hall_address)
                , getResources( ).getString(R.string.lagos_city_hall)
                , R.drawable.lagos_city_hall
                , "6.4506,-3.3976"
                , 4.2
                , R.drawable.lagos_city_hall));
        architecturePlaces.add(new Attraction(getString(R.string.stadium_title)
                , getString(R.string.stadium_address)
                , getResources( ).getString(R.string.Akwa_Ibom_stadium)
                , R.drawable.akwa_ibom_stadium
                , "5.0083, -7.8871"
                , 4.5
                , R.drawable.akwa_ibom_stadium));
        architecturePlaces.add(new Attraction(getString(R.string.national_theater)
                , getString(R.string.national_theater_address)
                , getResources( ).getString(R.string.National_Theatre)
                , R.drawable.theatre
                , "6.4412, -3.418"
                , 4.1
                , R.drawable.theatre));
        architecturePlaces.add(new Attraction(getString(R.string.defence_title)
                , getString(R.string.defence_address)
                , getResources( ).getString(R.string.ministry_of_defence)
                , R.drawable.defence_abuja
                , "9.0648, -7.3675"
                , 3.5
                , R.drawable.defence_ministry));
        architecturePlaces.add(new Attraction(getString(R.string.civic_center_title)
                , getString(R.string.civic_center_address)
                , getResources( ).getString(R.string.civic_center)
                , R.drawable.civic_centre_lagos
                , "6.4311, -3.4158"
                , 3.5
                , R.drawable.civic_centre_lagos));
        architecturePlaces.add(new Attraction(getString(R.string.four_points_title)
                , getString(R.string.four_point_address)
                , getResources( ).getString(R.string.four_point)
                , R.drawable.four_points_by_sheraton_lagos
                , "6.4311, -3.4158"
                , 4.5
                , R.drawable.four_points_by_sheraton_lagos));
        architecturePlaces.add(new Attraction(getString(R.string.nnpc_title)
                , getString(R.string.nnpc_address)
                , getResources( ).getString(R.string.nnpc_towers)
                , R.drawable.nnpc
                , "9.0542, -7.4851"
                , 3.6
                , R.drawable.nnpc));
        architecturePlaces.add(new Attraction(getString(R.string.cbn_lagos_title)
                , getString(R.string.cbn_lagos_address)
                , getResources( ).getString(R.string.central_bank_lagos)
                , R.drawable.central_bank_of_nigeria
                , "10.2924, -11.1394"
                , 3.9
                , R.drawable.central_bank_of_nigeria));

        AttractionAdapter adapter = new AttractionAdapter(getActivity( ), architecturePlaces);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity( ), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = architecturePlaces.get(position);

                /* Create a new Bundle to send data to {@link AttractionDetailActivity} */
                Bundle bundle = new Bundle( );
                bundle.putString(Keys.ATTRACTION_NAME_KEY, attraction.getAttractionName( ));
                bundle.putString(Keys.ATTRACTION_ADDRESS_KEY, attraction.getAttractionAddress( ));
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId( ));
                bundle.putString(Keys.ATTRACTION_LOCATION_KEY, attraction.getLocationId( ));
                bundle.putString(Keys.ATTRACTION_DETAIL_KEY, attraction.getAttractionDescription( ));
                bundle.putDouble(Keys.ATTRACTION_RATING_KEY, attraction.getAttractionRating( ));

                /*
                  When identifier is,
                  1    ->  ArchitectureFragment
                  2    ->  NightlifeFragment
                  3    ->  RestaurantFragment
                  4    ->  ShoppingFragment
                  That means intent send from specific fragment and it helps in providing title
                  for {@link AttractionDetailActivity}
                 */
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 1);
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}
