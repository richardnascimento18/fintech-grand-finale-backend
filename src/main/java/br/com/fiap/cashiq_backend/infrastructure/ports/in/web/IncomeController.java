package br.com.fiap.cashiq_backend.infrastructure.ports.in.web;

import br.com.fiap.cashiq_backend.application.service.IncomeService;
import br.com.fiap.cashiq_backend.domain.model.Income;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request.IncomeRequestDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.IncomeResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/income")
public class IncomeController {
    private final IncomeService incomeService;

    @Value("${app.version}")
    private String API_VERSION;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public ApiResponseDto<IncomeResponseDto> add(@Valid @RequestBody IncomeRequestDto incomeRequestDto) {
        Income createdIncome = incomeService.save(incomeRequestDto.ds_income(), incomeRequestDto.vl_income(), incomeRequestDto.cd_user());
        IncomeResponseDto dto = new IncomeResponseDto(createdIncome.getCd_income(), createdIncome.getDs_income(), createdIncome.getVl_income());

        Map<String, ApiResponseDto.Link> links = new LinkedHashMap<>();
        links.put("previous", new ApiResponseDto.Link("GET", "http://localhost:8080/api/v1/income/{user-id}", "all-income-from-user"));
        links.put("current", new ApiResponseDto.Link("POST", "http://localhost:8080/api/v1/income", "add-income"));
        links.put("next", new ApiResponseDto.Link("DELETE", "http://localhost:8080/api/v1/income/" + createdIncome.getCd_income(), "delete-income"));

        return new ApiResponseDto<>(201, API_VERSION, dto, links);
    }

}
