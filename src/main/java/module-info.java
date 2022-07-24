module ASLib {
    requires transitive javafx.controls;

    exports aslib.ai.genderdetector;
    exports aslib.convert.array;
    exports aslib.convert.morsecodifier;
    exports aslib.convert.numericbase;
    exports aslib.document.bra;
    exports aslib.document;
    exports aslib.javafx.dialog;
    exports aslib.javafx.filemanager;
    exports aslib.network;
    exports aslib.operatingsystem;

    opens aslib.ai.genderdetector;
    opens aslib.convert.array;
    opens aslib.convert.morsecodifier;
    opens aslib.convert.numericbase;
    opens aslib.document.bra;
    opens aslib.document;
    opens aslib.javafx.dialog;
    opens aslib.javafx.filemanager;
    opens aslib.network;
    opens aslib.operatingsystem;
}
