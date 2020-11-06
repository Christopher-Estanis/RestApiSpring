package br.edu.uniso.apicombanco.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String age;
    private String email;
    private String password;
    private String cpf;

    public Boolean isInvalid() {
        if (this.cpf == null || this.name == null || this.email == null || this.password == null) {
            return true;
        }
        return false;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; };

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }
}
