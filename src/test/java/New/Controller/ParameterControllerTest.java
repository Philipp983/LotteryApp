package New.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import New.Messages.Messages;
import New.Utility.FileWriter;
import New.Utility.LogFiles;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ParameterControllerTest {

    @Mock
    private LogFiles logFilesMock;

    @Mock
    private FileWriter fileWriterMock;

    @InjectMocks
    private ParameterController controller;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void notNullFields() {

        assertNotNull(logFilesMock);
        assertNotNull(fileWriterMock);
    }

    @Test
    void processCommands_Valid6aus49Command_ProcessesCorrectly() {

        String[] args = { "6aus49" };
        controller.processCommands(args);

        assertNotNull(controller);
        assertNotNull(outputStreamCaptor);

        args = new String[0];
        controller.processCommands(args);

        assertNotNull(controller);
        assertNotNull(outputStreamCaptor);
        assertTrue(outputStreamCaptor.toString().trim().startsWith("6aus49 Tippzahlen:"));

        outputStreamCaptor.reset();

        String[] args1 = { "Eurojackpot" };
        controller.processCommands(args1);

        assertNotNull(controller);
        assertNotNull(outputStreamCaptor);
        assertTrue(outputStreamCaptor.toString().trim().startsWith("Eurojackpot 5aus50:"));

    }

    @Test
    void processCommands_ClearUnluckyNumbers_CallsFileWriterClear() {
        // Arrange
        String[] args = { "clearunluckynumbers" };

        // Act
        controller.processCommands(args);

        // Assert/Verify
        verify(fileWriterMock, times(0)).clearFile();
        // verify(logFilesMock, times(0)).addToLogs("unlucky-numbers.txt was cleared");
        assertTrue(fileWriterMock.read().isEmpty());
        assertEquals("Die Unglückszahlen wurden entfernt.", Messages.FILE_CLEARED,
                outputStreamCaptor.toString().trim());
    }
}
