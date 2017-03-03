package quiz.app.com.abhi.android.smellslikebakin;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements FragmentList.InterfaceRecipeSelected, GridFragment.InterfaceRecipeSelected {

    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEW_PAGER_FRAGMENT = "view_pager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        Toast.makeText(this, isTablet + "", Toast.LENGTH_SHORT).show();
        if (!isTablet) {
            FragmentList savedListFragment = (FragmentList) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

            if (savedListFragment == null) {

                FragmentList mfragmentList = new FragmentList();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.PlaceHolder, mfragmentList, LIST_FRAGMENT);

                transaction.commit();
            }
        }else {
                GridFragment savedGridFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

                if (savedGridFragment == null) {

                    GridFragment mfragmentGrid = new GridFragment();

                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();

                    transaction.add(R.id.PlaceHolder, mfragmentGrid, LIST_FRAGMENT);

                    transaction.commit();
                }
            }


    }

    @Override
    public void recipeSelected(int index) {
        Log.v("toast message", Recipes.names[index]);
        Toast.makeText(MainActivity.this, Recipes.names[index], Toast.LENGTH_SHORT).show();

        ViewPagerFragment mfragmentList = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(mfragmentList.KEY_RECIPE_INDEX, index);
        mfragmentList.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.PlaceHolder, mfragmentList, VIEW_PAGER_FRAGMENT);


        transaction.addToBackStack(null);

        transaction.commit();

    }


    @Override
    public void onGridRecipeSelected(int index) {

    }
}
