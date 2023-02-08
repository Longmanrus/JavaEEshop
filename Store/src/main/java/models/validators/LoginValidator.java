package models.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements Validator{
	
    private static final String LOGIN_PATTERN ="^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    
    private static final Pattern pattern = Pattern.compile(LOGIN_PATTERN);
    private Matcher matcher;


    public LoginValidator() {
        
    }

    @Override
    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

}
