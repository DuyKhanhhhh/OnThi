package com.example.onthiapib1.service.imlp;

import com.example.onthiapib1.model.User;
import com.example.onthiapib1.repository.IUserRepository;
import com.example.onthiapib1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service("IUserService")
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Iterable<User> findByName(String name) {
        return userRepository.findByNameContaining(name);
    }
}
