package models.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator{
	
    private static final String PASSWORD_PATTERN ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
    
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    private Matcher matcher;


    public PasswordValidator() {
        
    }

    @Override
    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

}
