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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Attraction> shoppingPlaces = new ArrayList<>( );
        shoppingPlaces.add(new Attraction(getString(R.string.icm_title)
                , getString(R.string.icm_address)
                , getResources( ).getString(R.string.icm)
                , R.drawable.icm
                , "6.6141, -3.3582"
                , 4.5
                , R.drawable.icm_entrance));
        shoppingPlaces.add(new Attraction(getString(R.string.maryland_title)
                , getString(R.string.maryland_address)
                , getResources( ).getString(R.string.maryland)
                , R.drawable.maryland
                , "6.5673, -3.3673"
                , 4.1
                , R.drawable.maryland_entrance));
        shoppingPlaces.add(new Attraction(getString(R.string.jabi_title)
                , getString(R.string.jabi_address)
                , getResources( ).getString(R.string.jabi)
                , R.drawable.jabi_lake
                , "9.0764, -7.4254"
                , 4.2
                , R.drawable.jabi_lake_entrance));
        shoppingPlaces.add(new Attraction(getString(R.string.ado_bayero_title)
                , getString(R.string.ado_bayero_address)
                , getResources( ).getString(R.string.ado)
                , R.drawable.ado_bayero
                , "11.9774, -8.5371"
                , 4.2
                , R.drawable.ado_bayero_entrance));
        shoppingPlaces.add(new Attraction(getString(R.string.sky_title)
                , getString(R.string.sky_address)
                , getResources( ).getString(R.string.sky)
                , R.drawable.sky_mall
                , "6.4753, -3.6189"
                , 4.5
                , R.drawable.sky_mall_entrance));
        shoppingPlaces.add(new Attraction(getString(R.string.dunes_title)
                , getString(R.string.dunes_address)
                , getResources( ).getString(R.string.dunes)
                , R.drawable.dunes
                , "9.0838, -7.4850"
                , 4.8
                , R.drawable.dunes_entrance));
        shoppingPlaces.add(new Attraction(getString(R.string.lennox_title)
                , getString(R.string.lennox_address)
                , getResources( ).getString(R.string.lennox)
                , R.drawable.the_lennox
                , "6.4391, -3.4555"
                , 3.8
                , R.drawable.the_lennox_ebtrance));
        shoppingPlaces.add(new Attraction(getString(R.string.mega_plaza_title)
                , getString(R.string.mega_plaza_address)
                , getResources( ).getString(R.string.mega_plaza)
                , R.drawable.mega_plaza
                , "6.4333, -3.4205"
                , 4.1
                , R.drawable.mega_plaza_entrance));

        AttractionAdapter adapter = new AttractionAdapter(getActivity( ), shoppingPlaces);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity( ), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = shoppingPlaces.get(position);

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
                  2    ->  MusicAndNightlifeFragment
                  3    ->  RestaurantFragment
                  4    ->  ShoppingFragment
                  That means intent send from specific fragment and it helps in providing title
                  for {@link AttractionDetailActivity}
                 */
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 4);
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}

