package br.com.evertonmartins.springbootmongodb.dto;

import br.com.evertonmartins.springbootmongodb.domain.User;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
