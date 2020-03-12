package com.project.x_factories.ui.logout;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;


public class LogoutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LogoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Déconnexion réussie, vous pouvez quitter l'application !");
        // Ajout d'un sign Out pour se déconnecter de l'application
        // après et seulement après avoir cliqué sur le bouton déconnexion
        FirebaseAuth.getInstance().signOut();

    }
    public LiveData<String> getText() {
        return mText;
    }
}