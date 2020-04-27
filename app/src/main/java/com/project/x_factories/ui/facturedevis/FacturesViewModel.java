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


        /*
        // This code uses the Sheets Advanced Service, but for most use cases
        // the built-in method SpreadsheetApp.getActiveSpreadsheet()
        //     .getRange(range).getValues(values) is more appropriate.
        ranges = [
        // Range names ...
            ];
        result = Sheets.Spreadsheets.Values.batchGet(spreadsheetId, {ranges:ranges});
        // This code uses the Sheets Advanced Service, but for most use cases
        // the built-in method SpreadsheetApp.getActiveSpreadsheet()
        //     .getRange(range).setValues(values) is more appropriate.
        valeurs = [
            [
        // Cell values ...
            ]
        // Additional rows ...
        ];
        valueRange = Sheets.newValueRange();
        valueRange.range = range;
        valueRange.values = valeurs;

        batchUpdateRequest = Sheets.newBatchUpdateValuesRequest();
        batchUpdateRequest.data = valueRange;
        batchUpdateRequest.valueInputOption = valueInputOption;

        result = Sheets.Spreadsheets.Values.batchUpdate(batchUpdateRequest, spreadsheetId);*/
    }
    public LiveData<String> getText() {
        return mText;
    }
}