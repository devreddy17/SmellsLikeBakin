package quiz.app.com.abhi.android.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ABHI on 2/10/2017.
 */

public class GridFragment extends Fragment {
    public interface InterfaceRecipeSelected{
        public void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       InterfaceRecipeSelected listener = (InterfaceRecipeSelected) getActivity();


        View view = inflater.inflate(R.layout.recycler_view,container,false);

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_recycler_view);

        GridAdapter adapter = new GridAdapter(listener);
        recyclerView.setAdapter(adapter);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float dpWidth = displaymetrics.widthPixels/displaymetrics.density;
        int numcol = (int) (dpWidth/200);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(),numcol);
        recyclerView.setLayoutManager(manager);

        return view;
    }

}
