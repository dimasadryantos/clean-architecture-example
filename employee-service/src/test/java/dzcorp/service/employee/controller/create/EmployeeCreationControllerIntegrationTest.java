package dzcorp.service.employee.controller.create;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dzcorp.core.employee.create.EmployeeCreationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeCreationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void itShouldReturnCorrectResponse() throws Exception {
        EmployeeCreationResponse creationResponse = new EmployeeCreationResponse(1, "DIMAS");

        ResultActions resultActions = mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(convertObjectToJson(creationResponse))));

        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(jsonPath("$.employeeId").value(1));
        resultActions.andExpect(jsonPath("$.employeeName").value("DIMAS"));
    }

    private String convertObjectToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            fail("Fail to convert Object to Json");
            return null;
        }
    }
    

}