module org.example.quizapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.quizapp to javafx.fxml;
    exports org.example.quizapp;
}