package ee.itcollege.team24.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooEntity
public class Piirivalvur {

    @NotNull
    private int piirivalvur_ID;

    @NotNull
    private String eesnimed;

    @NotNull
    private String perekonnanimi;
}
