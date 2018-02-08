package Controller.helper;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

public class ChangeListener implements javafx.beans.value.ChangeListener<String> {
    private int maxLength;
    private TextArea textArea;

    public ChangeListener(TextArea textArea, int maxLength) {
        this.textArea= textArea;
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Устанавливем максимальное количство символов для вводимой записи
     * @param observable
     * @param oldValue
     * @param newValue
     */
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if (newValue == null) {
            return;
        }
        if (newValue.length() > maxLength) {
            textArea.setText(oldValue);
        } else {
            textArea.setText(newValue);
        }
    }
}