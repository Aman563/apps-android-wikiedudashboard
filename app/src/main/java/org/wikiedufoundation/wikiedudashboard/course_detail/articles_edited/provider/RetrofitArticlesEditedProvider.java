package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.provider;

import android.util.Log;

import org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.data.ArticlesEdited;

import org.wikiedufoundation.wikiedudashboard.helper.PresenterCallback;
import org.wikiedufoundation.wikiedudashboard.helper.ProviderUtils;
import org.wikiedufoundation.wikiedudashboard.helper.WikiEduDashboardApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitArticlesEditedProvider implements ArticlesEditedProvider {
    private WikiEduDashboardApi wikiEduDashboardApi;

    /**
     * A Constructor.
     * Provides GSON converted JSON array
     * with the help of wikiEduDashboardApi.
     */
    public RetrofitArticlesEditedProvider(){wikiEduDashboardApi = ProviderUtils.getApiObject(); }

    /**
     * Implementation of requestArticlesEdited method declared in ArticlesEditedProvider interface.
     * Return type is void.
     * helps in linking BASE-URL with SUB-URL
     * and then providing complete URL to getArticlesEdited method.
     *
     * @param url               an absolute URL giving the base location of the edited articles
     * @param presenterCallback an instance of PresenterCallBack class
     */
    @Override
    public void requestArticlesEdited(String url,final PresenterCallback presenterCallback) {
        String sub_url = "courses/"+url+"/articles.json";
        Call<ArticlesEdited> articlesEditedResponseCall = wikiEduDashboardApi.getArticlesEdited(sub_url);
        articlesEditedResponseCall.enqueue(new Callback<ArticlesEdited>() {
            /**
             * Return type is void.
             * on successful retrieving of data log show "Success" message.
             *
             * @param call an instance of call class of ArticlesEdited.
             * @param response an instance of response class of ArticlesEdited.
             */
            @Override
            public void onResponse(Call<ArticlesEdited> call, Response<ArticlesEdited> response) {
                Log.d("Success: ",response.body().getCourse()+"");
                presenterCallback.onSuccess(response.body());
            }

            /**
             * Return type is void.
             * on unsuccessful retrieving of data log show "Failure" message.
             *
             * @param call an instance of call class of ArticlesEdited.
             * @param t an instance of throwable class.
             */
            @Override
            public void onFailure(Call<ArticlesEdited> call, Throwable t) {
                presenterCallback.onFailure();
                t.printStackTrace();
                Log.d("Failure: ",t.getMessage()+"");
            }
        });
    }
}
