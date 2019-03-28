package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.provider;

import org.wikiedufoundation.wikiedudashboard.helper.PresenterCallback;

public interface ArticlesEditedProvider {
    /**
     * Return type of the method is Void.
     * The url argument must specify an absolute link.
     * The presenterCallBack argument is an instance of PresenterCallBack class.
     * This method is implemented by RetrofitArticlesEditedProvider class with some modifications on it
     *
     * @param url an absolute URL giving the base location of the edited articles
     * @param presenterCallback an instance of PresenterCallBack class
     * @return Void
     */
    void requestArticlesEdited(String url, PresenterCallback presenterCallback);
}
