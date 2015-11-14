package Autos;

import org.usfirst.frc.team4525.robot.commands.Claw;
import org.usfirst.frc.team4525.robot.commands.ClawTilt;
import org.usfirst.frc.team4525.robot.commands.WinchBrake;
import org.usfirst.frc.team4525.robot.commands.WinchPosition;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrepareToNoodle extends CommandGroup {
    
    public  PrepareToNoodle() {
    	addSequential(new ClawTilt(ClawTilt.Position.UP));
    	Timer.delay(0.5);
    	// Grab the Bin
    	addSequential(new Claw(Claw.Position.GRIP));
    	Timer.delay(4);
    	// Rise to the top:
    	addSequential(new WinchPosition(2000));
    	addSequential(new WinchBrake());
    }
}
