// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Pneumatics;
public class RobotContainer {
  private final Joystick driver = new Joystick(0);

  private final int yAxis = 1;
  private final int zRotation = 2;
  private final JoystickButton sequential = new JoystickButton(driver, 1);
  private final JoystickButton cannon1 = new JoystickButton(driver, 7);
  private final JoystickButton cannon2 = new JoystickButton(driver, 8);
  private final JoystickButton cannon3 = new JoystickButton(driver, 9);
  private final JoystickButton cannon4 = new JoystickButton(driver, 10);
  private final JoystickButton cannon5 = new JoystickButton(driver, 11);
  private final JoystickButton cannon6 = new JoystickButton(driver, 12);
  private final POVButton linUp = new POVButton(driver, 0);
  private final POVButton linDown = new POVButton(driver, 180);
  private final JoystickButton power = new JoystickButton(driver, 4);

  private final Drive drive = new Drive();
  private final Pneumatics pneumatics = new Pneumatics();

  public RobotContainer() {
    drive.setDefaultCommand(new TeleopDrive(drive,
     () -> -driver.getRawAxis(yAxis),
     () -> -driver.getRawAxis(zRotation)
    ));

    configureBindings();
  }

  private void configureBindings() {
    sequential.onTrue(new InstantCommand(() -> pneumatics.actuateSequentially()));
    cannon1.onTrue(new InstantCommand(() -> pneumatics.actuate1()));
    cannon2.onTrue(new InstantCommand(() -> pneumatics.actuate2()));
    cannon3.onTrue(new InstantCommand(() -> pneumatics.actuate3()));
    cannon4.onTrue(new InstantCommand(() -> pneumatics.actuate4()));
    cannon5.onTrue(new InstantCommand(() -> pneumatics.actuate5()));
    cannon6.onTrue(new InstantCommand(() -> pneumatics.actuate6()));
    linUp.onTrue(new InstantCommand(() -> pneumatics.linearUp()));
    linDown.onTrue(new InstantCommand(() -> pneumatics.linearDown()));
    power.onTrue(new InstantCommand(() -> pneumatics.linearStop()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
