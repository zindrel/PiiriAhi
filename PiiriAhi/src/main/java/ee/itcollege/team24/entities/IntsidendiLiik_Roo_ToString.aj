// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.entities;

import java.lang.String;

privileged aspect IntsidendiLiik_Roo_ToString {
    
    public String IntsidendiLiik.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Intsidendi_liik_ID: ").append(getIntsidendi_liik_ID()).append(", ");
        sb.append("Intsidents: ").append(getIntsidents() == null ? "null" : getIntsidents().size()).append(", ");
        sb.append("Nimetus: ").append(getNimetus()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
