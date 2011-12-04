package ee.itcollege.team24.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.VahtkondIntsidendis;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		registry.addConverter(new IntsidentConverter());
		registry.addConverter(new VahtkondIntsidendisConverter());
	}
	
    static class IntsidentConverter implements Converter<Intsident, String> {
        public String convert(Intsident intsident) {
            return new StringBuilder().append(intsident.getKood()).append(": ").append(intsident.getNimetus()).toString();
        }
        
    }
    
    
    static class VahtkondIntsidendisConverter implements Converter<VahtkondIntsidendis, String> {
        public String convert(VahtkondIntsidendis vahtkondIntsidendis) {
            return new StringBuilder().append(vahtkondIntsidendis.getVahtkond().getNimetus()).append(", ").append(vahtkondIntsidendis.getIntsident().getNimetus()).toString();
        }
        
    }
    
}
