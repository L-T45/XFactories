package com.project.x_factories.data.user;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Entreprise {

        public String name;
        public String adresse;
        public String siret;
        public String tel;

        public Entreprise() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public Entreprise(String name, String adresse, String siret, String tel) {
            this.name = name;
            this.adresse = adresse;
            this.siret = siret;
            this.tel = tel;

        }
}
