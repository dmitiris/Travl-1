package com.travl.guide.mvp.model.repo;

import com.travl.guide.mvp.model.api.articles.ArticleLinksContainer;
import com.travl.guide.mvp.model.network.NetService;
import com.travl.guide.ui.utils.NetworkStatus;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ArticlesRepo {
    private NetService netService;

    public ArticlesRepo(NetService netService) {
        this.netService = netService;
    }

    public Single<ArticleLinksContainer> getTravlZineArticles() {
        if (NetworkStatus.isOnline()) {
            return netService.loadArticles(true).subscribeOn(Schedulers.io()).onErrorReturn(throwable -> {
                Timber.e(throwable);
                return null;
            });
        } else {
            return new Single<ArticleLinksContainer>() {
                @Override
                protected void subscribeActual(SingleObserver<? super ArticleLinksContainer> observer) {
                }
            };
        }
    }
}
