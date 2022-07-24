module ASLib {
    requires transitive javafx.controls;

    exports aslib.ai.genderdetector;
    exports aslib.document;
    exports aslib.document.bra;
    exports aslib.javafx.filemanager;
    exports aslib.javafx.dialog;
    exports aslib.network;
    exports aslib.operatingsystem;
    exports aslib.util.morsecodifier;

    opens aslib.ai.genderdetector;
    opens aslib.document;
    opens aslib.document.bra;
    opens aslib.javafx.filemanager;
    opens aslib.javafx.dialog;
    opens aslib.network;
    opens aslib.operatingsystem;
    opens aslib.util.morsecodifier;
}
