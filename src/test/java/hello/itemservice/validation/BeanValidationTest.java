package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {
    
    @Test
    public void beanValidation() throws Exception {
        //given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = Item.of(" ", 0, 10000);

        //when
        Set<ConstraintViolation<Item>> validations = validator.validate(item);
        //then
        for (ConstraintViolation<Item> validation : validations) {
            System.out.println("validation = " + validation);
            System.out.println("validation.getMessage() = " + validation.getMessage());
        }
        
    }
}
