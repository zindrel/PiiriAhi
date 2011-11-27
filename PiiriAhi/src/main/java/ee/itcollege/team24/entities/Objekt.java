package ee.itcollege.team24.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooEntity
public class Objekt {

    @NotNull
    private int Objekt_ID;

    @NotNull
    private String nimetus;
}
