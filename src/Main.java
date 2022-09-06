

public class Main {

    //Video buffer
    static int width = 17;
    static int height = 2;
    static char[][] videoBuffer = new char[height][width];
    //*************

    //This method cleans console and prints videoBuffer
    public static void updateScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String buffer="";
        for(int h=0;h<height;h++){
            for(int w=0;w<width;w++) {
                buffer += videoBuffer[h][w];
            }
            System.out.println(buffer);
            buffer="";
        }
    }

    //Function fills video buffer with ' '.
    public static void clearVideoBuffer(){
        for(int h=0;h<height;h++){
            for(int w=0;w<width;w++){
                videoBuffer[h][w] = ' ';
            }
        }
    }

    public static void main(String[] args)
    {
        clearVideoBuffer();
        String printedText = "-Hello world!-"; //Text size must be less or equal that videobuffer width
        for(int h=0;h<height;h++){
            for(int s = 0;s<printedText.length();s++){
                videoBuffer[h][s] = printedText.toCharArray()[s];
                if(h>0){
                    videoBuffer[h-1][s]=' ';
                }
                updateScreen();
                try {
                    Thread.sleep(200);
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                }
            }
        }

    }
}