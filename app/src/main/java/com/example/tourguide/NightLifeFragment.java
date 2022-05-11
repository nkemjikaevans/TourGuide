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

public class NightLifeFragment extends Fragment {
    public NightLifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Attraction> nightlifePlaces = new ArrayList<>( );
        nightlifePlaces.add(new Attraction(getString(R.string.fifty_seven_title)
                , getString(R.string.fifty_seven_Address)
                , getResources( ).getString(R.string.club_57)
                , R.drawable.fifty_seven
                , "6.4421, -3.4172"
                , 4.5
                , R.drawable.fifty_seven_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.quilox_title)
                , getString(R.string.quilox_address)
                , getResources( ).getString(R.string.quilox)
                , R.drawable.quilox
                , "6.4380, -3.4381"
                , 4.9
                , R.drawable.quilox_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.escape_title)
                , getString(R.string.escape_address)
                , getResources( ).getString(R.string.escape)
                , R.drawable.escape
                , "6.4310, -3.4178"
                , 4.2
                , R.drawable.escape_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.cubana_title)
                , getString(R.string.cubana_address)
                , getResources( ).getString(R.string.cubana)
                , R.drawable.cubana
                , "6.430947005, -3.41400554499"
                , 4.1
                , R.drawable.cubana_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.rumors_title)
                , getString(R.string.rumors_address)
                , getResources( ).getString(R.string.rumors)
                , R.drawable.rumors
                , "6.4297, -3.4236"
                , 4.5
                , R.drawable.rumors_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.nitro_title)
                , getString(R.string.nitro_address)
                , getResources( ).getString(R.string.nitro)
                , R.drawable.nitro
                , "6.4347, -3.4293"
                , 4.7
                , R.drawable.nitro_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.virus_title)
                , getString(R.string.virus_address)
                , getResources( ).getString(R.string.virus)
                , R.drawable.virus
                , "6.4371123, -3.4608096"
                , 3.5
                , R.drawable.virus_entrance));
        nightlifePlaces.add(new Attraction(getString(R.string.vapours_title)
                , getString(R.string.vapours_address)
                , getResources( ).getString(R.string.vapours)
                , R.drawable.vapours
                , "6.4358369, -3.4354909"
                , 3.9
                , R.drawable.vapors_entrance));

        AttractionAdapter adapter = new AttractionAdapter(getActivity( ), nightlifePlaces);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity( ), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = nightlifePlaces.get(position);

                /* Create a new Bundle to send data to {@link AttractionDetailActivity} */
                Bundle bundle = new Bundle( );
                bundle.putString(Keys.ATTRACTION_NAME_KEY, attraction.getAttractionName( ));
                bundle.putString(Keys.ATTRACTION_ADDRESS_KEY, attraction.getAttractionAddress( ));
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId( ));
                bundle.putString(Keys.ATTRACTION_LOCATION_KEY, attraction.getLocationId( ));
                bundle.putString(Keys.ATTRACTION_DETAIL_KEY, attraction.getAttractionDescription( ));
                bundle.putDouble(Keys.ATTRACTION_RATING_KEY, attraction.getAttractionRating( ));
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 2);

                /*
                  When identifier is,
                  1    ->  ArchitectureFragment
                  2    ->  NightlifeFragment
                  3    ->  RestaurantFragment
                  4    ->  ShoppingFragment
                  That means intent send from specific fragment and it helps in providing title
                  for {@link AttractionDetailActivity}
                 */
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}
