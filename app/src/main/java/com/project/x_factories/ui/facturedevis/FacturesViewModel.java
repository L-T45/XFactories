package com.project.x_factories.ui.facturedevis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FacturesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FacturesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Création d'une Facture ou d'un Devis");
    }

    public LiveData<String> getText() {
        return mText;
    }
}