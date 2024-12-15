import java.util.*;

class QuizApplication {
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        List<Question> questions = Arrays.asList(
            new Question("What is the capital of India?", new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 0),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1),
            new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1)
        );

        for (Question question : questions) {
            displayQuestionWithTimer(question);
        }

        System.out.println("\nQuiz Over!");
        System.out.println("Your final score: " + score + "/" + questions.size());
    }

    public static void displayQuestionWithTimer(Question question) {
        System.out.println("\n" + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                System.exit(0);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 10000);

        System.out.print("Your answer (1-4): ");
        int answer = scanner.nextInt();
        timer.cancel();

        if (answer - 1 == question.getCorrectAnswer()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was: " + options[question.getCorrectAnswer()]);
        }
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}