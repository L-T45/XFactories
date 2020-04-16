package com.project.x_factories.data.user;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Entreprise {

        private String name;
        private String adresse;
        private String siret;
        private String tel;

        public Entreprise() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public Entreprise( String adresse, String name, String siret, String tel) {
            this.adresse = adresse;
            this.name = name;
            this.siret = siret;
            this.tel = tel;
        }

        // Permet de récuperer les valeurs dans Firebase
        public String getName(){
           return this.name;
        }

        public String getAdresse(){
             return this.adresse;
        }

        public String getSiret(){
            return this.siret;
        }

        public String getTel(){
            return this.tel;
        }

}
