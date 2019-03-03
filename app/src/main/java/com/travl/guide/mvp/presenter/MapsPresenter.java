package com.travl.guide.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.travl.guide.mvp.model.MapsModel;
import com.travl.guide.mvp.view.MapsView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import ru.terrakok.cicerone.Router;

//Created by Pereved on 24.02.2019.
@InjectViewState
public class MapsPresenter extends MvpPresenter<MapsView> {

    @Inject
    Router router;
    private MapsModel model;
    private Scheduler scheduler;
    public MapsPresenter mapPresenter;

    public MapsPresenter(Scheduler scheduler) {
        this.scheduler = scheduler;
        if(model == null) this.model = new MapsModel();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void setupMapView() {
        getViewState().setupMapBox();
    }
    public void setupFabView() {
        getViewState().setupMultiFab();
    }
    public void requestPermissions() {
        getViewState().requestPermissions();
    }
    public void enableLocationComponent() {
        getViewState().findUser();
    }
}