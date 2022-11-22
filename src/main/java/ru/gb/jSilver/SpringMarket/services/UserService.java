package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.dto.UserListDto;
import ru.gb.jSilver.SpringMarket.repos.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserListDto> getAllUsers() {
        List<UserListDto> userListDtos = userRepository.findAll()
                .stream()
                .map(user -> new UserListDto(user))
                .collect(Collectors.toList());
        return userListDtos;
    }
}
