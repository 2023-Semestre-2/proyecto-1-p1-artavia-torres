module org.artavia.torres.p1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires java.base;

    opens org.artavia.torres.p1 to javafx.fxml;
    exports org.artavia.torres.p1;
}
