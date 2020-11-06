package br.edu.uniso.apicombanco.Controller;


import br.edu.uniso.apicombanco.Model.User;
import br.edu.uniso.apicombanco.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


//    public List<Aluno> listaAlunos(){
//        return service.listarTodos();
//    }

    @GetMapping("/users")
    public List<User> listUsers(HttpServletResponse response) {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id) {

        if(id == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Checar se o ususário existe
        Optional<User> exists = userService.findOne(id);

        //System.out.println(exists.isEmpty());

        if(exists.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exists.get(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        if (user.isInvalid()) new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        userService.create(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
        if(id == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Checar se o ususário existe
        Optional<User> exists = userService.findOne(id);

        if(exists.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Colocar o id existente no usuário e atualiza-lo
        user.setId(exists.get().getId());
        userService.update(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
