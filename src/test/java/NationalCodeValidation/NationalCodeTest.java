package NationalCodeValidation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aliyari on 20/03/2021.
 */
public class NationalCodeTest {
    @Test
    public void validation() throws Exception {
        NationalCode tectCode = new NationalCode();
        boolean result = tectCode.validation("1111111111");
        boolean result1 = tectCode.validation("0000000061");
        assertEquals(false,result);
        assertEquals(true,result1);

    }

}