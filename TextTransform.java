public abstract class TextTransform{
    private String input;
    private String output;

    //setters
    protected void setInput(String input){
        this.input = input;
    }

    protected void setOutput(String output){
        this.output = output;
    }

    //getters
    public String getInput(){
        return input;
    }

    public String getOutput(){
        return output;
    }
    //abstract method to be implemented by subclasses
    public abstract String transform(String input);
}