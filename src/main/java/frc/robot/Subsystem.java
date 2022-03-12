package frc.robot;

//Imports
/* Not currently using with 2022 build
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
*/
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//Subsystem class is general - specific methods for each subsystem
public class Subsystem {
    
    //Class Variables
    //private CANSparkMax climbMotor = new CANSparkMax(8, MotorType.kBrushless);
    // Save for future use
    //private CANSparkMax everyBotIntakeMotor = new CANSparkMax(6, MotorType.kBrushless);
    //private CANSparkMax everyBotArmMotor = new CANSparkMax(7, MotorType.kBrushless);
    private CANSparkMax cShooterMotor = new CANSparkMax(5, MotorType.kBrushed);
    private CANSparkMax cShooterMotorLow = new CANSparkMax(8, MotorType.kBrushless);
    //private CANSparkMax cShooterIntakeMotor = new CANSparkMax(8, MotorType.kBrushless);
    
    
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
    /*public void climb(boolean up, boolean down, boolean brake){
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
    }*/

    /* Save for future use
    //EveryBot Code
    //Code for everyBot intake
    public void everyBotIntake(boolean in, boolean out){
        if(in){
            everyBotIntakeMotor.set(0.75);
        }
        else if(out){
            everyBotIntakeMotor.set(-0.75);
        }
        else{
            everyBotIntakeMotor.set(0);
        }
    }    
    //Code for everyBot arm
    public void everyBotArm(boolean up, boolean down){
        if(up){
            everyBotArmMotor.set(0.75);
        }
        else if(down){
            everyBotArmMotor.set(-0.75);
        }
        else{
            everyBotArmMotor.set(0);
        }
    }
*/
    //C-Shooter Code
    //Controls shooter on cShooter Robot
    public void cShooter(boolean shoot){
        if(shoot){
            cShooterMotor.set(1);
        }
        else{
            cShooterMotor.set(0);
        }
    }
    public void cShooterLow(boolean shoot){
        if(shoot){
            cShooterMotorLow.set(-.75);
        }else{
            cShooterMotorLow.set(0);
        }
    }
    //Controls intake on cShooter Robot
    /*public void cShooterIntake(boolean in){
        if(in){
            cShooterIntakeMotor.set(1);
        }
        else{
            cShooterIntakeMotor.set(0);
        }
    }
    */
}
