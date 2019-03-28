package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.wikiedufoundation.wikiedudashboard.R;
import org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.data.Article;
import org.wikiedufoundation.wikiedudashboard.helper.ProviderUtils;
import org.wikiedufoundation.wikiedudashboard.helper.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesEditedRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    TextView bottomsheet_tv_title;
    String url;
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Article> edited = new ArrayList<>();

    /**
     * A Constructor of Context.
     *
     * @param context an instance of Context.
     */
    public ArticlesEditedRecyclerAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * Returns an instance of ViewHolder class.
     * Creates a View Holder to contain each item of the Recycler view.
     *
     * @param viewGroup an instance of the View Group.
     * @param i position of each ViewHolder.
     * @return an instance of ViewHolder class.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view1 = layoutInflater.inflate(R.layout.item_rv_articles_edited,viewGroup,false);
        return new ArticlesEditedViewHolder(view1);
    }

    /**
     * Return type is Void.
     * Binds data to each View Holder.
     *
     * @param viewHolder view holder corresponding to each view
     *                   which it gets from onCreateViewHolder method.
     * @param i position of each ViewHolder.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final ArticlesEditedViewHolder articlesEditedViewHolder = (ArticlesEditedViewHolder) viewHolder;
        articlesEditedViewHolder.tv_count_articles_edited_title.setText(edited.get(i).getTitle());
        articlesEditedViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /**
             * Return type is Void.
             * Setting an onClickListener on each item of recycler view to open bottom sheet.
             *
             * @param v an instance of the View class.
             */
            @Override
            public void onClick(View v) {
                View view = layoutInflater.inflate(R.layout.fragment_bottom_sheet_dialog, null);
                TextView bottomsheet_tv_charsaddednum = view.findViewById(R.id.bottomsheet_tv_charsaddednum);
                TextView bottomsheet_tv_viewsnum =  view.findViewById(R.id.bottomsheet_tv_viewsnum);
                bottomsheet_tv_title = view.findViewById(R.id.bottomsheet_tv_title);
                bottomsheet_tv_charsaddednum.setText(edited.get(i).getCharacter_sum());
                bottomsheet_tv_viewsnum.setText(edited.get(i).getView_count());
                bottomsheet_tv_title.setText(edited.get(i).getTitle());
                url = edited.get(i).getUrl();
                bottomsheet_tv_title.setOnClickListener(new View.OnClickListener() {
                    /**
                     * Return type is Void.
                     * Setting an onClickListener on textview bottomsheet_tv_title.
                     * @param v an instance of the View class.
                     */
                    @Override
                    public void onClick(View v) {
                        ViewUtils.showCustomChromeTabs(context,url);
                    }
                });
                BottomSheetDialog dialog = new BottomSheetDialog(context);
                dialog.setContentView(view);
                dialog.show();
            }
        });

    }

    /**
     * Return type is Void.
     * a context for the Edited class.
     *
     * @param edited an instance of Edited class which returns a List of Article class.
     */
    void setData(List<Article> edited) {
        this.edited = edited;
    }

    /**
     * Return type is int.
     * returns the number of items in the recycler view.
     *
     * @return integer which counts the total items in the recycler view.
     */
    @Override
    public int getItemCount() {
        return edited.size();
    }

    /**
     * Binds id to the variable tv_count_articles_edited_title
     */
    public class ArticlesEditedViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_count_articles_edited_title)
        TextView tv_count_articles_edited_title;

        public ArticlesEditedViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
