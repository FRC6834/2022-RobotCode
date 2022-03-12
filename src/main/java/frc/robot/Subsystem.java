package frc.robot;

//Imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//Subsystem class is general - specific methods for each subsystem
public class Subsystem {
    
    //Class Variables
    private CANSparkMax climbMotor = new CANSparkMax(7, MotorType.kBrushless);
    private CANSparkMax flyWheel = new CANSparkMax(5, MotorType.kBrushed);
    private CANSparkMax lowWheel = new CANSparkMax(8, MotorType.kBrushless);
    private CANSparkMax intake = new CANSparkMax(9, MotorType.kBrushed);
   
    
    
    //Constructor will be called in Robot.java to create Subsystem object
    public Subsystem(){}

    //Climb method - EG 1.15.22 - Needs tested
    //Will raise and lower the winch that helps climb
    //The boolean up and down will be button values
    //Ex: If X is pressed the winch raises and if Y is pressed it lowers.
    //.set(double) - may need to adjust value to make faster/slower
    //May need to invert values if not behaving as intended (up may need to be - and down +)
    /* 
     *brake will be used to help keep the robot from lower during the end game
     *not sure how it works, so we have to do some testing - EG 1.15.22
    */

    //I'd like to build a fail safe into the brake such as "hold lb and press b" so it isn't hit accidentally
    public void climb(boolean up, boolean down, boolean brake){
        if(up){
            climbMotor.set(0.75); 
        }
        else if(down){
            climbMotor.set(-0.75);
        }
        else if(brake){
            climbMotor.setIdleMode(IdleMode.kBrake);
        }
        else{
            climbMotor.set(0);
        }
    }
    //C-Shooter Code
    //Controls top wheel
    public void flyWheel(boolean shoot, boolean shootSlow){
        if(shoot){
            flyWheel.set(.95);
        }
        else if(shootSlow){
            flyWheel.set(.88);
        }
        else{
            flyWheel.set(0);
        }       
    }
    
    //Controls low wheel
    public void lowWheel(boolean feed){
        if(feed){
            lowWheel.set(-.3);
        }
        else{
            lowWheel.set(0);
        }
    }
    
    //Intake
    public void intake(boolean in){
        if(in){
            intake.set(0.75);
        }
        else{
            intake.set(0);
        }
    }
}
