package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.presenter;

public interface ArticlesEditedPresenter {
    /**
     * Return type of the method is Void.
     * The url argument must specify an absolute link.
     * This method is implemented by ArticlesEditedPresenterImpl class.
     *
     * @param url an absolute URL giving the base location of the edited articles
     * @return Void
     */
    void requestArticlesEdited(String url);

}
