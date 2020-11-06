package br.edu.uniso.apicombanco.Service;

import br.edu.uniso.apicombanco.Model.User;
import br.edu.uniso.apicombanco.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public void delete(Long cpf) {
        userRepository.deleteById(cpf);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    public void update (User user) { userRepository.save(user); }
}
