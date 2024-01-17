package New.Messages;

public class Messages {
    public static final String COMMAND_LIST = """

            Gib '6aus49' oder 'Eurojackpot' ein, optional mit bis zu 6 Zahlen, die ausgeschlossen werden.
            Alternativ tippe 'setunluckynumbers' um nur die Unglückszahlen zu ändern, gefolgt von bis zu 6 Zahlen.
            'showunluckynumbers' um die aktuellen Unglückszahlen anzuzeigen.
            'deleteunluckynumbers' um die aktuellen Unglückszahlen zu löschen.
            'unlimitedlotto' + 'Eurojackpot' oder '6aus49', optional mit bis zu 6 Zahlen, um automatisch Lottoscheine generieren zu lassen.Enter beendet dann die Generierung.""";

    public static final String TOO_MANY_NUMBERS ="\nEs dürfen nur bis zu 6 Unglückszahlen eingegeben werden.";

    public static final String WRONG_FORMAT = "\nFür die Unglückszahlen müssen Zahlen eingegeben werden.";

    public static final String NUMBER_OUT_OF_RANGE1 = "Für Lotto 6aus49 sind nur Zahlen von 1 bis 49 gültig";
    public static final String NUMBER_OUT_OF_RANGE2 = "Für Eurojackpot sind nur Zahlen von 1 bis 50 gültig";
    public static final String NUMBER_OUT_OF_RANGE3 = "Zum Setzen von Unglückszahlen sind nur Zahlen von 1 bis 50 gültig (beachte 6aus49 bis der Zahl 50)";
    public static final String NEW_NUMBERS ="Die neuen Zahlen wurden gespeichert.";

    public static final String LOADED_NUMBER_OUT_OF_RANGE1 = "Eine noch gespeichtere Unglückszahl ist nicht im Bereich von 1 bis 49, bitte korrigieren.";
    public static final String LOADED_NUMBER_OUT_OF_RANGE2 = "Eine noch gespeichtere Unglückszahl ist nicht im Bereich von 1 bis 50, bitte korrigieren.";
    public static final String NO_NEW_NUMBERS_PASSED = "Es müssen die neuen Unglückszahlen angegeben werden.";

    public static final String FILE_CREATED ="Es wurde die txt Datei erstellt.";
    public static final String FILE_CLEARED ="Die Unglückszahlen wurden entfernt.";
    public static final String NO_CURRENT_NUMBERS ="Momentan gibt es keine Unglückszahlen.";
    public static final String CURRENT_NUMBERS ="Die momentanen Unglückszahlen sind: ";
    //public static final String NO_NEW_NUMBERS_PASSED ="Es wurde die txt Datei erstellt.";
}
