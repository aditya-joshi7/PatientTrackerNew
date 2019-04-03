package com.example.patientmangement;

public class visit_details {
    public String doctor_name;
    public String date;
    public String symptoms;
    public String medicines;

    public visit_details(String doctor_name, String date, String symptoms, String medicines)
    {
        this.doctor_name=doctor_name;
        this.date=date;
        this.symptoms=symptoms;
        this.medicines=medicines;
    }
}
