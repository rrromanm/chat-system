module com.example.chatsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;

    opens com.example.chatsystem to javafx.fxml;
    opens com.example.chatsystem.View to javafx.fxml;
    opens com.example.chatsystem.Model to javafx.base, com.google.gson;
    opens com.example.chatsystem.ViewModel to javafx.fxml;

    exports com.example.chatsystem;

}
