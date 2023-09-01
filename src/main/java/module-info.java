module org.artavia.torres.p1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.artavia.torres.p1 to javafx.fxml;
    exports org.artavia.torres.p1;
}
