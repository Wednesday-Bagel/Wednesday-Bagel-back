package com.example.bobbti.service;

import com.example.bobbti.controller.dto.ResultDto;
import com.example.bobbti.controller.dto.UserInputDto;
import com.example.bobbti.entity.question.QuestionResult;
import com.example.bobbti.repository.QuestionResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ResultService {

    private final QuestionResultRepository questionResultRepository;

    public ResultService(QuestionResultRepository questionResultRepository) {
        this.questionResultRepository = questionResultRepository;
    }

    // 입력받은 1~12번으로 결과찾아서 ID 리턴
    public ResultDto createUserInput(UserInputDto userInputDto) {
        // a1~a12로 결과id 찾기
        QuestionResult questionResult = this.questionResultRepository.findByAnswer1AndAndAnswer2AndAndAnswer3AndAndAnswer4AndAndAnswer5AndAndAnswer6AndAndAnswer7AndAndAnswer8AndAndAnswer9AndAnswer10AndAnswer11AndAnswer12(
                                            userInputDto.getAnswer1(), userInputDto.getAnswer2(), userInputDto.getAnswer3(), userInputDto.getAnswer4(), userInputDto.getAnswer5(), userInputDto.getAnswer6(), userInputDto.getAnswer7(), userInputDto.getAnswer8(), userInputDto.getAnswer9(), userInputDto.getAnswer10(), userInputDto.getAnswer11(), userInputDto.getAnswer12()
                                        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new ResultDto(questionResult);
    }

    // 결과 ID로 결과 DTO 리턴
    public ResultDto readResult(Long resultId){
        QuestionResult questionResult = this.questionResultRepository.findById(resultId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ResultDto resultDto = new ResultDto(questionResult);

        return resultDto;
    }
}
