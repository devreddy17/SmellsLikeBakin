package quiz.app.com.abhi.android.smellslikebakin;

import android.util.Log;

/**
 * Created by ABHI on 2/6/2017.
 */

public class ListAdapter extends RecyclerAdapter {


    private final FragmentList.InterfaceRecipeSelected mlistener;

    public ListAdapter(FragmentList.InterfaceRecipeSelected listener) {
        mlistener = listener;
    }


    @Override
    protected int getLayoutID() {
        return R.layout.list_item;
    }

    @Override
    protected void recipeSelected(int index) {
        Log.v("Log message","entered onclick method");
        mlistener.recipeSelected(index);
    }


}
