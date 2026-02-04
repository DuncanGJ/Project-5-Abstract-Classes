//CS 145 Assignment #5 abstract class
//Duncan Jackson
//TextTransform abstract class implements basic setter and getter methods, and transform() abstract method
//ReverseTransform & CaesarTransform extend the abstract class and implement transform based on each on each class's transform type
//ReverseTransform reverses the string
//CaesarTransform implements a Caesar cypher 

public class TextTransformtest{
    public void main(String[] args) {
        ReverseTransform transform = new ReverseTransform();
        transform.transform("input");
        System.out.println(transform.getOutput());

        CaesarTransform caesar = new CaesarTransform();
        caesar.transform("input");
        System.out.println(caesar.getOutput());
        caesar.transform("input", 5);
        System.out.println(caesar.getOutput());
        caesar.transform("input! Testing...", 12);
        System.out.println(caesar.getOutput());
    }

    //reverse transform
    public class ReverseTransform extends TextTransform{
        public String transform(String uInput){
            this.setInput(uInput);
            //implement transform function below
            StringBuilder builder = new StringBuilder();
            for (int i = uInput.length()-1; i >= 0; i--){
                builder.append(uInput.charAt(i));
            }
            this.setOutput(builder.toString());
            return this.getOutput();
        }
    }
    //Caesar cypher
    public class CaesarTransform extends TextTransform{
        public String transform(String uInput){
            this.setInput(uInput);
            //implement transform function below
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i <= uInput.length()-1; i++){
                
                builder.append((char) shiftChar(uInput.charAt(i), 5)); //+5 default value
            }
            this.setOutput(builder.toString());
            return this.getOutput();
        }

        //overloading transform
        public String transform(String uInput, int shift){
            this.setInput(uInput);
            //implement transform function below
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i <= uInput.length()-1; i++){
                builder.append((char) shiftChar(uInput.charAt(i), shift)); //let user implement the shift value
            }
            this.setOutput(builder.toString());
            return this.getOutput();
        }

        private static char shiftChar(char c, int shift){
            if (c >= 'a' && c <= 'z'){
                int offset = c - 'a';
                int newoffset = Math.floorMod(offset+shift, 26);
                return (char) ('a' + newoffset);
            }else if (c >= 'A' && c <= 'Z'){
                int offset = c - 'a';
                int newoffset = Math.floorMod(offset+shift, 26);
                return (char) ('a' + newoffset);
            }else{return c;}
        }

    }
}