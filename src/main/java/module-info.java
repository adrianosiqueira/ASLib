module ASLib {
    requires transitive javafx.controls;

    exports aslib.ai;
    exports aslib.cli;
    exports aslib.document;
    exports aslib.document.bra;
    exports aslib.exceptions;
    exports aslib.filemanager;
    exports aslib.fx.control;
    exports aslib.fx.dialog;
    exports aslib.network;
    exports aslib.operatingsystem;
    exports aslib.parse;
    exports aslib.security;
    exports aslib.time;
    exports aslib.util;

    opens aslib.ai;
    opens aslib.cli;
    opens aslib.document;
    opens aslib.document.bra;
    opens aslib.exceptions;
    opens aslib.filemanager;
    opens aslib.fx.control;
    opens aslib.fx.dialog;
    opens aslib.network;
    opens aslib.operatingsystem;
    opens aslib.parse;
    opens aslib.security;
    opens aslib.time;
    opens aslib.util;
}
