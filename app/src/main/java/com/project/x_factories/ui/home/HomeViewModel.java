package com.project.x_factories.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("\nBonjour et bienvenu sur l'application XFactories, " +
                "votre application de Facture et Devis. " +
                "\n\n\n Pour commencer, cliquez sur les 3 traits en haut à gauche " +
                "pour acceder au menu.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}