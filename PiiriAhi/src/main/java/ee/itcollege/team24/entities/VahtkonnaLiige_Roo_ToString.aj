// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.entities;

import java.lang.String;

privileged aspect VahtkonnaLiige_Roo_ToString {
    
    public String VahtkonnaLiige.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alates: ").append(getAlates() == null ? "null" : getAlates().getTime()).append(", ");
        sb.append("Kuni: ").append(getKuni() == null ? "null" : getKuni().getTime()).append(", ");
        sb.append("Vahtkonna_liige_ID: ").append(getVahtkonna_liige_ID()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
