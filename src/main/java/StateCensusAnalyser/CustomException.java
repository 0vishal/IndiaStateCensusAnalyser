package StateCensusAnalyser;

public class CustomException extends Throwable {
    public  StateCensusAnalyser.CustomException.Exceptiontype type;

    public enum Exceptiontype {
        Wrong_File;
    }


    public CustomException(String s,Exceptiontype type){
        super(s);
        this.type=type;
    }
}
