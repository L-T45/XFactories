package com.project.x_factories.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.x_factories.data.user.Entreprise;


public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private MutableLiveData<String> Adresse;
    private MutableLiveData<String> Name;
    private MutableLiveData<String> Siret;
    private MutableLiveData<String> Tel;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Informations de votre entreprise");
        Adresse = new MutableLiveData<>();
        Name = new MutableLiveData<>();
        Siret = new MutableLiveData<>();
        Tel = new MutableLiveData<>();
        mAuth = FirebaseAuth.getInstance();
        // Indique les données que l'on souhaite prendre en fonction de l'utilisateur connecté
        mDatabase = FirebaseDatabase.getInstance().getReference(mAuth.getCurrentUser().getUid());
        mDatabase.addValueEventListener(new ValueEventListener() {
            // Permet de récupérer les informations de la "table" de la base de donnée souhaité
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Entreprise entreprise = dataSnapshot.child("Entreprise").getValue(Entreprise.class);
                Adresse.setValue(entreprise.getAdresse());
                Name.setValue(entreprise.getName());
                Siret.setValue(entreprise.getSiret());
                Tel.setValue(entreprise.getTel());

                /*Log.d("infos"," "+entreprise.getAdresse());
                Log.d("infos"," "+entreprise.getName());
                Log.d("infos"," "+entreprise.getSiret());
                Log.d("infos"," "+entreprise.getTel());*/
            }

            // Si rien n'est trouver alors tu affiche ceci
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("infos"," error ");
            }
        });
    }

    // Permet de retourner les informations de la base de donnée que les inputs doivent renvoyer
    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getAdresse() {
        return Adresse;
    }

    public LiveData<String> getName() {
        return Name;
    }

    public LiveData<String> getSiret() {
        return Siret;
    }

    public LiveData<String> getTel() {
        return Tel;
    }
}