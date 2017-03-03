package quiz.app.com.abhi.android.smellslikebakin;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ABHI on 2/6/2017.
 */

public abstract class RecyclerAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutID(),parent,false);
        return new ListViewHolder(view);
    }

    protected abstract int getLayoutID();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ( (ListViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        int index;

        private TextView mtextView ;
        private ImageView mimageView;

        public ListViewHolder(View itemView) {
            super(itemView);
            mtextView = (TextView) itemView.findViewById(R.id.item_text);
            mimageView = (ImageView) itemView.findViewById(R.id.item_Image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
                 recipeSelected(index);
        }

        public void bindView(int position){
           mtextView.setText(Recipes.names[position]);
            mimageView.setImageResource(Recipes.resourceIds[position]);
            index =position;

        }

    }

    protected abstract void recipeSelected(int index);

}
