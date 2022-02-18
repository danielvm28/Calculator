package ui;

import exception.IncompleteOperationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private TextArea historyTA;

	@FXML
	private TextField operationsTF;

	@FXML
	private TextField resultsTF;

	@FXML
	private Button button0;

	@FXML
	private Button button1;

	@FXML
	private Button button2;

	@FXML
	private Button button3;

	@FXML
	private Button button4;

	@FXML
	private Button button5;

	@FXML
	private Button button6;

	@FXML
	private Button button7;

	@FXML
	private Button button8;

	@FXML
	private Button button9;

	@FXML
	private Button plusBTN;

	@FXML
	private Button deleteBTN;

	@FXML
	private Button minusBTN;

	@FXML
	private Button multBTN;

	@FXML
	private Button resultBTN;
	
	@FXML
    private Button clearHistoryBTN;

	private Operation operationType;

	@FXML
	void calculate(ActionEvent event) throws IncompleteOperationException {
		String operation = operationsTF.getText();
		int operator = 0;
		String[] operationArr;

		switch (operationType) {
		case ADDITION:
			operationArr = operation.split("\\+");
			operator = 1;
			break;
		case SUBSTRACTION:
			operationArr = operation.split("-");
			operator = 2;
			break;
		case MULTIPLICATION:
			operationArr = operation.split("x");
			operator = 3;
			break;
		default:
			throw new IncompleteOperationException();
		}

		int value1 = Integer.parseInt(operationArr[0]);
		int value2 = Integer.parseInt(operationArr[1]);
		int result = 0;

		switch (operator) {
		case 1:
			result = value1 + value2;
			break;
		case 2:
			result = value1 - value2;
			break;
		case 3:
			result = value1 * value2;
			break;
		}

		String resultString = "" + result;
		resultsTF.setText(resultString);
		
		historyTA.appendText(operation + " = " + resultString + "\n\n");
	}

	@FXML
	void delete(ActionEvent event) {
		operationsTF.clear();
		resultsTF.clear();
	}

	@FXML
	void press(ActionEvent event) {
		Button pressed = (Button) event.getSource();
		String text = pressed.getText();
		operationsTF.appendText(text);

		if (text.equals("+")) {
			operationType = Operation.ADDITION;
		} else if (text.equals("-")) {
			operationType = Operation.SUBSTRACTION;
		} else if (text.equals("x")) {
			operationType = Operation.MULTIPLICATION;
		}
	}
	
	@FXML
    void clearHistory(ActionEvent event) {
		historyTA.clear();
    }
}
