package quiz.app.com.abhi.android.smellslikebakin;

/**
 * Created by ABHI on 2/10/2017.
 */

public class Ingredients extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
