/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author MZK
 */
public final class CreationUserForm {
    private static final String FIELD_USERNAME = "userName";
    private static final String FIELD_PASSWORD = "userPassword";
    private static final String FIELD_CONFIRMATION= "userConfirmation";
    private static final String FIELD_EMAIL = "userEmail";  
    private String resultat;
    private Map<String,String> errors = new HashMap<String,String>();
    
    public User createUser(HttpServletRequest request){
        
        String username = getValue(request, "userName");
        String password = getValue(request, "userPassword");
        String confirmation = getValue(request, "userConfirmation");
        String email = getValue(request, "userEmail");
        
        User user = new User();
        
        try{
           validationUsername (username);
        }catch(Exception e){
            setError(FIELD_USERNAME, e.getMessage());
        }
        
        try{
           validationPassword(password,confirmation);
        }catch(Exception e){
            setError(FIELD_PASSWORD, e.getMessage());
        }
        
        try{
           validationEmail (email);
        }catch(Exception e){
            setError(FIELD_EMAIL, e.getMessage());
        }
        return user;
    }
    private void validationUsername(String username) throws Exception{
        if(username != null){
            if(username.length() < 2){ 
                throw new Exception("Le username doit faire plus de 2 caractères");
            }
        }else{
            throw new Exception("Le username doit etre renseigné");
        }
    }
    private void validationPassword(String password,String confirmation) throws Exception{
        if(password != null){
            if(password.length() < 2 || confirmation.length() < 2){ 
                throw new Exception("Le mot de passe doit faire plus de 2 caractères");
            }
            if(!confirmation.equals(password)){
                throw new Exception("Le mot de passe et la confirmation doivent être egaux");
            }
        }else{
            throw new Exception("Le mot de passe doit etre renseigné");
        }
    }
    private void validationEmail(String email) throws Exception{
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
    private void setError(String field,String message){
        errors.put(field,message);
    }
    public Map<String, String> getErrors() {
        return errors;
    }
    private static String getValue(HttpServletRequest request, String fieldname){
        String value = request.getParameter(fieldname);
        if(value == null || value.trim().length() == 0 ){
            return null;
        }else{
            return value;
        }
    }    
}
