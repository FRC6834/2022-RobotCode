package frc.robot;

//Imports
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//Subsystem class is general - specific methods for each subsystem
public class Subsystem {
    
    //Climber Spin Variables
    private CANSparkMax climbMotor = new CANSparkMax(5, MotorType.kBrushless);
    
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
            climbMotor.set(0.5); 
        }
        else if(down){
            climbMotor.set(-0.5);
        }
        else if(brake){
            climbMotor.setIdleMode(IdleMode.kBrake);
        }
    }
}
