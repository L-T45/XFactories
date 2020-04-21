package com.project.x_factories.data.user;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Entreprise {

        private String adresse;
        private String name;
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
        public String getAdresse(){
            return this.adresse;
        }

        public String getName(){
           return this.name;
        }

        public String getSiret(){
            return this.siret;
        }

        public String getTel(){
            return this.tel;
        }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("adresse", adresse);
        result.put("name", name);
        result.put("siret", siret);
        result.put("tel", tel);

        return result;
    }

}
