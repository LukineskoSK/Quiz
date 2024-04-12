package org.example;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int getNumberQuestion() {
        return questions.size();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(int index) {
        if (index < 0 || index >= questions.size()) {
            return null;
        } else {
            return questions.get(index);
        }
    }
}
