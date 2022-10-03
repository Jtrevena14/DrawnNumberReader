import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NeuralNetworkNum{
   public static void main(String [] args)throws IOException {
      
      try{
         
         File one = new File("C:\\Users\\Jesse Trevena\\Desktop\\SampleNum\\one.jpg");
         BufferedImage first = ImageIO.read(one);
         File two = new File("C:\\Users\\Jesse Trevena\\Desktop\\SampleNum\\two.png");
         BufferedImage second = ImageIO.read(two);
         File three = new File("C:\\Users\\Jesse Trevena\\Desktop\\SampleNum\\three.png");
         BufferedImage third = ImageIO.read(three);
         File four = new File("C:\\Users\\Jesse Trevena\\Desktop\\SampleNum\\four.png");
         BufferedImage fourth = ImageIO.read(four);
         File five = new File("C:\\Users\\Jesse Trevena\\Desktop\\SampleNum\\five.png");
         BufferedImage fifth = ImageIO.read(five);
         File test = new File("C:\\Users\\Jesse Trevena\\Desktop\\SampleNum\\test.png");
         BufferedImage tes = ImageIO.read(test);
         int height = first.getHeight();
         int width = first.getWidth();
         int[][] a = new int[height][width];
         int[][] b = new int[height][width];
         int[][] c = new int[height][width];
         int[][] d = new int[height][width];
         int[][] e = new int[height][width];
         int[][] samp = new int[height][width];
         int[] cc = new int[9];
         int j=0;
         int check1=0,check2=0,check3=0,check4=0,check5=0;
         int check2err=0;
         for (int y = 0; y < first.getHeight(); y++) {
            for (int x = 0; x < first.getWidth(); x++) {
                
              checkColor(first,a,x,y);
              checkColor(second,b,x,y);
              checkColor(third,c,x,y);
              checkColor(fourth,d,x,y);
              checkColor(fifth,e,x,y);
              checkColor(tes,samp,x,y);
              
              check1 = checkSimilar(check1,a,samp,x,y);
              check2 = checkSimilar(check2,b,samp,x,y);
              check3 = checkSimilar(check3,c,samp,x,y);
              check4 = checkSimilar(check4,d,samp,x,y);
              check5 = checkSimilar(check5,e,samp,x,y);
              
              //check2err=checkError(check2err,b,samp,x,y);
            }
         }
         cc[j++] = check1;
         cc[j++] = check2;
         cc[j++] = check3;
         cc[j++] = check4;
         cc[j++] = check5;
         System.out.println(check1 + " " + check2 + " " + check3 + " " + check4 + " " + check5);
         int max=0;
         for(int i = 0; i<cc.length;i++){
            if(cc[i]>max){
               max=cc[i];
            }
         }
         checkNum(max,cc);
      }
      catch(IOException e){
         e.printStackTrace();
      }
   } 
   public static void checkColor(BufferedImage num,int[][] arr,int x, int y){
      int c = num.getRGB(x,y);
      Color color = new Color(c);
              
      if (color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
         arr[x][y]=1;
      }
   }
   public static int checkSimilar(int check,int[][] arr,int[][] samp,int x, int y){
      if(samp[x][y]==1 && arr[x][y]==1){
          check++;
      }
      return check;
   }
   public static int checkError(int checkerr,int[][] arr,int[][] samp,int x, int y){
      if(samp[x][y]==1 && arr[x][y]==0){
          checkerr++;
      }
      return checkerr;
   }
   public static void checkNum(int max, int[] cc){
      for(int i = 0; i<cc.length;i++){
         if(max==cc[i]){
            System.out.println("Number is a: " + (i+1));
         }
      }
   }
}
