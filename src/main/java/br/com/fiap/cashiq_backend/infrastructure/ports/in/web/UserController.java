package br.com.fiap.cashiq_backend.infrastructure.ports.in.web;

import br.com.fiap.cashiq_backend.application.service.UserService;
import br.com.fiap.cashiq_backend.domain.model.User;
import br.com.fiap.cashiq_backend.infrastructure.helper.JwtUtil;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request.UserRequestDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.UserResponseDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Value("${app.version}")
    private String API_VERSION;

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
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

    @PostMapping("/{email}/{password}")
    public ApiResponseDto login(@PathVariable String email, @PathVariable String password, HttpServletResponse response) {
        User user = userService.login(email, password);

        String token = jwtUtil.generateToken(user.getEmail_user(), user.getCd_user().toString());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(false);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setAttribute("SameSite", "None");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return new ApiResponseDto(201, API_VERSION, Map.of("message", "Logged in successfully"), null);
    }

    @GetMapping("/me")
    public ApiResponseDto<UserResponseDto> checkMe(@CookieValue("token") String token) {
        String email = jwtUtil.getEmail(token);
        String id = jwtUtil.getUserId(token);

        return new ApiResponseDto<>(201, API_VERSION, new UserResponseDto(UUID.fromString(id), email), null);
    }

    @PostMapping("/logout")
    public ApiResponseDto<Map<String, String>> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        cookie.setHttpOnly(false);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setAttribute("SameSite", "None");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ApiResponseDto<>(200, API_VERSION, Map.of("message", "Logged out successfully"), null);
    }
}
