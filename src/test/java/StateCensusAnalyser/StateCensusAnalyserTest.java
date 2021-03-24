package StateCensusAnalyser;

import StateCensusAnalyser.StateCensusAnalyser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class StateCensusAnalyserTest {

        private StateCensusAnalyser stateCensusAnalyser;
        private String  path="C:/Users/ADMIN/Downloads/IndiaStateCensusData.csv";

        @BeforeAll
        public void execute() {
            stateCensusAnalyser=new StateCensusAnalyser();
        }

        @Test
        void NoofRecordMatches()  {
            int size=stateCensusAnalyser.loadData(path);
            System.out.println(size);
            Assertions.assertEquals(29,size);

        }

    }
