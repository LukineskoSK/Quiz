package org.example;

import java.util.List;

public class Question {
    private String questionText;
    private List<Answer> answers;
    private boolean oneAnswer;

    public Question(String questionText, List<Answer> answers, boolean oneAnswer) {
        this.questionText = questionText;
        this.answers = answers;
        this.oneAnswer = oneAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String isOneAnswer() {
        if (oneAnswer) {
            return "(Single answer)";
        } else {
            return "(Multi answer)";
        }
    }

    public boolean getOneAnswer() {
        return oneAnswer;
    }

    public String correctAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(answers.get(i).getAnswerLabel());
            }
        }
        return stringBuilder.toString();
    }
}
