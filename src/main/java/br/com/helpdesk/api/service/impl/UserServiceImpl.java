package br.com.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.helpdesk.api.security.entity.User;
import br.com.helpdesk.api.repository.UserRepository;
import br.com.helpdesk.api.service.UserService;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {

        return this.userRepository.findByEmail(email);
    }

    @Override
    public User createOrUpdate(User user) {

        return this.userRepository.save(user);
    }

    @Override
    public User findById(String id) {

        return this.userRepository.findOne(id);
    }

    @Override
    public void delete(String id) {

        this.userRepository.delete(id);
    }

    @Override
    public Page<User> findAll(int page, int count) {

        Pageable pages = new PageRequest(page, count);
        return this.userRepository.findAll(pages);
    }
}