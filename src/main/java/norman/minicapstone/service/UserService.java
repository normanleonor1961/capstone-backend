package norman.minicapstone.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import norman.minicapstone.dto.UserDTO;
import norman.minicapstone.entity.UserEntity;
import norman.minicapstone.exception.UserAlreadyExist;
import norman.minicapstone.model.UserRequest;
import norman.minicapstone.repository.UserRepository;
import norman.minicapstone.util.DateTimeUtil;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DateTimeUtil dateTimeUtil;
    private final ModelMapper modelMapper;

    public UserDTO saveUser(@NonNull UserRequest newUser) {

        // Check if email is existing
        if(userRepository.findByEmail(newUser.getEmail()) !=null) {
            throw new UserAlreadyExist("Email already in used");
        }

        // Initialize user
        UserEntity user = UserEntity
                .builder()
                .userId(UUID.randomUUID())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .totalOrders(0)
                .successOrders(0)
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build();

        // Save to database
        userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);

    }

    public String deleteUser(String email) {
        String response = "No data has been deleted";

        // Get user
        UserEntity user = userRepository.findByEmail(email);

        // Check if user exist
        if(user != null) {
            userRepository.deleteByEmail(user.getEmail());
            response = email + " has been successfully deleted";
        }

        return response;
    }

    public UserDTO updateUser(String oldEmail, UserRequest userRequest) {
        // Initialize user
        UserEntity user = userRepository.findByEmail(oldEmail);

        // Check if user is existing
        if (user == null) throw new UserAlreadyExist("User doesn't exist");

        // update user
        UserEntity updatedUser = UserEntity
                .builder()
                .userId(user.getUserId())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .totalOrders(user.getTotalOrders())
                .successOrders(user.getSuccessOrders())
                .createdDate(user.getCreatedDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build();

        // save updated user
        // Check if new email exist
        if(userRepository.findByEmail(updatedUser.getEmail()) != null) {
            throw new UserAlreadyExist("Email already in used");
        }
        userRepository.save(updatedUser);

        return modelMapper.map(updatedUser, UserDTO.class);



    }
}
