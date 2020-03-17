package com.company;

import java.util.*;

public class Quiz {

    HashMap<String,String> questions;
    ArrayList<String> questionsDone;
    ArrayList<String> keyList;
    int score = 0;

    public Quiz()
    {
        questions = new HashMap<>();
        questionsDone = new ArrayList<>();
        questions.put("England","London");
        questions.put("Spain","Madrid");
        questions.put("Germany","Berlin");
        questions.put("France","Paris");
        questions.put("Belgium","Brussels");
        questions.put("Turkey","Ankara");
        questions.put("Italy","Rome");
        questions.put("Portugal","Lisbon");
        questions.put("Holland","Amsterdam");
        questions.put("Russia","Moscow");
        keyList = new ArrayList<>(questions.keySet());
        quizMain();
    }

    public static void main(String[] args) {
        new Quiz();
    }

    public void quizMain() {
        System.out.println("Capital City Quiz");
        System.out.println("By Ryan Middleton");
        System.out.println("You will be asked a series of random questions on capital cities, you will be provided with the country and you must answer with the name of the city");
        System.out.println("There are " + questions.size() + " possible questions you may be asked.");
        System.out.println("How many questions would you like to be asked?");
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        input.nextLine();
        while(questionsDone.size() != amount) {
            String currentQuestion = getRandomQuestion();
            System.out.println("Question " + (questionsDone.size() + 1));
            System.out.println("Name the capital city of " + currentQuestion);
            String value = input.nextLine();
            if (value.equalsIgnoreCase(questions.get(currentQuestion))) {
                System.out.println("Correct!");
                score++;
            }
            else {
                System.out.println("Incorrect! The answer was: " + questions.get(currentQuestion));
            }
            questionsDone.add(currentQuestion);
        }
        System.out.println("Thanks for playing, your score was: " + score + "/" + amount);
    }

    public String getRandomQuestion() {
        String newQuestion = null;
        Random rand = new Random();
        while(questionsDone.contains(newQuestion) || newQuestion == null) {
            newQuestion = keyList.get(rand.nextInt(keyList.size()));
        }
        return newQuestion;
    }
}