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

public class RestaurantFragment extends Fragment {
    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Attraction> restaurantPlaces = new ArrayList<>( );
        restaurantPlaces.add(new Attraction(getString(R.string.blucubana_title)
                , getString(R.string.blucubana_address)
                , getResources( ).getString(R.string.blucubana)
                , R.drawable.blucubana
                , "9.0811, -7.4365"
                , 4.5
                , "+234 810 090 0000"
                , R.drawable.blucubana_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.bungalow_title)
                , getString(R.string.bungalow_address)
                , getResources( ).getString(R.string.bungalow_restaurant)
                , R.drawable.bungalow_resturant
                , "6.5729, -3.3589"
                , 3.8
                , "+234 700 2864 2569"
                , R.drawable.bungalow_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.eko_sky_title)
                , getString(R.string.eko_sky_address)
                , getResources( ).getString(R.string.eko_sky_restaurant)
                , R.drawable.eko_sky_resturant
                , "6.4268, -3.4300"
                , 4.5
                , "+234 815 869 2263"
                , R.drawable.eko_sky_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.kokodome_title)
                , getString(R.string.kokodome_address)
                , getResources( ).getString(R.string.kokodome)
                , R.drawable.kokodome
                , "7.3879, -3.8788"
                , 4.8
                , "+234 818 181 9999"
                , R.drawable.kokodome_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.chrysalis_title)
                , getString(R.string.chrysalis_address)
                , getResources( ).getString(R.string.cafe_chrysalis)
                , R.drawable.cafe_chrysalis
                , "7.3879, -3.8788"
                , 4.0
                , "+234 809 990 3274"
                , R.drawable.cafe_chrysalis_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.maetisse_title)
                , getString(R.string.metisse_address)
                , getResources( ).getString(R.string.metisse)
                , R.drawable.metisse
                , "6.4331, -3.4382"
                , 4.1
                , "(416) 462-0333"
                , R.drawable.metisse_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.yellow_chilli_title)
                , getString(R.string.yellow_chilli_address)
                , getResources( ).getString(R.string.yellow_chilli)
                , R.drawable.yellow_chilli
                , "6.4250, -3.4153"
                , 4.5
                , "+234 809 962 3614"
                , R.drawable.yellow_chilli_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.villa_medici_title)
                , getString(R.string.villa_medici_address)
                , getResources( ).getString(R.string.villa_medici)
                , R.drawable.villa_medici
                , "6.4357, -3.4310"
                , 3.7
                , "+234 7098 003133"
                , R.drawable.villa_medici_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.cilantro_title)
                , getString(R.string.cilantro_address)
                , getResources( ).getString(R.string.cilantro)
                , R.drawable.cilantro
                , "11.9967, -8.5617"
                , 3.9
                , "+234 812 219 9999"
                , R.drawable.cilantro_entrance));
        restaurantPlaces.add(new Attraction(getString(R.string.tinapa_title)
                , getString(R.string.tinapa_address)
                , getResources( ).getString(R.string.tinapa)
                , R.drawable.tinapa
                , "5.0500, -8.3174"
                , 4.1
                , "+234 801 123 4567"
                , R.drawable.tinapa_entrance));

        AttractionAdapter adapter = new AttractionAdapter(getActivity( ), restaurantPlaces);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity( ), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = restaurantPlaces.get(position);

                /* Create a new Bundle to send data to {@link AttractionDetailActivity} */
                Bundle bundle = new Bundle( );
                bundle.putString(Keys.ATTRACTION_NAME_KEY, attraction.getAttractionName( ));
                bundle.putString(Keys.ATTRACTION_ADDRESS_KEY, attraction.getAttractionAddress( ));
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId( ));
                bundle.putString(Keys.ATTRACTION_LOCATION_KEY, attraction.getLocationId( ));
                bundle.putString(Keys.ATTRACTION_DETAIL_KEY, attraction.getAttractionDescription( ));
                bundle.putDouble(Keys.ATTRACTION_RATING_KEY, attraction.getAttractionRating( ));
                bundle.putString(Keys.ATTRACTION_PHONE_NUMBER_KEY, attraction.getAttractionPhoneNumber( ));

                /*
                  When identifier is,
                  1    ->  ArchitectureFragment
                  2    ->  MusicAndNightlifeFragment
                  3    ->  RestaurantFragment
                  4    ->  ShoppingFragment
                  That means intent send from specific fragment and it helps in providing title
                  for {@link AttractionDetailActivity}
                 */
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 3);
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}
