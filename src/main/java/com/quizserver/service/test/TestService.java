package com.quizserver.service.test;

import com.quizserver.dto.QuestionDTO;
import com.quizserver.dto.TestDTO;
import com.quizserver.dto.TestDetailsDTO;
import com.quizserver.entities.Test;

import java.util.List;

public interface TestService {
    TestDTO createTest(TestDTO dto);

    public QuestionDTO addQuestionInTest(QuestionDTO dto);
    List<TestDTO> getAllTests();

    public TestDetailsDTO getAllQuestionsByTest(long id);
}
