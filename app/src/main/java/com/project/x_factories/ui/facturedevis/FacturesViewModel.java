package com.project.x_factories.ui.facturedevis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.api.services.sheets.v4.Sheets;

public class FacturesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FacturesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Création d'une Facture ou d'un Devis" +
        "\n Il est recommandé d'avoir l'application Google Sheets sur votre appareil avant de " +
                "cliquer sur le lien ci-dessous.");
        // Ajout d'un lien cliquable dans fragment_factures.xml
        
    }
    public LiveData<String> getText() {
        return mText;
    }
}