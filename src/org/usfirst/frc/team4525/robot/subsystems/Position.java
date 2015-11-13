package org.usfirst.frc.team4525.robot.subsystems;

import org.usfirst.frc.team4525.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Position extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Gyro gyro = new Gyro(RobotMap.gyroIn);
	Encoder encoder = new Encoder(RobotMap.encoderSignalA, RobotMap.encoderSignalB, true, EncodingType.k4X);
	
	public int angle() {
		return (int)gyro.getAngle();
	}
	
	public int distance() {
		return (int)encoder.getDistance();
	}
	
	public boolean direction() {
		return encoder.getDirection();
	}
	
	public void reset() {
		encoder.setDistancePerPulse(RobotMap.encoderPulseMultiplier);
		gyro.reset();
		encoder.reset();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

