package cn.rayest;

import cn.rayest.controller.DemoController;
import cn.rayest.service.TestProjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Rayest on 2016/10/6 0006.
 */
public class DemoControllerTest {

    @Mock
    private TestProjectService testProjectService;

    @InjectMocks
    private DemoController demoController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    public void testNumberMinus() throws Exception {

        // http 请求和响应
        this.mockMvc.perform(post("/number/minus")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect((jsonPath("$.longString")).value("1234567890123456789"))
                .andExpect((jsonPath("$.shortString")).value("1"));
    }
}
