package test_case_package;

import java.text.SimpleDateFormat;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sdf_not_null_test {

    @Test
    public void testSimpleDateFormatNotNull() {
        // Create SimpleDateFormat instance
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf);

        // Assert that sdf is not null
        Assert.assertNotNull(sdf, "SimpleDateFormat object should not be null");
    }
}
