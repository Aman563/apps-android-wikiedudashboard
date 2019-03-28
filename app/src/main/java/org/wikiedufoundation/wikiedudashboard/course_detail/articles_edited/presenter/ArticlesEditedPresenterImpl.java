package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.presenter;

import android.util.Log;

import org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.data.ArticlesEdited;
import org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.provider.ArticlesEditedProvider;
import org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.view.ArticlesEditedView;
import org.wikiedufoundation.wikiedudashboard.helper.PresenterCallback;

public class ArticlesEditedPresenterImpl implements ArticlesEditedPresenter {
    private ArticlesEditedProvider articlesEditedProvider;
    private ArticlesEditedView articlesEditedView;

    /**
     * Constructor for getting the context of ArticlesEditedProvider and ArticlesEditedView class.
     *
     * @param articlesEditedProvider an instance of ArticlesEditedProvider class
     * @param articlesEditedView an instance of ArticlesEditedView class.
     */
    public ArticlesEditedPresenterImpl(ArticlesEditedProvider articlesEditedProvider, ArticlesEditedView articlesEditedView) {
        this.articlesEditedProvider = articlesEditedProvider;
        this.articlesEditedView = articlesEditedView;
    }

    /**
     * Used to control the progress bar of the layout
     * and to call the PresenterCallbAck method to retrieve data.
     *
     * @param url an absolute URL giving the base location of the edited articles
     */
    @Override
    public void requestArticlesEdited(String url) {
        articlesEditedView.showProgressBar(true);
        articlesEditedProvider.requestArticlesEdited(url, new PresenterCallback() {
            /**
             * Return type is Void.
             * Deal with the case of successful retrieving of data.
             * Progress bar is set to false and retrieved data is set.
             *
             * @param o an instance of the object class.
             */
            @Override
            public void onSuccess(Object o) {
                articlesEditedView.showProgressBar(false);
                ArticlesEdited articlesEditedResponse =
                        (ArticlesEdited) o;
                Log.d("Presenter: ", articlesEditedResponse.toString());
                articlesEditedView.setData(articlesEditedResponse);
            }

            /**
             * Return type is Void.
             * Deal with the case of unsuccessful retrieving of data.
             * Progress bar is set to false
             * and message "unable to connect to server." is displayed.
             */
            @Override
            public void onFailure() {
               articlesEditedView.showProgressBar(false);
               articlesEditedView.showMessage("unable to connect to server.");
            }
        });
    }
}
