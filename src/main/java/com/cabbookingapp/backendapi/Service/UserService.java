package com.cabbookingapp.backendapi.Service;

import com.cabbookingapp.backendapi.Exception.UserGenderException;
import com.cabbookingapp.backendapi.Exception.UserGenerationException;
import com.cabbookingapp.backendapi.Exception.UserNotFoundException;
import com.cabbookingapp.backendapi.Model.User;
import com.cabbookingapp.backendapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) throws UserGenderException, UserGenerationException
    {
        if(user.getName() == null || user.getAge() <= 0 || user.getGender() == null || user.getEmail() == null)
            throw new UserGenerationException("Fields cannot be empty!");

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        String email = user.getEmail();
        if(!pattern.matcher(email).matches())
            throw new UserGenderException("Invalid email pattern!");

//        String gender = user.getGender().toLowerCase();
//        if(!gender.equals("m") || !gender.equals("f"))
//            throw new UserGenderException("Gender could be 'M' or 'F' only!");

        userRepository.findUserByEmail(email)
                .ifPresent(u -> {
                    throw new UserGenerationException("Email already exists!");
                });

        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User with id : "+id+" not found!"));
    }

    public User updateUser(User user)
    {
        userRepository.findUserByEmail(user.getEmail().toLowerCase()).orElseThrow(()
                -> new UserNotFoundException("Unregistered or invalid email, please check entered email!"));
        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        Optional<User> user = userRepository.findUserById(id);
        user.ifPresent(value -> userRepository.delete(value));
        user.orElseThrow(() -> new UserNotFoundException("User with id: "+id+" not found!"));
    }
}
