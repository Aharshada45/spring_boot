package com.harshada.spring_boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harshada.spring_boot.models.User;

@Service
public class UserService {

    private  List<User> allUsers;
    private int curId = 3;
    public UserService() {
        allUsers = new ArrayList<>();

        allUsers.add(new User(
                1,
                "John",
                "Male",
                "/images/john.png"));

        allUsers.add(new User(
                2,
                "Jane",
                "Female",
                "/images/jane.png"));
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getUserById(int id) {
        for (int i=0;i<allUsers.size();i++) {
            if (allUsers.get(i).getId() == id) {
                return allUsers.get(i);
            }
        }
        return null;
    }

    public User addNewUser(User user) {
        user.setId(curId);
        curId++;
        allUsers.add(user);
        return user;
    }

    // public User updateUser(int id,User user){
    //     for(int i=0;i<allUsers.size();i++){
    //         if(allUsers.get(i).getId()==id){
    //             if(user.getName()!=null){allUsers.get(i).setName(user.getName());}
    //             if(user.getGender()!=null){allUsers.get(i).setGender(user.getGender());}
    //             if(user.getImage()!=null){allUsers.get(i).setImage(user.getImage());}
    //             return allUsers.get(i);
    //         }
    //     }
    //     return null;
    // }

    public User updateUser(int id, User updatedUser) {
    User existingUser = getUserById(id);

    if (existingUser == null) {
        return null;
    }

    if (updatedUser.getName() != null) {
        existingUser.setName(updatedUser.getName());
    }

    if (updatedUser.getGender() != null) {
        existingUser.setGender(updatedUser.getGender());
    }

    if (updatedUser.getImage() != null) {
        existingUser.setImage(updatedUser.getImage());
    }

    return existingUser;
}
}