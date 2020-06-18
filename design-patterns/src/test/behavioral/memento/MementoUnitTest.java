package test.behavioral.memento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.behavioral.memento.EmpCaretaker;
import main.behavioral.memento.EmpOriginator;

class MementoUnitTest {

	private EmpCaretaker empCaretaker;
	@BeforeEach
	void setUp() throws Exception {
		empCaretaker = new EmpCaretaker();
	}

	@Test
	void When_Undo_ThenCorrect() {
		
		EmpOriginator empOriginator = new EmpOriginator(11, "Tinos", "555-555", "Oregon");
		empCaretaker.addMemento(empOriginator.saveToMemento());
		empOriginator.setEmpName("San-Tinos");
		empCaretaker.addMemento(empOriginator.saveToMemento());
		empOriginator.setEmpName("Santinos");
		assertEquals("Santinos", empOriginator.getEmpName());
		empOriginator.undoFromMemento(empCaretaker.getMemento());
		assertEquals("San-Tinos", empOriginator.getEmpName());
		empOriginator.undoFromMemento(empCaretaker.getMemento());
		assertEquals("Tinos", empOriginator.getEmpName());
	}

}
