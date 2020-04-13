package com.project.x_factories.data.user;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Client {
    public String clientname;
    public String clientfirstname;
    public String clientadresse;
    public String clienttel;


    public Client() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Client(String clientname, String clientfirstname, String clientadresse, String clienttel) {
        this.clientname = clientname;
        this.clientfirstname = clientfirstname;
        this.clientadresse = clientadresse;
        this.clienttel = clienttel;
    }
}
