// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.entities;

import java.lang.String;

privileged aspect Intsident_Roo_ToString {
    
    public String Intsident.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Avaja: ").append(getAvaja()).append(", ");
        sb.append("Avatud: ").append(getAvatud() == null ? "null" : getAvatud().getTime()).append(", ");
        sb.append("GPS_latituud: ").append(getGPS_latituud()).append(", ");
        sb.append("GPS_longituud: ").append(getGPS_longituud()).append(", ");
        sb.append("IntsidendiLiik: ").append(getIntsidendiLiik()).append(", ");
        sb.append("Intsident_ID: ").append(getIntsident_ID()).append(", ");
        sb.append("IsikIntsidendis: ").append(getIsikIntsidendis() == null ? "null" : getIsikIntsidendis().size()).append(", ");
        sb.append("Kirjeldus: ").append(getKirjeldus()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Kood: ").append(getKood()).append(", ");
        sb.append("Muudetud: ").append(getMuudetud() == null ? "null" : getMuudetud().getTime()).append(", ");
        sb.append("Muutja: ").append(getMuutja()).append(", ");
        sb.append("Nimetus: ").append(getNimetus()).append(", ");
        sb.append("ObjektsIntsidendis: ").append(getObjektsIntsidendis() == null ? "null" : getObjektsIntsidendis().size()).append(", ");
        sb.append("Piiriloik: ").append(getPiiriloik()).append(", ");
        sb.append("PiirivalvurIntsidendis: ").append(getPiirivalvurIntsidendis() == null ? "null" : getPiirivalvurIntsidendis().size()).append(", ");
        sb.append("Suletud: ").append(getSuletud() == null ? "null" : getSuletud().getTime()).append(", ");
        sb.append("Sulgeja: ").append(getSulgeja()).append(", ");
        sb.append("Toimumise_algus: ").append(getToimumise_algus() == null ? "null" : getToimumise_algus().getTime()).append(", ");
        sb.append("Toimumise_lopp: ").append(getToimumise_lopp() == null ? "null" : getToimumise_lopp().getTime()).append(", ");
        sb.append("VahtkondIntsidendis: ").append(getVahtkondIntsidendis() == null ? "null" : getVahtkondIntsidendis().size()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
