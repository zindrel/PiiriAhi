// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.entities;

import java.lang.String;

privileged aspect Piiririkkuja_Roo_ToString {
    
    public String Piiririkkuja.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Eesnimi: ").append(getEesnimi()).append(", ");
        sb.append("IsikIntsidendis: ").append(getIsikIntsidendis() == null ? "null" : getIsikIntsidendis().size()).append(", ");
        sb.append("Objekt: ").append(getObjekt()).append(", ");
        sb.append("Perek_nimi: ").append(getPerek_nimi()).append(", ");
        sb.append("Piiririkkuja_ID: ").append(getPiiririkkuja_ID()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
