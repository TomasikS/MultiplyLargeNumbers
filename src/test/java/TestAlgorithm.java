import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.TestMappings;
import org.jsmart.zerocode.jupiter.extension.ParallelLoadExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@LoadWith("my_load_config.properties")
@ExtendWith({ParallelLoadExtension.class })
public class TestAlgorithm {

    @TestMappings({
            @TestMapping(testClass = Testing.class, testMethod = "AlgorithmA"),
            @TestMapping(testClass = Testing.class, testMethod = "AlgorithmB"),
    })

    @Test

    public void testPerfomance() {

    }



}
