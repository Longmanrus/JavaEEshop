package models.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator{
	
    private static final String EMAIL_PATTERN ="^[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"@"
    		+"[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"\\.[a-zA-Z]{2,}$";
    
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;


    public EmailValidator() {
        
    }
    
    @Override
    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

}
