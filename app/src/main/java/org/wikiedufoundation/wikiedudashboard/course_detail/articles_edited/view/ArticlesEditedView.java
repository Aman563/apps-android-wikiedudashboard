package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.view;

import org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.data.ArticlesEdited;

import org.wikiedufoundation.wikiedudashboard.helper.Progressive;
import org.wikiedufoundation.wikiedudashboard.helper.Toaster;

public interface ArticlesEditedView extends Progressive, Toaster {
    /**
     * Return type is void.
     * This method is implemented by CourseArticlesEditedFragment class.
     * Used for setting provided data.
     *
     * @param data an instance of ArticlesEdited class.
     */
    void setData(ArticlesEdited data);
}
