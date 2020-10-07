package com.demo.shopping.com.service;

import com.demo.shopping.com.Entity.User;
import com.demo.shopping.com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void saveUserProducts(User user) {
        entityManager.merge(user);
    }

    public User finduserbyId(int uid){
        User user = userRepository.findById(uid);
        return user;
    }
}
