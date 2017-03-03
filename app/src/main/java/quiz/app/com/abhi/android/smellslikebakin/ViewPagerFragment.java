package quiz.app.com.abhi.android.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ABHI on 2/8/2017.
 */

public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX ="recipe_index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int index;
        View view = inflater.inflate(R.layout.viewpager_fragment,container,false);
        index = getArguments().getInt(KEY_RECIPE_INDEX);
getActivity().setTitle(Recipes.names[index]);

       final Ingredients mingredientsFragment = new Ingredients();
        Bundle bundle  = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        mingredientsFragment.setArguments(bundle);

        final Directions mdirectionsFragment = new Directions();
        bundle  = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        mdirectionsFragment.setArguments(bundle);

ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);


        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? mingredientsFragment : mdirectionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions" ;
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
