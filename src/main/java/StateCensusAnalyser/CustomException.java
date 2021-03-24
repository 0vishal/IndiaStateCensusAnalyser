package StateCensusAnalyser;

public class CustomException extends Exception {
    public  Exceptiontype type;

    public enum Exceptiontype {
        Wrong_File,Wrong_File_Type,Wrong_delimiter_Type,Wrong_header_Type;
    }


    public CustomException(String s,Exceptiontype type){
        super(s);
        this.type=type;
    }
}
