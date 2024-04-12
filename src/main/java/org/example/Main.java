package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Quiz allQuestion = new Quiz();
        // First Question
        List<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer("a", "Paris", true));
        answers1.add(new Answer("b", "London", false));
        answers1.add(new Answer("c", "Dublin", false));
        answers1.add(new Answer("d", "Berlin", false));

        Question question1 = new Question("What is the capital city of France?", answers1, true);

        allQuestion.addQuestion(question1);
        // Second Question
        List<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("a", "Brugy", true));
        answers2.add(new Answer("b", "Brusel", true));
        answers2.add(new Answer("c", "Strasburg", false));
        answers2.add(new Answer("d", "Gent", true));

        Question question2 = new Question("Which cities are in Belgium?", answers2, false);

        allQuestion.addQuestion(question2);
        // Third Question
        List<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("a", "Sidney", false));
        answers3.add(new Answer("b", "Canberra", true));
        answers3.add(new Answer("c", "Melbourne", false));
        answers3.add(new Answer("d", "Brisbane", false));
        Question question3 = new Question("What is the capital city of Australia?", answers3, true);

        allQuestion.addQuestion(question3);

        List<Answer> answers4 = new ArrayList<>();
        answers4.add(new Answer("a", "Sylvester Stallone", true));
        answers4.add(new Answer("b", "Arnold Schwarzenegger", false));
        answers4.add(new Answer("c", "Jason Statham", false));
        answers4.add(new Answer("d", "Vin Diesel", true));
        Question question4 = new Question("Which actors are americans?", answers4, false);

        allQuestion.addQuestion(question4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi. Welcome to the Quiz show. What type of quiz would you like to play?");
        System.out.println("1.Quiz with one correct answer");
        System.out.println("2.Quiz with multiple choice");
        System.out.println("3.Combination of both types of quiz");
        System.out.println("Enter your choice (1,2 or 3)");

        Quiz quiz1 = new Quiz();
        Quiz quiz2 = new Quiz();
        for (Question question : allQuestion.getQuestions()) {
            if (question.getOneAnswer()) {
                quiz1.addQuestion(question);
            } else {
                quiz2.addQuestion(question);
            }
        }
        Quiz quiz = new Quiz();

        while (true) {
            String quizType = scanner.nextLine();
            if (quizType.equals("1")) {
                quiz = quiz1;
                break;
            } else if (quizType.equals("2")) {
                quiz = quiz2;
                break;
            } else if (quizType.equals("3")) {
                quiz = allQuestion;
                break;
            } else {
                System.out.println("Incorrect choice. Try again");
            }
        }

        int result = 0;
        for (int i = 0; i < quiz.getNumberQuestion(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getQuestionText() + question.isOneAnswer());
            for (Answer answer : question.getAnswers()) {
                System.out.println(answer.getAnswerLabel() + ": " + answer.getAnswerText());
            }
            System.out.println("Enter your answer: ");
            String userAnswer = scanner.nextLine();
            userAnswer = userAnswer.replaceAll("[^a-zA-Z]", "");

            String[] userAnswers = userAnswer.split("");
            Arrays.sort(userAnswers);
            String[] correctAnswers = question.correctAnswer().split(",");
            Arrays.sort(correctAnswers);
            if (Arrays.equals(userAnswers, correctAnswers)) {
                result++;
                System.out.println("Correct");
            } else {
                System.out.println("No Correct");
            }
        }
        System.out.println("Finish and Your score: " + result + "/" + quiz.getNumberQuestion());

    }
}