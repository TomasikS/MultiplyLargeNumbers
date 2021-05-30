import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Testing {

    @Test
    public void AlgorithmA() {
        String[] array = {"10", "10"};

        Main.AlgorithmA(array);
    }

    @Test
    public void AlgorithmB() {
        String[] array = {"10", "10"};

        Main.AlgorithmB(array);
    }


    @Test
    public void testOutputOptinonA() {
        String[] array = {"10", "10"};
        Assert.assertArrayEquals(Main.AlgorithmA(array), Main.AlgorithmB(array));
    }

    @Test
    public void testOutputOptinonB() {
        String[] array = {"100", "10"};
        Assert.assertArrayEquals(Main.AlgorithmA(array), Main.AlgorithmB(array));
    }


    @Test
    public void testOutputOptinonC() {
        String[] array = {"10", "1000"};
        Assert.assertArrayEquals(Main.AlgorithmA(array), Main.AlgorithmB(array));
    }


}
