package br.com.fiap.cashiq_backend.infrastructure.ports.in.web;

import br.com.fiap.cashiq_backend.application.service.UserService;
import br.com.fiap.cashiq_backend.domain.model.User;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request.UserRequestDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Value("${app.version}")
    private String API_VERSION;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApiResponseDto<UserResponseDto> register(@Valid @RequestBody UserRequestDto userRequestDto) {
        User createdUser = userService.save(userRequestDto.email(), userRequestDto.password(), userRequestDto.confirmPassword());
        UserResponseDto dto = new UserResponseDto(createdUser.getCd_user(), createdUser.getEmail_user());

        Map<String, ApiResponseDto.Link> links = new LinkedHashMap<>();
        links.put("previous", new ApiResponseDto.Link("GET", "http://localhost:8080/api/v1/user/{user-id}", "get-user-by-id"));
        links.put("current", new ApiResponseDto.Link("POST", "http://localhost:8080/api/v1/user", "add-user"));
        links.put("next", new ApiResponseDto.Link("DELETE", "http://localhost:8080/api/v1/user/" + createdUser.getCd_user(), "delete-user"));

        return new ApiResponseDto<>(201, API_VERSION, dto, links);
    }
}
