package frc.robot; 
//--------------------------------------------------------------------------------imports------------
/* These are all imports, from WPI/ Worchester Polytechnic Institution, a 
university that works with FIRST to create recources for us to code. 
Essentailly these imports create new syntax and commands for us to use. 
For example, we can initaiate pnuematics and motors with more ease as
the roborio undersatnds thses libraries */ 

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;

/*Here is our robot class. It's function, is controlling the robot*/ 
public class Robot extends TimedRobot { 

  /*In this part we are establishing our variables. In other words 
  we are saying what our robot has(motors, pnuematics, ect.) that 
  we wold like to control.*/ 
  //---------------------------------------------------------------------------objects-------------- 
  /*Follow the below code to establish a joystick/controller. In this case 
  its a logitec controller which is reminiscent of a ps4 controller. A Joystick
  has buttons and joysticks, one can push and move. Your computer will be 
  able to send those values to the robot via a router. Therefore you can program
  the robot to do ertain things when the controller is manipulated in a certain 
  way. This controller is programmed in athe variable for of "Joystick", is
  named Joystick, and on the Driver station is plugged into port zero*/
  Joystick joystick = new Joystick(0); 
  //drive motors  
  /*Hold up, these are not int, doubles,ect. There Victor, Compressor, and Solenoid
  Dont worry they work the same except these dont hold values of numbers or strings, 
  but are motor controllers. Victor is a kind of motor controller, and there are many 
  kinds, so the variable type depends on what you are using. After naming it the 
  variable, continue with the syntax and in the parenthesis the numerical value
  is what "port" the motor controller is plugged into. If its on pwm for theroborio
  use the number it correspons to. If its on CAN you will need to use Pheonix turner
  to determine this number. The same thing applies to solenoids and Compressor, but
  these numerical values, like the roborio are determined through the labled ports on
  the pnuematic contol module*/
  Victor LF = new Victor(1); 
  Victor LB = new Victor(3);
  Victor RF = new Victor(5);
  Victor RB = new Victor(7);   
  Victor flywheel = new Victor(0);  
  //compressor, solenoids, cylinders 
  Compressor compress = new Compressor(0);
  Solenoid rocketone = new Solenoid(4);
  Solenoid rockettwo = new Solenoid(5);
  Solenoid spider = new Solenoid(2); 
  //----------------------------------------------------------------------------------------------------
  /* These are different methods. Think of Methods as mini classes within a class. 
  They all serve a purpose. For example there is a method that is in charge of running 
  automous when automous = true and one in charge of running Teleop(Driver controlled) 
  during the Teleop period.*/
@Override
  public void robotInit() { 
  
  }
  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {
  }
  @Override
  public void autonomousPeriodic() {
  }
  //---------------------------------------------------------------------------Driver Contolled------------------ 
  /*This is the Teleop class in which we will create our controls for the robot. First
  lets think about what we are coding. In this first ocasion we are programming a drive 
  base, and for this robot it happens to be a West Coast Drive(Not sure what it is? Look 
  it up!) This means two motors on each side. We are going to be programming this so that 
  each side of the drive will be contolled by one joystick. Let's now create a variable 
  to hold our left and right speeds. These vriable will be equal to the amount of power 
  multiplied by the joystick value. The amount of power ranges from 1 to -1, is a double 
  value, 1 = full power fowards, 0= no power, -1= full power backwards(reverse polarity). 
  A joystick ranges from 0 to numerous values, all the way to max values, in other words, 
  a joystick produces a double value as well. Next lets set each drive motor, which you 
  established earlier as plugged ibnbto a victor motor controller, to either have a speed 
  equal to the left speed or right speed depending on the side the motor is located to. 
  Look at the actual code for clarity*/ 

  @Override
  public void teleopPeriodic() { 
   //drive 
   final double leftspeed = -0.9*joystick.getRawAxis(1); 
   final double rightspeed = 0.9*joystick.getRawAxis(5); 
   //left drive
   LF.set(leftspeed); 
   LB.set(leftspeed);  
   //rigt drive
   RF.set(rightspeed); 
   RB.set(rightspeed);    

   //----------------------------------------------------------------------------------------------------- 
   /* Now its time to program the solenoids. They follow similar rules to motors. However since these are 
   being contolled by buttons not joysticks, we will be using aan if else staement. A solenoid can only be 
   on or off, so it will hold a bolean value. If its true the solenoid will be triggered, if false, it will
   not release air. The if stement looks for the condition of the joystick's button number 4 to be pressed
   (Botton values and joysticks are determined in Driver Station) until rocketone realeases air. else holds
   code that does not realse air. That means the condition for air to be realed is for Button 4 to be true 
   Look at the code for further clarity*/  

    // rocket1
   if(joystick.getRawButton(4)){ 
    rocketone.set(true); 
  } 
  else{ 
    rocketone.set(false); 
  }   
//------------------------------------------------------------------------------------------------------------ 
//see above
  //rocket2
  if(joystick.getRawButton(3)){ 
      rockettwo.set(true);
  }  
  else{ 
      rockettwo.set(false);  
  }
  //------------------------------------------------------------------------------------------------------------
  //see above
    if (joystick.getRawButton(1)) {
    spider.set(true); 
  } 
  else{ 
    spider.set(false); 
  }    
//----------------------------------------------------------------------------------------------------------------- 
/*This is very similar to the solenoid example. Except this time we have an added else if. That is because a motor 
does not hold a bolean value or even int as it hold value from -1 to 1. That emasn 0.9 is a possibility. This 
also ppens ths possibilty of the usage of several buttons to spin the motor at various speeds, either fowards or 
backwards. This if else statemnt is common among many usages of motors. Take a look at the code for clarity.*/
//Fly wheel
  if(joystick.getRawButton(5)){ 
     flywheel.set(1); 
  } 
  else if(joystick.getRawButton(6)) { 
  flywheel.set(-1);   
  }  
  else{ 
   flywheel.set(0); 
  } 
  //Notice how many curly braces there are. Keep track of them. For every open one there must be a closed one
  }  
  @Override
  public void testPeriodic() {
  }
}
