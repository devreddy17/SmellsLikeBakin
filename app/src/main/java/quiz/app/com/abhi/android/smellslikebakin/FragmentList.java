package quiz.app.com.abhi.android.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ABHI on 2/6/2017.
 */

public class FragmentList extends Fragment {
    
    public interface InterfaceRecipeSelected{
        public void recipeSelected(int index);
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        InterfaceRecipeSelected listener = (InterfaceRecipeSelected) getActivity();
        
        
        View view = inflater.inflate(R.layout.recycler_view,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_recycler_view);

        ListAdapter adapter = new ListAdapter(listener);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);


        return view;
    }
}
