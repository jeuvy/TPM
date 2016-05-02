import processing.core.PApplet;


public class ThePianoMan extends PApplet {

    public static void main(String[] args) {
        
        PApplet.main(new String[]{"ThePianoMan"});
   
    }
    
    //kill me this took forever
 
public void setup()
{
  
  background(255);
  MusicBox.initialize();
}
 
public void draw()
{
  //declaring key variables 
  int keyNum = 8;
  int wWidth = width/8;
  int wHeight = height-50;
  float bHeight = (3*height/5)-50;
  float bWidth = wWidth/2;
  int blackHover = -1;
  strokeWeight(2);
  
  
  //loop for white keys
  for (int wKey=0; wKey < width/wWidth; wKey++)
  {
    stroke(1);
    float wKeyLeft = wKey * wWidth;
    float wKeyRight = wKeyLeft + wWidth;
    float bKeyLeft = wKeyRight - bWidth/2;
    float bKeyRight = bKeyLeft + bWidth;
    
 
   
   if (wKey == 2 || wKey == 6 || wKey ==7){
       continue;
   }
   
    //white keys change color with mouse click
    if(mouseX > bKeyLeft && mouseX <= bKeyRight && mouseY > 0
      && mouseY <= bHeight){
          blackHover = wKey;
      }
     {
    println(blackHover);
       
     }
    
    //white keys change color with mouse hovering
   for (int i = 0; i < keyNum; i++){
        float wKeyLeft = wKey * wWidth;
        float wKeyRight = wKeyLeft + wWidth;
        float bKeyLeft = wKeyRight - bWidth/2;
        
        if (mousePressed && mouseX >= wKeyLeft && mouseX <= wKeyRight && blackHover == -1){
            fill(#F6B6B6);
        }
        else{
            fill(255);
        }
        rect(keyWidth, 0, wWidth, height);
   }
  }
 
  //draws the black keys
  for (int bKey=0; bKey<6; bKey++)
  {
     int whiteKeyLeft = i * whiteKeyWidth; 
     int whiteKeyRight = whiteKeyLeft + whiteKeyWidth;
     int blackKeyLeft = whiteKeyRight - blackKeyWidth/2;
     if (mousePressed && i == blackHover){
         fill (#81FCDD);
     }
     else if (i == blackHover){
         fill (#5A5050);
     }
     else{
         fill (0);
     }
     
     if (i != 2 && i != 6 && i !=7){
         rect (bKeyLeft , 0, bWidth, bHeight);
     }}}
     }
     }
     }
     }
    
    noStroke();
    float keyHeight= wWidth*(bKey+1)- bWidth/2;
    if (bKey==2)
    {
      keyHeight= wWidth*(bKey+1)-bWidth/2+wWidth;
    }
    blackHover= bKey;

    //click the mouse and the black keys change color
    if (mouseX > keyHeight && mouseX <= keyHeight + bWidth && mouseY <= bHeight
      && mousePressed && blackHover <= bKey+1 )
      {
      stroke(2);
      fill(105, 105, 130);
      } 
      
     //black keys change color if mouse hovers above it
    else if (mouseX>keyHeight&& mouseX<= keyHeight+ bWidth&& mouseY <= bHeight &&
      blackHover== bKey)
      {
        stroke(1);
        fill(100, 100, 240);
      }
      
      //otherwise, keep the keys black!
    else
      {
        fill(0);
      }
      rect(keyHeight, 0, bWidth, bHeight);
  }
}
 
 
public void mousePressed()
{
  int wWidth = width/8;
  int wHeight = height;
  float bHeight = 3*height/5;
  float bWidth = wWidth/2;
 
  for (int wKey=0; wKey < width/wWidth; wKey++)
  {
    float keyHeight = wKey * wWidth;
   
    //white keys change color with mouse click
    if(mouseX > keyHeight && mouseX <= keyHeight + wWidth && mouseY <= wHeight
      && mousePressed
      && get(mouseX,mouseY) != color(100, 100, 240)
      && get(mouseX,mouseY) != color(105, 105, 130))
     {
       if(wKey<=2){
         MusicBox.playNote(60+wKey*2,1000);
       }
       if(wKey >= 3 && wKey<=6){
         MusicBox.playNote(60+wKey*2-1,1000);
       }
       if(wKey==7){
         MusicBox.playNote(60+wKey*2-2,1000);
       }
     }
  }
    
     
      
  for (int bKey=0; bKey<6; bKey++)
  {
    //noStroke();
    float keyHeight= wWidth*(bKey+1)- bWidth/2;
    if (bKey==2)
    {
      keyHeight= wWidth*(bKey+1)-bWidth/2+wWidth;
    }
    if (mouseX > keyHeight && mouseX <= keyHeight + bWidth && mouseY <= bHeight
      && mousePressed)
      {
        if (bKey <= 1)
        {
          MusicBox.playNote(61+(bKey*2), 1000);
        }
        if (bKey >= 3)
        {
          MusicBox.playNote(60+(bKey*2), 1000);
        }
      }
    
    } 
  }
public void settings(){
  size(700,600);  
}

}
