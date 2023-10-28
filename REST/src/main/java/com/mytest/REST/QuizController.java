package com.mytest.REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private List<Question> questions;
    private int currentQuestionIndex = 0;

    public QuizController() {
        questions = new ArrayList<>();
        questions.add(new Question("Mikä on Suomen pääkaupunki", "Helsinki"));
        questions.add(new Question("Mikä on maailman suurin valtameri?", "Tyynimeri"));
        // Tähän voi lisätä lisää kysymyksiä
    }

    // Tämä Endpoint "/quiz/question" palauttaa tämänhetkisen kysymyksen
    @GetMapping("/question")
    public Question getQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            currentQuestionIndex++;
            return currentQuestion;
        } else {
            return new Question("Kaikki kysymykset on käyty läpi.", "");
        }
    }

    // Tämä Endpoint "/quiz/answer" tarkistaa vastauksen Get-pyynnöllä
    @GetMapping("/answer")
    public String getAnswer(@RequestParam String answer) {
        if (currentQuestionIndex - 1 < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex - 1);
            if (answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                return "Oikein!";
            } else {
                return "Väärin!";
            }
        } else {
            return "Kaikki kysymykset on jo käyty läpi.";
        }
    }

    //Tämä Endpoint "/quiz/check" tarkistaa vastauksen POST-pyynnöllä
    @PostMapping("/check")
    public String checkAnswer(@RequestBody Map<String, String> answerMap) {
        String answer = answerMap.get("answer");

        if (currentQuestionIndex - 1 < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex - 1);
            if (answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                return "Oikein!";
            } else {
                return "Väärin!";
            }
        } else {
            return "Kaikki kysymykset on jo käyty läpi.";
        }
    }

}
