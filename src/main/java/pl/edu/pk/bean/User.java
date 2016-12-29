package pl.edu.pk.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import pl.edu.pk.bean.enums.UserType;
import pl.edu.pk.bean.enums.VisitType;

@Entity
@Table(name = "user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@NotNull(message="Pole nie może byc puste")
	@Size(min=2, max=30, message="Imię nie może być krótsze niż 2 znaki i dłóższe niż 30")
	private String first_name;
	
	@NotNull(message="Pole nie może byc puste")
	@Size(min=2, max=30, message="Nazwisko nie może być krótsze niż 2 znaki i dłóższe niż 30")
	private String last_name;
	
	@NotNull(message="Pole nie może byc puste")
	@Size(min=2, max=30, message="Adres e-mail nie może być krótszy niż 2 znaki i dłóższy niż 30")
	@Email(message="Adres e-mail musi być poprawny")
	@Column(unique = true)
	private String email;
	
	@NotNull(message="Pole nie może byc puste")
	@Size(min=2, max=30, message="Hasło nie może być krótsze niż 2 znaki i dłóższe niż 30")
	private String password;
	
	@NotNull
    @Size(min=11, max=11, message="Pesel musi składać się z 11 znaków")
	private String pesel;
	
	@Column(nullable = false)
	private UserType userType;
	
	@Column
	private VisitType specialisation; //Tylko dla lekarza

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		return user_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		if (userType != other.userType)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

}
