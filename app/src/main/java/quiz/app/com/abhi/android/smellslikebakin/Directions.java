package quiz.app.com.abhi.android.smellslikebakin;

/**
 * Created by ABHI on 2/10/2017.
 */

public class Directions extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
