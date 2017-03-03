package quiz.app.com.abhi.android.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by ABHI on 2/9/2017.
 */

public abstract class CheckBoxesFragment extends Fragment {
    private static final String SAVED_KEY_STATE = "savedKeyState";
    CheckBox[] mcheckbox;
    boolean[] savedKeyState;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkboxes,container,false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.fragment_checkboxes);

int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        String[] contents = getContents(index);
        mcheckbox = new CheckBox[contents.length];
        savedKeyState = new boolean[contents.length];

if(savedInstanceState != null && savedInstanceState.getBooleanArray(SAVED_KEY_STATE)!=null ){
    savedKeyState = savedInstanceState.getBooleanArray(SAVED_KEY_STATE);
    Log.v("instancestate","true");
}
        Log.v("before","setcheckupbox");
        setCheckBox(contents,layout,mcheckbox,savedKeyState);



return view;
    }

    public abstract String[] getContents(int index);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] savedstate = new boolean[mcheckbox.length];
        int i=0;

        for (CheckBox checkBox : mcheckbox){
            Log.v("ischecked",checkBox.isChecked()+"");
          savedstate[i]=checkBox.isChecked();
            i++;
        }

        outState.putBooleanArray(SAVED_KEY_STATE,savedstate);
        super.onSaveInstanceState(outState);
        Log.v("ischecked","exiting");
    }

    public void setCheckBox(String[] contents, ViewGroup container, CheckBox[] mcheckbox, boolean[] KeyState){
        Log.v("entering","setcheckupbox");
        int i=0;

        for(String content : contents) {
            mcheckbox[i]= new CheckBox(getActivity());
            mcheckbox[i].setPadding(8, 16, 8, 16);
            mcheckbox[i].setTextSize(16f);
            mcheckbox[i].setText(content);
            container.addView( mcheckbox[i]);
            if(KeyState[i]){
                mcheckbox[i].toggle();
            }

            i++;
        }

    }


}
