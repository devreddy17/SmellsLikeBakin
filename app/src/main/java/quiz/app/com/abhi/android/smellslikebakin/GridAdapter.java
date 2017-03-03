package quiz.app.com.abhi.android.smellslikebakin;

import android.util.Log;

/**
 * Created by ABHI on 2/10/2017.
 */
public class GridAdapter extends RecyclerAdapter {


    private final GridFragment.InterfaceRecipeSelected mlistener;

    public GridAdapter(GridFragment.InterfaceRecipeSelected listener) {
        mlistener = listener;
    }


    @Override
    protected int getLayoutID() {
        return R.layout.grid_item;
    }

    @Override
    protected void recipeSelected(int index) {
        Log.v("Log message","entered onclick method");
        mlistener.onGridRecipeSelected(index);
    }


}