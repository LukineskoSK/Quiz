package org.example;

public class Answer {
    private String answerLabel;
    private String answerText;
    private boolean isCorrect;

    public Answer(String answerLabel, String answerText, boolean isCorrect) {
        this.answerLabel = answerLabel;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public String getAnswerLabel() {
        return answerLabel;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
