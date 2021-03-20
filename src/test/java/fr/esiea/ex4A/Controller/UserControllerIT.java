package fr.esiea.ex4A.Controller;

import fr.esiea.ex4A.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private UserRepository repository;

    UserControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void methodPost() throws Exception {
        User user = new User("caugant.guillaume@laposte.net", "Panda", "PandaLeNarvalo", "France", "M", "F");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(user);
        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(result)
            )
            .andExpect(status().isOk())
            .andExpect( content().string("result : true"));

    }


}
