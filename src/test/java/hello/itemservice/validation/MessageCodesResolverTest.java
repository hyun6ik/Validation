package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    public void messageCodesResolverObject() throws Exception {
        //given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        //when

        //then
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    public void messageCodesResolverField() throws Exception {
        //given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        //then
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        //bindingResult.rejectValue("itemName", "required");
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
