package com.quizserver.entities;

import com.quizserver.dto.QuestionDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String correctOption;

    @ManyToOne
    @JoinColumn(name ="test_id")
    private Test test;

    public QuestionDTO getDto(){
        QuestionDTO dto = new QuestionDTO();
        dto.setId(id);
        dto.setQuestionText(questionText);
        dto.setOptionA(optionA);
        dto.setOptionB(optionB);
        dto.setOptionD(optionD);
        dto.setOptionC(optionC);
        dto.setCorrectOption(correctOption);
        return dto;
    }
}