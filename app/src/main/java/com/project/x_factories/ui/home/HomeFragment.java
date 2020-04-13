package com.project.x_factories.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.x_factories.R;
import com.project.x_factories.data.user.Entreprise;
import com.project.x_factories.data.user.Client;

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
        // Permet de créer un name et un email
        writeNewClient(mAuth.getUid(),"clientname", "clientfirstname", "clientadresse","clienttel");
        writeNewEntreprise(mAuth.getUid(),"name", "adresse", "siret", "tel");
        return root;
    }
    // Permet d'inclure un client dans la base de donnée
    private void writeNewClient(String userId, String clientname, String clientfirstname, String clientadresse, String clienttel) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Client client = new Client(clientname, clientfirstname, clientadresse, clienttel);
        mDatabase.child(userId).child("Clients").setValue(client);
    }
    // Permet d'inclure une entreprise dans la base de donnée
    private void writeNewEntreprise(String userId, String name, String adresse, String siret, String tel) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Entreprise entreprise = new Entreprise(name, adresse, siret, tel);
        mDatabase.child(userId).child("Entreprise").setValue(entreprise);
    }
}