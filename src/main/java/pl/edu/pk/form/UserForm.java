package pl.edu.pk.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import pl.edu.pk.bean.User;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserForm extends User {
	
    @NotNull
    @Size(min=2, max=30, message="Hasło nie może być krótsze niż 2 znaki i dłóższe niż 30")
	private String password2;
    
    public User getUser(){
    	User user = new User();
    	user.setFirst_name(getFirst_name());
    	user.setLast_name(getLast_name());
    	user.setPassword(getPassword());
    	user.setEmail(getEmail());
    	user.setPesel(getPesel());
    	return user;
    }
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
