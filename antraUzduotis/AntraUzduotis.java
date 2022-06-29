package antraUzduotis;

import java.util.Scanner;

public class AntraUzduotis {
    public static void main(String[] args) {
        Scanner skaitytuvas = new Scanner(System.in);
        System.out.println("iveskite Email");
        String email = skaitytuvas.nextLine();
        //System.out.println(emailPatikrinimas(email));
        System.out.println("iveskite prisijungimo varda");
        String login = skaitytuvas.nextLine();
        System.out.println("iveskite slaptazodi");
        String password = skaitytuvas.nextLine();
        //System.out.println(loginPatikrinimas(login,password));
        //System.out.println(slaptazodzioIlgioPatikrinimas(password));
        //System.out.println(slaptazodzioStiprumoPatikrinimas(password));
        System.out.println("pakartokite slaptazodi");
        String repeatPassword = skaitytuvas.nextLine();
        //System.out.println(arSutampaSlaptazodziai(password,repeatPassword));
        uzRegistravimas(email,login,password,repeatPassword);
    }
    public static void uzRegistravimas(String email, String login, String password,String repeatPassword) {

        boolean emailTikrinti = false;
        boolean loginTrikrinti = false;
        boolean passwordTikrintiIlgis = false;
        boolean passwordTikrintiStiprumas = false;
        boolean passwordSutapimas = false;
        if (emailPatikrinimas(email)) {
            emailTikrinti = true;
        } if (loginPatikrinimas(login, password)) {
            loginTrikrinti = true;
        } if (slaptazodzioIlgioPatikrinimas(password)) {
            passwordTikrintiIlgis = true;
        } if (slaptazodzioStiprumoPatikrinimas(password)) {
            passwordTikrintiStiprumas = true;
        }if (arSutampaSlaptazodziai(password,repeatPassword)){
            passwordSutapimas = true;
        }if (emailTikrinti && loginTrikrinti && passwordTikrintiIlgis && passwordSutapimas && passwordTikrintiStiprumas) {
            System.out.println("registracija pavyko");
        }
    }


    public static boolean emailPatikrinimas(String email){
        boolean teisingas = false;
        String neteisingasEmail = "email trukstas @ arba .";
        if (email.contains("@") && email.contains(".")) {
            return teisingas = true;
        }
        else {
            System.out.println("email truksta @ arba .");
        }
        return teisingas ;
    }
    public static boolean loginPatikrinimas(String login,String passward) {
        boolean teisingas = false;
        if (login.equals(passward)) {
            System.out.println("Slaptazodis sutampa su prisijungimo vardu");
            return teisingas = false;
        }
        return teisingas = true;
    }
    public static boolean arSutampaSlaptazodziai(String password,String repeatPassword){
        boolean teisingas = false;
        if (password.equals(repeatPassword)) {
            System.out.println("ok");
            return teisingas = true;

        }
        System.out.println("nesutampa slaptazodziai");
        return teisingas = false;
    }
    public static boolean slaptazodzioIlgioPatikrinimas(String password){
        boolean teisingas = false;
        if (password.length() < 10) {
            System.out.println("slaptazodis per trumpas! slaptazodis turi tureti bent 10 skaitmenu");
            return teisingas = false;
        }
        return teisingas = true;
    }
    public static boolean slaptazodzioStiprumoPatikrinimas(String password) {
        char raide;
        boolean didziojiRaide = false;
        boolean mazojiRaide = false;
        boolean skaicius = false;
        boolean teisingas = false;
        for (int i = 0; i < password.length(); i++) {
            raide = password.charAt(i);
            if (Character.isDigit(raide)) {
                skaicius = true;
            } else if (Character.isLowerCase(raide)) {
                mazojiRaide = true;
            } else if (Character.isUpperCase(raide)) {
                didziojiRaide = true;
            }
            if (didziojiRaide && mazojiRaide && skaicius) {
                return teisingas = true;
            }
        }
        System.out.println("slaptazodis turi tureti bet viena diziaja raide, bent viena mazaja raide ir bent viena skaiciu");
        return teisingas;
    }
}

