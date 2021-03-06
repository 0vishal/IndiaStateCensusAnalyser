package StateCensusAnalyser;

import StateCensusAnalyser.StateCensusAnalyser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class StateCensusAnalyserTest {

        private StateCensusAnalyser stateCensusAnalyser;
        private String  path="C:/Users/ADMIN/Downloads/IndiaStateCensusData.csv";
        private String wrong_path="C:/User/ADMIN/IndianStateCensusData.csv";
        private String file_type="C:/User/ADMIN/IndiaStateCensusData.txt";
        private String delimiter_type="\"/Users/ADMIN/Downloads/IndiaStateCensusData.csv";
        private String header_type="C:/User/ADMIN/Documents/IndiaStateCensusData.csv";
        private String correct_path="C:/Users/ADMIN/Downloads/IndiaStateCode.csv";
        private String wrong_file_type="C:/User/ADMIN/IndiaStateCode.txt";
        private String delimiter_type_sc="\"/Users/ADMIN/Downloads/IndiaStateCode.csv";
        private String header_type_sc="C:/User/ADMIN/IndiaStateCode.txt";







    @BeforeAll
        public void execute() {
            stateCensusAnalyser=new StateCensusAnalyser();
        }

        @Test
        void NoofRecordMatches() throws CustomException {
            int size=stateCensusAnalyser.loadData(path);
            System.out.println(size);
            Assertions.assertEquals(29,size);
        }

        @Test
        public void Wrong_path_Customexception() {
            try {
                stateCensusAnalyser.loadData(wrong_path);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                Assertions.assertEquals(CustomException.Exceptiontype.Wrong_File, e.type);
            }
        }

        @Test
        public void Wrong_delimitertype_Customexception() throws CustomException {
        try {
            stateCensusAnalyser.loadData(delimiter_type);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.Exceptiontype.Wrong_delimiter_Type, e.type);
        }
        }

        @Test
        public void Wrong_headertype_Customexception() throws CustomException {
        try {
            stateCensusAnalyser.loadData(header_type);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.Exceptiontype.Wrong_header_Type, e.type);
        }
        }


        @Test
        public void Return_Statecodecount() throws CustomException {
        int noofentries = stateCensusAnalyser.loadStateCodeData(correct_path);
        Assertions.assertEquals(37, noofentries);
        }

        @Test
        public void Wrong_path_StateCodeFile() throws CustomException {
        try {
             stateCensusAnalyser.loadStateCodeData(wrong_path);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CustomException.Exceptiontype.Wrong_File,e.type);        }
        }

        @Test
        public void Wrong_filetype_StateCodeFile() throws CustomException {
        try {
            stateCensusAnalyser.loadStateCodeData(wrong_file_type);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.Exceptiontype.Wrong_File_Type,e.type);
        }
        }
        @Test
        public void Wrong_delimitertype_StateCodeFile() throws CustomException {
        try {
            stateCensusAnalyser.loadStateCodeData(delimiter_type_sc);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.Exceptiontype.Wrong_delimiter_Type, e.type);
        }
        }
        @Test
        public void Wrong_headertype_StateCode() throws CustomException {
        try {
            stateCensusAnalyser.loadStateCodeData(header_type_sc);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.Exceptiontype.Wrong_header_Type, e.type);
        }
        }

}
