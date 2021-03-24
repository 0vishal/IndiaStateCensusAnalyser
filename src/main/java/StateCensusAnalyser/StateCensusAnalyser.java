package StateCensusAnalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    
        public int loadData(String path) throws CustomException {
            if(path.contains(".csv")) {
                int i = 0;
                try {
                    Reader reader = Files.newBufferedReader(Paths.get(path));
                    CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

                    Iterator<CSVStateCensus> csvStateCensusAnalyserIterator = csvToBean.iterator();

                    while (csvStateCensusAnalyserIterator.hasNext()) {
                        CSVStateCensus censusAnalyser = csvStateCensusAnalyserIterator.next();
                        System.out.println("Name : " + censusAnalyser.getState());
                        System.out.println("Email : " + censusAnalyser.getPopulation());
                        System.out.println("PhoneNo : " + censusAnalyser.getAreaInSqKm());
                        System.out.println("Country : " + censusAnalyser.getDensityPerSqKm());
                        i++;
                    }
                } catch (IOException e) {
                    throw new CustomException(e.getMessage(), CustomException.Exceptiontype.Wrong_File);
                }
                catch (RuntimeException e){
                    if(e.getMessage().contains("CSV header")){
                        throw new CustomException(e.getMessage(), CustomException.Exceptiontype.Wrong_header_Type);
                    }
                    throw new CustomException(e.getMessage(), CustomException.Exceptiontype.Wrong_delimiter_Type);
                }
                return i;
            }
            else {
                    throw new CustomException("Wrong file type", CustomException.Exceptiontype.Wrong_File_Type);

                }
            }

            public static int loadStateCodeData(String path) throws CustomException {
            int records=0;
            try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStateCode> csvStateCensusAnalyserIterator = csvToBean.iterator();
            while (csvStateCensusAnalyserIterator.hasNext()) {
                CSVStateCode censusAnalyser=csvStateCensusAnalyserIterator.next();
                records++;
            }
            }catch (IOException e) {
                throw new CustomException(e.getMessage(), CustomException.Exceptiontype.Wrong_File);
            }
            return records;
            }
    }

