package com.project.x_factories.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.project.x_factories.R;
import com.project.x_factories.data.user.Entreprise;
import com.project.x_factories.data.user.Client;

import java.util.HashMap;
import java.util.Map;


public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth;
    private HomeViewModel homeViewModel;
    private DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Récupère le uId de la personne connecté
        mAuth = FirebaseAuth.getInstance();

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Permet de récuperer le composant qui se trouve dans le layout (ici les id des
        // TextInputEditText) et pouvoir les manipuler
        final TextInputEditText Adresse = (TextInputEditText) root.findViewById(R.id.Adresse);
        homeViewModel.getAdresse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Adresse.setText(s);
            }
        });

        final TextInputEditText Name = (TextInputEditText) root.findViewById(R.id.Name);
        homeViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Name.setText(s);
            }
        });

        final TextInputEditText Siret = (TextInputEditText) root.findViewById(R.id.Siret);
        homeViewModel.getSiret().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Siret.setText(s);
            }
        });

        final TextInputEditText Tel = (TextInputEditText) root.findViewById(R.id.Tel);
        homeViewModel.getTel().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Tel.setText(s);
            }
        });

        // Bouton de Submit du formulaire
        Button boutton = root.findViewById(R.id.button);
        boutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    writeNewEntreprise(mAuth.getUid(),"adresse", "name", "siret", "tel");
                    Entreprise entreprise = new Entreprise(
                            Adresse.getText().toString(),
                            Name.getText().toString(),
                            Siret.getText().toString(),
                            Tel.getText().toString());
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put(mAuth.getCurrentUser().getUid()+"Entrprise", entreprise);
                    mDatabase.updateChildren(childUpdates);
                    Log.d("infos"," "+Adresse.getText().toString()+ entreprise.getAdresse());
                    Log.d("infos"," "+Name.getText().toString()+ entreprise.getName());
                    Log.d("infos"," "+Siret.getText().toString()+ entreprise.getSiret());
                    Log.d("infos"," "+Tel.getText().toString()+ entreprise.getTel());
                }
        });

        // Permet de créer les informations nécéssaires à mettre dans la base de données
        writeNewClient(mAuth.getUid(),"clientname", "clientfirstname", "clientadresse","clienttel");
        writeNewEntreprise(mAuth.getUid(),"adresse", "name", "siret", "tel");
        return root;
    }
    // Permet d'inclure un client dans la base de donnée
    private void writeNewClient(String userId, String clientname, String clientfirstname, String clientadresse, String clienttel) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Client client = new Client(clientname, clientfirstname, clientadresse, clienttel);
        mDatabase.child(userId).child("Clients").setValue(client);
    }
    // Permet d'inclure une entreprise dans la base de donnée
    private void writeNewEntreprise(String userId,  String adresse, String name, String siret, String tel) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Entreprise entreprise = new Entreprise(adresse, name, siret, tel);
        mDatabase.child(userId).child("Entreprise").setValue(entreprise);
    }
}