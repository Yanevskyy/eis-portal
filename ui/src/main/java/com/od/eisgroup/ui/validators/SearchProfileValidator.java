package com.od.eisgroup.ui.validators;

import org.primefaces.validate.ClientValidator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

/**
 * Validates the symbols according to the specification BRM038, BRM039, BRM040
 */
@FacesValidator("com.od.eisgroup.ui.validators.SearchProfileValidator")
public class SearchProfileValidator implements Validator, ClientValidator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o.toString().length() > 50) {
            getExceptionMessage("More than 50 symbols are not allowed");
        }
        if (o.toString().isEmpty() || o.toString().equals(" ")) {
            getExceptionMessage("Your search input is not allowed");
        }
        if (checkSymbols(o.toString())) return;
        getExceptionMessage("Your search input is not allowed");
    }

    /**
     * First checks containing only english symbol and the symbols ' ' and '-'.
     * Second checks count the symbols ' ' and '-'.
     *
     * @param message
     * @return
     */
    private boolean checkSymbols(String message) {
        if (message.matches("([A-Za-z\\s\\-]+)")) {
            int space = 0;
            int dash = 0;
            for (char symbol : message.toCharArray()) {
                if (symbol == ' ') space++;
                if (symbol == '-') dash++;
            }
            if (space < 2 && dash < 2) return true;
        }
        return false;
    }

    private void getExceptionMessage(String messageException) throws ValidatorException {
        FacesMessage message = new FacesMessage(messageException);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(message);
    }

    @Override
    public Map<String, Object> getMetadata() {
        return null;
    }

    @Override
    public String getValidatorId() {
        return "com.od.eisgroup.ui.validators.SearchProfileValidator";
    }
}
