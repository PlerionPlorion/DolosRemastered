// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  VictorSP LeftMotor;
  VictorSP RightMotor;
  DifferentialDrive tank;
  /** Creates a new Drive. */
  public Drive() {
    LeftMotor = new VictorSP(0);
    RightMotor = new VictorSP(1);
    tank = new DifferentialDrive(LeftMotor, RightMotor);
  }

  public void drive(double ySpeed, double zRotation){
    tank.arcadeDrive(ySpeed, zRotation);
    tank.feed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
