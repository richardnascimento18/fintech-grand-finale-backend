package br.com.fiap.cashiq_backend.infrastructure.ports.in.web;

import br.com.fiap.cashiq_backend.application.service.ExpenseService;
import br.com.fiap.cashiq_backend.domain.model.Expense;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.request.ExpenseRequestDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.ApiResponseDto;
import br.com.fiap.cashiq_backend.infrastructure.ports.in.web.dto.response.ExpenseResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Value("${app.version}")
    private String API_VERSION;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ApiResponseDto<ExpenseResponseDto> add(@Valid @RequestBody ExpenseRequestDto expenseRequestDto) {
        Expense createdExpense = expenseService.save(expenseRequestDto.ds_expense(), expenseRequestDto.vl_expense(), expenseRequestDto.cd_user());
        ExpenseResponseDto dto = new ExpenseResponseDto(createdExpense.getCd_expense(), createdExpense.getDs_expense(), createdExpense.getVl_expense());

        Map<String, ApiResponseDto.Link> links = new LinkedHashMap<>();
        links.put("previous", new ApiResponseDto.Link("GET", "http://localhost:8080/api/v1/expense/{user-id}/{page}", "all-expense-from-user"));
        links.put("current", new ApiResponseDto.Link("POST", "http://localhost:8080/api/v1/expense", "add-expense"));
        links.put("next", new ApiResponseDto.Link("DELETE", "http://localhost:8080/api/v1/expense/" + createdExpense.getCd_expense(), "delete-expense"));

        return new ApiResponseDto<>(201, API_VERSION, dto, links);
    }

    @GetMapping("/{userId}/{page}")
    public ApiResponseDto<List<ExpenseResponseDto>> getAllByUserId(@PathVariable String userId, @PathVariable int page) {
        List<Expense> expenseList = expenseService.findAllByCdUser(page, userId);
        List<ExpenseResponseDto> expenseResponseDtoList = expenseList.stream()
                .map(expense -> new ExpenseResponseDto(expense.getCd_expense(), expense.getDs_expense(), expense.getVl_expense()))
                .toList();

        Map<String, ApiResponseDto.Link> links = new LinkedHashMap<>();
        links.put("previous", new ApiResponseDto.Link("POST", "http://localhost:8080/api/v1/expense", "add-expense"));
        links.put("current", new ApiResponseDto.Link("GET", "http://localhost:8080/api/v1/expense/{user-id}/{page}", "all-expense-from-user"));

        return new ApiResponseDto<>(200, API_VERSION, expenseResponseDtoList, links);
    }

    @DeleteMapping("/{cdExpense}")
    public ApiResponseDto deleteExpense(@PathVariable String cdExpense) {
        expenseService.deleteByCdExpense(cdExpense);

        Map<String, ApiResponseDto.Link> links = new LinkedHashMap<>();
        links.put("previous", new ApiResponseDto.Link("GET", "http://localhost:8080/api/v1/expense/{user-id}/{page}", "all-expense-from-user"));
        links.put("current", new ApiResponseDto.Link("DELETE", "http://localhost:8080/api/v1/expense/" + cdExpense, "delete-expense"));
        links.put("next", new ApiResponseDto.Link("POST", "http://localhost:8080/api/v1/expense", "add-expense"));

        return new ApiResponseDto<>(204, API_VERSION, null, links);
    }

}

