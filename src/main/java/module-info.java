module com.example.chatsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;

    opens com.example.chatsystem.View to javafx.fxml;
    opens com.example.chatsystem.Model to javafx.fxml, javafx.base, com.example.chatsystem.ViewModel;
    opens com.example.chatsystem.ViewModel to javafx.fxml;
    opens com.example.chatsystem.Server to javafx.fxml;
    opens com.example.chatsystem.Client to javafx.fxml;
    opens com.example.chatsystem.Application to javafx.fxml;

    exports com.example.chatsystem.Application;

}
